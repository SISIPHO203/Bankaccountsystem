// SavingsAccount.java
public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest applied. New balance: " + balance);
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (balance - amount < 500) {
            throw new Exception("Cannot withdraw. Minimum balance of 500 must be maintained.");
        }
        super.withdraw(amount);
    }
}
