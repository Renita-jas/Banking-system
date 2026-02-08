package model;

import java.util.Stack;

public abstract class Account {

    protected String accountNumber;
    protected double balance;

    protected Stack<Transaction> transactions = new Stack<>();

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid deposit amount");
        }
        balance += amount;
        transactions.push(new Transaction("DEPOSIT", amount));
    }

    public abstract void withdraw(double amount) throws Exception;

    public double getBalance() {
        return balance;
    }

    public void undoLastTransaction() throws Exception {
        if (transactions.isEmpty()) {
            throw new Exception("No transaction to undo");
        }

        Transaction last = transactions.pop();

        if (last.getType().equals("DEPOSIT")) {
            balance -= last.getAmount();
        } else if (last.getType().equals("WITHDRAW")) {
            balance += last.getAmount();
        }
    }
    public void printTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet");
            return;
        }
        System.out.println("--- Transaction History ---");
        for (Transaction t : transactions) {
            System.out.println(t.getType() + ": " + t.getAmount());
        }
    }

}
