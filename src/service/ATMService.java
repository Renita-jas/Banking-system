package service;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;


import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;

public class ATMService {

    private Map<String, Account> accounts = new HashMap<>();

    public void createSavingsAccount(String accNo) {
        accounts.put(accNo, new SavingsAccount(accNo));
        System.out.println("Savings Account created");
    }

    public void createCurrentAccount(String accNo) {
        accounts.put(accNo, new CurrentAccount(accNo));
        System.out.println("Current Account created");
    }

    public void deposit(String accNo, double amount) throws Exception {
        Account acc = getAccount(accNo);
        acc.deposit(amount);
    }

    public void withdraw(String accNo, double amount) throws Exception {
        Account acc = getAccount(accNo);
        acc.withdraw(amount);
    }

    public double checkBalance(String accNo) throws Exception {
        return getAccount(accNo).getBalance();
    }

    public void undoLastTransaction(String accNo) throws Exception {
        Account acc = getAccount(accNo);
        acc.undoLastTransaction();
    }

    public void printTransactionHistory(String accNo) throws Exception {
        Account acc = getAccount(accNo);
        acc.printTransactionHistory();
    }

    private Queue<String> customerQueue = new LinkedList<>();

    public void addCustomerToQueue(String accNo) {
        customerQueue.add(accNo);
        System.out.println("Customer " + accNo + " added to queue");
    }

    public void serveNextCustomer() {
        if (customerQueue.isEmpty()) {
            System.out.println("No customers in queue");
            return;
        }
        String accNo = customerQueue.poll();
        System.out.println("Serving customer: " + accNo);
    }
    
    private Account getAccount(String accNo) throws Exception {
        if (!accounts.containsKey(accNo)) {
            throw new Exception("Account not found");
        }
        return accounts.get(accNo);
    }
}
