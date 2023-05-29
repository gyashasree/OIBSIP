package atmjava;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("789456", "5236", 50000.0);
        ATM atm = new ATM(account);
        atm.start();
    }
}
