package splitwise;

import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {

        User u1 = new User("Alice");
        User u2 = new User("Bob");
        User u3 = new User("Sam");
        Set<User> users = new HashSet<>(Arrays.asList(u1, u2, u3));
        Group group1 = new Group("Friends", users);

        //test Case Incorrect fixed Amount
        Map<User, Double> incorrectFixedShare = new HashMap<User, Double>() {{
            put(u1, 5d);
            put(u2, 10d);
            put(u3, 15d);
        }};
        try {
            Expense e0 = new Expense(u1, 40d, "water", incorrectFixedShare, ShareType.FIXED_AMOUNT);
            group1.recordPayment(e0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        group1.printSummary();

        //test Case fixed Amount
        Map<User, Double> fixedShare5 = new HashMap<User, Double>() {{
            put(u2, 50d);
            put(u3, 50d);
        }};
        Expense e5 = new Expense(u1, 100d, "water", fixedShare5, ShareType.FIXED_AMOUNT);
        group1.recordPayment(e5);
        group1.printSummary();

        /// ====
        //test Case Settle Balance
        Payment e6 = new Payment(u2, 25d, PaymentMode.CASH, u1);
        group1.recordPayment(e6);
        group1.printSummary();


        //test Case fixed Amount
        Map<User, Double> fixedShare7 = new HashMap<User, Double>() {{
            put(u2, 25d);
        }};
        Expense e7 = new Expense(u1, 25d, "water", fixedShare7, ShareType.FIXED_AMOUNT);
        group1.recordPayment(e7);
        group1.printSummary();
        printActivityLogs(group1.getActivityLogs());
        // =====


        //test Case percentShare
        Map<User, Double> percentShare = new HashMap<User, Double>() {{
            put(u1, 40d);
            put(u2, 20d);
            put(u3, 40d);
        }};
        Expense e1 = new Expense(u1, 100d, "food", percentShare, ShareType.PERCENTAGE);
        group1.recordPayment(e1);
        group1.printSummary();
        printActivityLogs(group1.getActivityLogs());

        //test Case fixed Amount
        Map<User, Double> fixedShare = new HashMap<User, Double>() {{
            put(u1, 5d);
            put(u2, 10d);
            put(u3, 15d);
        }};
        Expense e2 = new Expense(u1, 30d, "water", fixedShare, ShareType.FIXED_AMOUNT);
        group1.recordPayment(e2);
        group1.printSummary();


        //test Case fixed Amount2
        Map<User, Double> fixedShare2 = new HashMap<User, Double>() {{
            put(u1, 500d);
            put(u2, 1000d);
            put(u3, 1500d);
        }};
        Expense e3 = new Expense(u2, 3000d, "rent", fixedShare2, ShareType.FIXED_AMOUNT);
        group1.recordPayment(e3);
        group1.printSummary();

        printActivityLogs(group1.getActivityLogs());

        //test Case Settle Balance
        Payment e4 = new Payment(u1, 470d, PaymentMode.CASH, u2);
        group1.recordPayment(e4);
        group1.printSummary();

        printActivityLogs(group1.getActivityLogs());


    }

    private static void printActivityLogs(List<Expense> activityLogs) {
        String settlement = "Settlement";
        String expense = "Expense";

        for (Expense e : activityLogs) {
            String type = e.isSettlement() ? settlement : expense;
            System.out.println(type + " : " + e);

        }
    }
}
