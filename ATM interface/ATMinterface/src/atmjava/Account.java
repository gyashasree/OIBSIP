package atmjava;


public class Account {
    private String userId;
    private String userPin;
    private double balance;
    private TransactionHistory transactionHistory;

    public Account(String userId, String userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
        this.transactionHistory = new TransactionHistory();
    }

    public boolean validatePin(String pin) {
        return userPin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.addTransaction("Deposit", amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.addTransaction("Withdraw", amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.addTransaction("Transfer to " + recipient.getUserId(), amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void printTransactionHistory() {
        transactionHistory.printHistory();
    }

    public String getUserId() {
        return userId;
    }
}
