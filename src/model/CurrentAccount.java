package model;

public class CurrentAccount extends Account {

    private static final double OVERDRAFT_LIMIT = 10000;

    public CurrentAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid withdrawal amount");
        }

        if (balance - amount < -OVERDRAFT_LIMIT) {
            throw new Exception("Overdraft limit exceeded");
        }

        balance -= amount;
        transactions.push(new Transaction("WITHDRAW", amount));
    }
}
