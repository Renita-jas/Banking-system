package model;

public class SavingsAccount extends Account {

    private static final double MIN_BALANCE = 500;

    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid withdrawal amount");
        }

        if (balance - amount < MIN_BALANCE) {
            throw new Exception("Minimum balance of 500 must be maintained");
        }

        balance -= amount;
        transactions.push(new Transaction("WITHDRAW", amount));
    }
}
