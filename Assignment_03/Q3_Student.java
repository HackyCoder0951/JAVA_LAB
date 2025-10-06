package Assignment_03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Simple Student class demonstrating:
 * - encapsulation (private fields)
 * - constructor initialization
 * - a display method
 * - a finalize() method to simulate destructor behavior
 *
 * NOTE: finalize() is deprecated in modern Java and its invocation is not guaranteed.
 * It's included here only because the original assignment asked for destructor simulation.
 */
class Student {
    // Private fields (encapsulation)
    private int rollNo;
    private String name;
    private double marks;

    /**
     * Constructor to initialize a student object.
     *
     * @param r roll number (int, must be > 0)
     * @param n student name (non-empty)
     * @param m marks (0.0 - 100.0)
     */
    Student(int r, String n, double m) {
        this.rollNo = r;
        this.name = n;
        this.marks = m;
    }

    /**
     * Display student details in a formatted manner.
     */
    void display() {
        System.out.println("\n=== Student Details ===");
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Marks   : " + marks);
    }

    /**
     * finalize() method to simulate destructor behaviour.
     * Reminder: JVM may or may not call finalize(); do not rely on it for critical resource release.
     */
    @Override
    protected void finalize() {
        System.out.println("finalize() called: Object destroyed for student: " + name);
    }
}

/**
 * Main class for Q3 — handles user interaction, input validation, and demonstrates GC eligibility.
 */
public class Q3_Student {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("=== Student Information System ===");

            // 1) Read and validate roll number (must be positive integer)
            int rollNo = 0;
            while (true) {
                try {
                    System.out.print("Enter Roll Number: ");
                    rollNo = input.nextInt();
                    if (rollNo <= 0) {
                        System.out.println("Roll number must be a positive integer. Try again.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ime) {
                    System.out.println("Invalid input! Please enter numeric digits for roll number.");
                    input.next(); // clear invalid token
                }
            }

            // Clear newline left by nextInt before reading string
            input.nextLine();

            // 2) Read and validate student name (non-empty)
            String name = "";
            while (true) {
                System.out.print("Enter Student Name: ");
                name = input.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty. Please enter a valid name.");
                    continue;
                }
                break;
            }

            // 3) Read and validate marks (0 - 100)
            double marks = 0.0;
            while (true) {
                try {
                    System.out.print("Enter Marks (0 - 100): ");
                    marks = input.nextDouble();
                    if (marks < 0.0 || marks > 100.0) {
                        System.out.println("Marks must be between 0 and 100. Try again.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ime) {
                    System.out.println("Invalid input! Please enter numeric value for marks.");
                    input.next(); // clear invalid token
                }
            }

            // Create student object using validated inputs
            Student s1 = new Student(rollNo, name, marks);

            // Display student details
            s1.display();

            // Make object eligible for garbage collection (simulate destruction)
            // NOTE: Calling System.gc() only *requests* GC. finalize() may or may not run.
            s1 = null;
            System.out.println("\nStudent object set to null and eligible for GC (requesting GC)...");
            System.gc(); // request garbage collection (not guaranteed)

            // Small pause to allow (if JVM chooses) finalize() to run — not required and not guaranteed
            try {
                Thread.sleep(500); // 0.5 seconds pause (optional)
            } catch (InterruptedException ie) {
                // ignore interruption
            }

        } catch (Exception e) {
            // Catch-all for any unexpected runtime exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Always close scanner to free system input resource
            input.close();
            System.out.println("\nThank you for using Student Information System!");
        }
    }
}
