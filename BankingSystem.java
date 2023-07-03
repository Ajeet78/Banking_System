import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingSystem {
    private Map<String, Double> accountBalances;

    public BankingSystem() {
        accountBalances = new HashMap<>();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        if (!accountBalances.containsKey(accountNumber)) {
            accountBalances.put(accountNumber, initialBalance);
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Account already exists with the given account number.");
        }
    }

    public void deposit(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double currentBalance = accountBalances.get(accountNumber);
            double updatedBalance = currentBalance + amount;
            accountBalances.put(accountNumber, updatedBalance);
            System.out.println("Deposit successful. Current balance: " + updatedBalance);
        } else {
            System.out.println("Account does not exist with the given account number.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double currentBalance = accountBalances.get(accountNumber);
            if (currentBalance >= amount) {
                double updatedBalance = currentBalance - amount;
                accountBalances.put(accountNumber, updatedBalance);
                System.out.println("Withdrawal successful. Current balance: " + updatedBalance);
            } else {
                System.out.println("Insufficient funds. Current balance: " + currentBalance);
            }
        } else {
            System.out.println("Account does not exist with the given account number.");
        }
    }

    public void inquireBalance(String accountNumber) {
        if (accountBalances.containsKey(accountNumber)) {
            double currentBalance = accountBalances.get(accountNumber);
            System.out.println("Current balance: " + currentBalance);
        } else {
            System.out.println("Account does not exist with the given account number.");
        }
    }

    public void transfer(String senderAccountNumber, String receiverAccountNumber, double amount) {
        if (accountBalances.containsKey(senderAccountNumber) && accountBalances.containsKey(receiverAccountNumber)) {
            double senderBalance = accountBalances.get(senderAccountNumber);
            double receiverBalance = accountBalances.get(receiverAccountNumber);
            if (senderBalance >= amount) {
                double updatedSenderBalance = senderBalance - amount;
                double updatedReceiverBalance = receiverBalance + amount;
                accountBalances.put(senderAccountNumber, updatedSenderBalance);
                accountBalances.put(receiverAccountNumber, updatedReceiverBalance);
                System.out.println("Transfer successful. Sender's current balance: " + updatedSenderBalance);
            } else {
                System.out.println("Insufficient funds. Sender's current balance: " + senderBalance);
            }
        } else {
            System.out.println("One or both accounts do not exist with the given account numbers.");
        }
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("_________BANKING SYSTEM________");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Inquiry");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    bankingSystem.createAccount(accountNumber, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankingSystem.deposit(accountNumber, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankingSystem.withdraw(accountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    bankingSystem.inquireBalance(accountNumber);
                    break;
                case 5:
                    System.out.print("Enter sender's account number: ");
                    String senderAccountNumber = scanner.next();
                    System.out.print("Enter receiver's account number: ");
                    String receiverAccountNumber = scanner.next();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    bankingSystem.transfer(senderAccountNumber, receiverAccountNumber, transferAmount);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}
