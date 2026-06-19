package SavingsAccount;

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double balance) {
        savingsBalance = balance;
    }
    

    public void calculateMonthlyInterest() {
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance = savingsBalance + monthlyInterest;
    }

    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }

    public double getBalance() {
        return savingsBalance;
    }
}
