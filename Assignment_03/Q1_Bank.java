package Assignment_03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class representing a simple bank account with basic operations.
 */
class BankAccount {
    // private fields (encapsulation)
    private String accountHolder;
    private int accountNumber;
    private double balance;

    /**
     * Constructor to initialize BankAccount object.
     *
     * @param accountHolder name of the account holder
     * @param accountNumber account number (int)
     * @param balance       initial balance
     */
    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /* -------------------- getters & setters -------------------- */

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /* -------------------- deposit & withdraw -------------------- */

    /**
     * Deposit amount to the account. Only positive deposits allowed.
     *
     * @param amount amount to deposit
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            // Validate amount
            System.out.println("Deposit amount must be positive!");
            return;
        }
        balance += amount;
        System.out.println("Deposited: Rs. " + amount);
    }

    /**
     * Withdraw amount from the account if sufficient funds exist.
     *
     * @param amount amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return;
        }
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs. " + amount);
        } else {
            System.out.println("Insufficient balance! Available: Rs. " + balance);
        }
    }
}

/**
 * Main class for Q1 — handles user interaction and calls BankAccount methods.
 */
public class Q1_Bank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("=== WELCOME TO THE BANK ACCOUNT PROGRAM ===");
            // Read account holder name
            System.out.print("Enter Account Holder Name: ");
            String name = input.nextLine().trim();

            // Read and validate account number (must be positive integer)
            int accNo = 0;
            while (true) {
                try {
                    System.out.print("Enter Account Number (numeric): ");
                    accNo = input.nextInt();
                    if (accNo <= 0) {
                        System.out.println("Account number must be a positive integer. Try again.");
                        continue;
                    }
                    break; // valid account number
                } catch (InputMismatchException ime) {
                    System.out.println("Invalid input! Please enter numeric digits for account number.");
                    input.next(); // clear invalid token
                }
            }

            // Read and validate initial balance (must be >= 0)
            double balance = 0.0;
            while (true) {
                try {
                    System.out.print("Enter Initial Balance (Rs.): ");
                    balance = input.nextDouble();
                    if (balance < 0) {
                        System.out.println("Balance cannot be negative. Try again.");
                        continue;
                    }
                    break; // valid balance
                } catch (InputMismatchException ime) {
                    System.out.println("Invalid input! Please enter a valid decimal number for balance.");
                    input.next(); // clear invalid token
                }
            }

            // Create account object with user inputs
            BankAccount account = new BankAccount(name, accNo, balance);
            System.out.println("\nAccount created successfully!");
            System.out.println("Account Holder : " + account.getAccountHolder());
            System.out.println("Account Number : " + account.getAccountNumber());
            System.out.println("Current Balance: Rs. " + account.getBalance());

            // Offer deposit operation
            while (true) {
                System.out.print("\nDo you want to deposit money? (yes/no): ");
                input.nextLine(); // consume newline left by nextDouble/nextInt
                String resp = input.nextLine().trim();
                if (resp.equalsIgnoreCase("yes") || resp.equalsIgnoreCase("y")) {
                    // deposit amount
                    while (true) {
                        try {
                            System.out.print("Enter amount to deposit (Rs.): ");
                            double amt = input.nextDouble();
                            account.deposit(amt);
                            break;
                        } catch (InputMismatchException ime) {
                            System.out.println("Invalid amount! Please enter a number.");
                            input.next();
                        }
                    }
                    break;
                } else if (resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Please answer yes or no.");
                }
            }

            // Offer withdrawal operation
            while (true) {
                System.out.print("\nDo you want to withdraw money? (yes/no): ");
                String resp = input.nextLine().trim();
                if (resp.equalsIgnoreCase("yes") || resp.equalsIgnoreCase("y")) {
                    // withdraw amount
                    while (true) {
                        try {
                            System.out.print("Enter amount to withdraw (Rs.): ");
                            double amt = input.nextDouble();
                            account.withdraw(amt);
                            break;
                        } catch (InputMismatchException ime) {
                            System.out.println("Invalid amount! Please enter a number.");
                            input.next();
                        }
                    }
                    break;
                } else if (resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Please answer yes or no.");
                }
            }

            // Final summary
            System.out.println("\n=== ACCOUNT SUMMARY ===");
            System.out.println("Account Holder : " + account.getAccountHolder());
            System.out.println("Account Number : " + account.getAccountNumber());
            System.out.println("Final Balance  : Rs. " + account.getBalance());

        } catch (Exception e) {
            // Catch any unexpected exceptions to prevent abrupt crash
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Ensure scanner gets closed
            input.close();
            System.out.println("\nThank you for using the Bank Account Program!");
        }
    }
                }
