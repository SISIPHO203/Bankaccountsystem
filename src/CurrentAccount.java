// CurrentAccount.java
public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String ownerName, double initialBalance, double overdraftLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (balance - amount < -overdraftLimit) {
            throw new Exception("Withdrawal denied. Overdraft limit exceeded.");
        }
        super.withdraw(amount);
    }
}
