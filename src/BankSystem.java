import java.util.ArrayList;
import java.util.Scanner;


public class BankSystem {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Bank Account Management System");
        boolean running = true;

        while (running) {
            System.out.println("\n1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Show Balance");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            try {
                switch (choice) {
                    case 1 -> createSavingsAccount();
                    case 2 -> createCurrentAccount();
                    case 3 -> deposit();
                    case 4 -> withdraw();
                    case 5 -> showBalance();
                    case 6 -> {
                        System.out.println("Thank you for using the Bank System!");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void createSavingsAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        System.out.print("Enter interest rate: ");
        double interestRate = scanner.nextDouble();

        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(account);
        System.out.println("Savings Account created successfully.");
    }

    private void createCurrentAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        System.out.print("Enter overdraft limit: ");
        double overdraftLimit = scanner.nextDouble();

        CurrentAccount account = new CurrentAccount(accountNumber, ownerName, initialBalance, overdraftLimit);
        accounts.add(account);
        System.out.println("Current Account created successfully.");
    }

    private void deposit() {
        Account account = getAccount();
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }
    }

    private void withdraw() {
        Account account = getAccount();
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            try {
                account.withdraw(amount);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void showBalance() {
        Account account = getAccount();
        if (account != null) {
            account.showBalance();
        }
    }

    private Account getAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        for (Account acc : accounts) {
            if (acc.accountNumber.equals(accountNumber)) {
                return acc;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    public static void main(String[] args) {
        new BankSystem().start();
    }
}
