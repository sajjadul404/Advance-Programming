package SavingsAccount;
public class Main{
    public static void main(String[] args) {

       
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        SavingsAccount.modifyInterestRate(0.03);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("After 1 month at 3% annual interest:");
        System.out.printf("Saver1 Balance: $%.2f%n", saver1.getBalance());
        System.out.printf("Saver2 Balance: $%.2f%n", saver2.getBalance());

        SavingsAccount.modifyInterestRate(0.04);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("\nAfter next month at 4% annual interest:");
        System.out.printf("Saver1 Balance: $%.2f%n", saver1.getBalance());
        System.out.printf("Saver2 Balance: $%.2f%n", saver2.getBalance());

    }
}