package main;

import java.util.Scanner;
import service.ATMService;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATMService atm = new ATMService();

        while (true) {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.println("7. Undo Last Transaction");
            System.out.println("8. Show Transaction History");
            System.out.println("9. Add Customer to Queue");
            System.out.println("10. Serve Next Customer");



            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter account number: ");
                        atm.createSavingsAccount(sc.next());
                    }
                    case 2 -> {
                        System.out.print("Enter account number: ");
                        atm.createCurrentAccount(sc.next());
                    }
                    case 3 -> {
                        System.out.print("Account number: ");
                        String acc = sc.next();
                        System.out.print("Amount: ");
                        atm.deposit(acc, sc.nextDouble());
                        System.out.println("Deposit successful");
                    }
                    case 4 -> {
                        System.out.print("Account number: ");
                        String acc = sc.next();
                        System.out.print("Amount: ");
                        atm.withdraw(acc, sc.nextDouble());
                        System.out.println("Withdraw successful");
                    }
                    case 5 -> {
                        System.out.print("Account number: ");
                        String acc = sc.next();
                        System.out.println("Balance: " + atm.checkBalance(acc));
                    }
                    case 6 -> {
                        System.out.println("Thank you for using ATM");
                        sc.close();
                        return;
                    }
                    case 7 -> {
                        System.out.print("Enter account number: ");
                        String accNo = sc.next();
                        try {
                            atm.undoLastTransaction(accNo);
                            System.out.println("Last transaction undone successfully!");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 8 -> {
                        System.out.print("Enter account number: ");
                        String accNo = sc.next();
                        try {
                            atm.printTransactionHistory(accNo);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                    case 9 -> {
                        System.out.print("Enter account number: ");
                        String accNo = sc.next();
                        atm.addCustomerToQueue(accNo);
                    }

                    case 10 -> {
                        atm.serveNextCustomer();
                    }

                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
