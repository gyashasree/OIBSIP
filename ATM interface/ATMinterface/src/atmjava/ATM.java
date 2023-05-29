package atmjava;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ATM {
    private Account account;
    private Scanner scanner;

    public ATM(Account account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter user PIN: ");
        String userPin = scanner.nextLine();

        if (account.getUserId().equals(userId) && account.validatePin(userPin)) {
            System.out.println("Welcome, " + account.getUserId() + "!");
            showOptions();
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private void showOptions() {
        int choice = 0;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    transactionHistory();
                    break;
                case 6:
                    System.out.println("Thanks for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid entry. Please try again.");
            }
        } while (choice != 6);
    }

    private void viewBalance() {
        System.out.println("Your balance is:Rupees"+" 987" + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        account.deposit(amount);
        System.out.println("Deposit successful.");
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        account.withdraw(amount);
    }

    private void transfer() {
        System.out.print("Enter recipient's user ID: ");
        String recipientId = scanner.nextLine();
        System.out.print("Enter transfer amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

       
        Account recipient = getRecipientAccount(recipientId);
        if (recipient != null) {
            account.transfer(recipient, amount);
        } else {
            System.out.println("Recipient's account not found.");
        }
    }

    private void transactionHistory() {
        account.printTransactionHistory();
    }

    private Account getRecipientAccount(String recipientId) {
        
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("987654", "1234", 0.0));

        for (Account account : accounts) {
            if (account.getUserId().equals(recipientId)) {
                return account;
            }
        }

        return null; 
    }

}

