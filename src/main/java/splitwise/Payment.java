package splitwise;

import java.util.HashMap;

public class Payment extends Expense {
    private PaymentMode mode;

    public Payment(User user, double amount, PaymentMode mode, User settledUser) throws Exception {
        super(user, amount, mode.toString(), new HashMap<User, Double>() {{
            put(settledUser, amount);
        }}, ShareType.FIXED_AMOUNT);
    }


    @Override
    boolean isSettlement() {
        return true;
    }
}
