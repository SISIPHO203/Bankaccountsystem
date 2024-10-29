
// Account.java
public class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient balance.");
        }
        if (amount <= 0) {
            throw new Exception("Invalid withdrawal amount.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }

    public void showBalance() {
        System.out.println("Account Balance: " + balance);
    }
}
