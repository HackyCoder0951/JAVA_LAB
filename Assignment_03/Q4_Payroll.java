package Assignment_03;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Base Employee class.
 * Demonstrates inheritance and method overriding.
 */
class Employee {
    String name;
    double basicSalary;

    // Constructor to initialize base employee fields
    Employee(String n, double b) {
        this.name = n;
        this.basicSalary = b;
    }

    // Base salary calculation (can be overridden by subclasses)
    double calculateSalary() {
        return basicSalary;
    }

    // A readable representation for listing
    @Override
    public String toString() {
        return name + " (Basic: Rs. " + basicSalary + ")";
    }
}

/**
 * Manager subclass with an allowance.
 */
class Manager extends Employee {
    double allowance;

    Manager(String n, double b, double a) {
        super(n, b);
        this.allowance = a;
    }

    // Manager salary = basic + allowance
    @Override
    double calculateSalary() {
        return basicSalary + allowance;
    }

    @Override
    public String toString() {
        return "Manager: " + name + " | Basic: Rs. " + basicSalary + " | Allowance: Rs. " + allowance
                + " | Final: Rs. " + calculateSalary();
    }
}

/**
 * Programmer subclass with a deduction.
 */
class Programmer extends Employee {
    double deduction;

    Programmer(String n, double b, double d) {
        super(n, b);
        this.deduction = d;
    }

    // Programmer salary = basic - deduction
    @Override
    double calculateSalary() {
        return basicSalary - deduction;
    }

    @Override
    public String toString() {
        return "Programmer: " + name + " | Basic: Rs. " + basicSalary + " | Deduction: Rs. " + deduction
                + " | Final: Rs. " + calculateSalary();
    }
}

/**
 * Main class Q4_Payroll — menu-driven payroll manager.
 */
public class Q4_Payroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>(); // store multiple employees

        System.out.println("=== Payroll System ===");

        boolean exit = false;
        while (!exit) {
            // Main menu
            System.out.println("\nMenu:");
            System.out.println("1. Add Manager");
            System.out.println("2. Add Programmer");
            System.out.println("3. Show All Employees and Salaries");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = readIntInRange(sc, 1, 4);

            switch (choice) {
                case 1:
                    // Add Manager
                    System.out.println("\n-- Add Manager --");
                    String mName = readNonEmptyString(sc, "Enter Manager Name: ");
                    double mBasic = readPositiveDouble(sc, "Enter Basic Salary (Rs.): ");
                    double allowance = readNonNegativeDouble(sc, "Enter Allowance (Rs.): ");
                    employees.add(new Manager(mName, mBasic, allowance));
                    System.out.println("Manager added successfully.");
                    break;

                case 2:
                    // Add Programmer
                    System.out.println("\n-- Add Programmer --");
                    String pName = readNonEmptyString(sc, "Enter Programmer Name: ");
                    double pBasic = readPositiveDouble(sc, "Enter Basic Salary (Rs.): ");
                    double deduction = readNonNegativeDouble(sc, "Enter Deduction (Rs.): ");
                    employees.add(new Programmer(pName, pBasic, deduction));
                    System.out.println("Programmer added successfully.");
                    break;

                case 3:
                    // Display all employees and their final salaries
                    System.out.println("\n=== Employee Salary List ===");
                    if (employees.isEmpty()) {
                        System.out.println("No employees added yet.");
                    } else {
                        int idx = 1;
                        for (Employee e : employees) {
                            System.out.println(idx++ + ". " + e.toString());
                        }
                    }
                    break;

                case 4:
                    // Exit program
                    exit = true;
                    System.out.println("\nExiting Payroll System. Goodbye!");
                    break;

                default:
                    // Defensive: should never reach here due to input validation
                    System.out.println("Invalid option — try again.");
            }
        }

        sc.close();
    }

    /* -------------------- Helper input methods -------------------- */

    /**
     * Read an integer within inclusive [min..max]. Keeps prompting until valid.
     */
    private static int readIntInRange(Scanner sc, int min, int max) {
        while (true) {
            try {
                int val = sc.nextInt();
                sc.nextLine(); // consume trailing newline
                if (val < min || val > max) {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.print("Invalid input! Please enter an integer: ");
                sc.nextLine(); // clear invalid token
            }
        }
    }

    /**
     * Read a non-empty string (prompts with given message).
     */
    private static String readNonEmptyString(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }
            return s;
        }
    }

    /**
     * Read a positive double (> 0). Re-prompts on invalid input.
     */
    private static double readPositiveDouble(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double val = sc.nextDouble();
                sc.nextLine(); // consume newline
                if (val <= 0) {
                    System.out.println("Value must be greater than 0. Please try again.");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input! Please enter a numeric value.");
                sc.nextLine(); // clear invalid token
            }
        }
    }

    /**
     * Read a non-negative double (>= 0). Re-prompts on invalid input.
     */
    private static double readNonNegativeDouble(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double val = sc.nextDouble();
                sc.nextLine(); // consume newline
                if (val < 0) {
                    System.out.println("Value cannot be negative. Please try again.");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input! Please enter a numeric value.");
                sc.nextLine(); // clear invalid token
            }
        }
    }
}
