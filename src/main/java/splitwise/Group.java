package splitwise;

import javafx.util.Pair;
import lombok.Data;

import java.util.*;

@Data
public class Group {
    private final int id;
    private String name;
    private Map<Integer, User> idToUsers;
    private List<Expense> activityLogs;
    private Map<Pair<Integer, Integer>, Double> user1PayUser2ToSettle;


    public Group(String name, Set<User> users) {
        this.id = IdGenerator.getId();
        this.name = name;
        this.idToUsers = new HashMap<>();
        Optional.ofNullable(users).orElse(new HashSet<>()).stream().forEach(u -> idToUsers.put(u.getId(), u));
        this.activityLogs = new LinkedList<>();
        user1PayUser2ToSettle = new HashMap<>();
    }

    boolean addUser(User user) {
        idToUsers.put(user.getId(), user);
        return true;
    }

    void recordPayment(final Expense expense) {
        activityLogs.add(expense);
        updateSummary(expense);
    }

    void printSummary() {
        System.out.println("--------------------");
        System.out.println("Printing Summary");
        user1PayUser2ToSettle.forEach((k, v) ->
                System.out.println("User: " + idToUsers.get(k.getKey()) + " own Amount: " + v +
                        " to User: " + idToUsers.get(k.getValue()))

        );
        System.out.println("--------------------");
    }

    private void updateSummary(Expense expense) {
        Integer spendingUser = expense.getUser().getId();
        for (Map.Entry<User, Double> entry : expense.getExpenseShare().entrySet()) {
            Integer spendedOnUser = entry.getKey().getId();
            if (spendingUser == spendedOnUser) {
                continue;
            } else if (spendingUser < spendedOnUser) {
                Pair<Integer, Integer> key = new Pair<>(spendingUser, spendedOnUser);
                if (!user1PayUser2ToSettle.containsKey(key)) {
                    user1PayUser2ToSettle.put(key, 0d);
                }
                user1PayUser2ToSettle.put(key, user1PayUser2ToSettle.get(key) - entry.getValue());
            } else {
                Pair<Integer, Integer> key = new Pair<>(spendedOnUser, spendingUser);
                if (!user1PayUser2ToSettle.containsKey(key)) {
                    user1PayUser2ToSettle.put(key, 0d);
                }
                user1PayUser2ToSettle.put(key, user1PayUser2ToSettle.get(key) + entry.getValue());
            }
        }
    }

}
