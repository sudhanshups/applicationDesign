package splitwise;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class Expense {
    private final int id;
    private final User user;
    private final double amount;
    private final String description;
    //private final String imageURL;
    private final Date date;
    private Map<User, Double> expenseShare ;
    private ShareType shareType;

    public Expense(User spendingUser, double amount, String description,
                   Map<User, Double> expenseShare, ShareType shareType) throws IncorrectExpenseRecord {
        this.id = IdGenerator.getId();
        this.user = spendingUser;
        this.amount = amount;
        this.description = description;
        this.date = new Date();
        this.shareType = shareType;
        if (ShareType.FIXED_AMOUNT.equals(shareType)) {
            if ((amount - expenseShare.values().stream().reduce(0d, Double::sum)) > 1d) {
                throw new IncorrectExpenseRecord("Incorrect record");
            }
            this.expenseShare = expenseShare;
        } else {
            this.expenseShare = shareAmountForUsersByPercentage( expenseShare);
        }
    }


    boolean isSettlement() {
        return false;
    }

    Map<User, Double> shareAmountForUsersByPercentage(Map<User, Double> shareAmountForUser) {
        //validate
        Map<User, Double> fixedSharesAmount = new HashMap<>();
        for(Map.Entry<User,Double> entry:shareAmountForUser.entrySet()){
            fixedSharesAmount.put(entry.getKey(), (entry.getValue()*100)/amount);
        }
        return fixedSharesAmount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", user=" + user.getName() +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", expenseShare=" + expenseShare +
                ", shareType=" + shareType +
                '}';
    }
}
