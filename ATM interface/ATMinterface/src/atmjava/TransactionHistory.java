package atmjava;


import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private List<String> transactions;

    public TransactionHistory() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(String operation, double amount) {
        transactions.add(operation + ": " + amount);
    }

    public void printHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transaction history.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}
