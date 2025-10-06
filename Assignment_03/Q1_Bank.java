package Assignment_03;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * BankAccount class: encapsulates account data and provides deposit/withdraw methods.
 */
class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /* Getters and setters */
    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder;
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Deposit amount to account (only positive values allowed).
     *
     * @param amount amount to deposit
     * @return true if deposit successful, false otherwise
     */
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    /**
     * Withdraw amount if sufficient balance and positive amount.
     *
     * @param amount amount to withdraw
     * @return true if withdrawal successful, false otherwise
     */
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("AccountHolder: %s | AccountNo: %d | Balance: Rs. %.2f",
                accountHolder, accountNumber, balance);
    }
}

/**
 * Q1_Bank (enhanced) — menu-driven banking system supporting multiple accounts.
 */
public class Q1_Bank {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== BANKING SYSTEM ===");

        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = readIntInRange("Choose an option (1-6): ", 1, 6);
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositToAccount();
                    break;
                case 3:
                    withdrawFromAccount();
                    break;
                case 4:
                    showAccountDetails();
                    break;
                case 5:
                    listAllAccounts();
                    break;
                case 6:
                    exit = true;
                    System.out.println("\nExiting Banking System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }

    /* ---------- Menu & Helpers ---------- */

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Show Account Details (by account number)");
        System.out.println("5. List All Accounts");
        System.out.println("6. Exit");
    }

    /**
     * Create a new bank account with validated inputs.
     * Ensures account number is positive and unique, and initial balance >= 0.
     */
    private static void createAccount() {
        System.out.println("\n-- Create Account --");
        String name = readNonEmptyString("Enter Account Holder Name: ");

        int accNo;
        while (true) {
            accNo = readPositiveInt("Enter Account Number (numeric, positive): ");
            if (findAccount(accNo) != null) {
                System.out.println("Account number already exists. Please enter a unique account number.");
                continue;
            }
            break;
        }

        double initialBalance = readNonNegativeDouble("Enter Initial Balance (>= 0): ");
        BankAccount newAcc = new BankAccount(name, accNo, initialBalance);
        accounts.add(newAcc);
        System.out.println("Account created successfully.");
        System.out.println(newAcc);
    }

    /**
     * Deposit to an existing account after validating the amount.
     */
    private static void depositToAccount() {
        System.out.println("\n-- Deposit --");
        if (accounts.isEmpty()) {
            System.out.println("No accounts exist. Create an account first.");
            return;
        }

        int accNo = readPositiveInt("Enter Account Number to deposit into: ");
        BankAccount acc = findAccount(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        double amount = readPositiveDouble("Enter amount to deposit: ");
        if (acc.deposit(amount)) {
            System.out.printf("Deposited Rs. %.2f successfully. New Balance: Rs. %.2f%n", amount, acc.getBalance());
        } else {
            System.out.println("Deposit failed. Amount must be positive.");
        }
    }

    /**
     * Withdraw from an existing account, only if sufficient balance exists.
     */
    private static void withdrawFromAccount() {
        System.out.println("\n-- Withdraw --");
        if (accounts.isEmpty()) {
            System.out.println("No accounts exist. Create an account first.");
            return;
        }

        int accNo = readPositiveInt("Enter Account Number to withdraw from: ");
        BankAccount acc = findAccount(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        double amount = readPositiveDouble("Enter amount to withdraw: ");
        if (acc.withdraw(amount)) {
            System.out.printf("Withdrawn Rs. %.2f successfully. New Balance: Rs. %.2f%n", amount, acc.getBalance());
        } else {
            System.out.println("Withdrawal failed. Either amount is invalid or insufficient balance.");
            System.out.printf("Available balance: Rs. %.2f%n", acc.getBalance());
        }
    }

    /**
     * Show details of a single account by account number.
     */
    private static void showAccountDetails() {
        System.out.println("\n-- Show Account Details --");
        if (accounts.isEmpty()) {
            System.out.println("No accounts exist.");
            return;
        }
        int accNo = readPositiveInt("Enter Account Number: ");
        BankAccount acc = findAccount(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
        } else {
            System.out.println(acc);
        }
    }

    /**
     * List all accounts (if any).
     */
    private static void listAllAccounts() {
        System.out.println("\n-- All Accounts --");
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        int idx = 1;
        for (BankAccount a : accounts) {
            System.out.println((idx++) + ". " + a);
        }
    }

    /* ---------- Utility Input Methods ---------- */

    private static BankAccount findAccount(int accountNumber) {
        for (BankAccount a : accounts) {
            if (a.getAccountNumber() == accountNumber) {
                return a;
            }
        }
        return null;
    }

    // Read an integer within inclusive range
    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = sc.nextInt();
                sc.nextLine(); // consume newline
                if (val < min || val > max) {
                    System.out.printf("Please enter a number between %d and %d.%n", min, max);
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input! Please enter an integer.");
                sc.nextLine(); // clear invalid token
            }
        }
    }

    private static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = sc.nextInt();
                sc.nextLine();
                if (val <= 0) {
                    System.out.println("Value must be positive. Try again.");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input! Please enter an integer.");
                sc.nextLine();
            }
        }
    }

    private static double readNonNegativeDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = sc.nextDouble();
                sc.nextLine();
                if (val < 0) {
                    System.out.println("Value cannot be negative. Try again.");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            }
        }
    }

    private static double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = sc.nextDouble();
                sc.nextLine();
                if (val <= 0) {
                    System.out.println("Value must be greater than 0. Try again.");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("Input cannot be empty. Try again.");
                continue;
            }
            return s;
        }
    }
}
