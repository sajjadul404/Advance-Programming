package Account;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {

        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            System.out.println("Error: Account Number cannot be null or empty.");
            this.accountNumber = "Invalid";
        } else {
            this.accountNumber = accountNumber;
        }

        if (balance < 0) {
            System.out.println("Error: Balance cannot be negative.");
            this.balance = 0.0;
        } else {
            this.balance = balance;
        }
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        Account acc1 = new Account("ACC101", 5000);

        Account acc2 = new Account("", 3000);

        Account acc3 = new Account("ACC103", -1000);

        Account acc4 = new Account(null, -500);

        System.out.println("Account 1:");
        acc1.display();

        System.out.println("Account 2:");
        acc2.display();

        System.out.println("Account 3:");
        acc3.display();

        System.out.println("Account 4:");
        acc4.display();
    }
}
