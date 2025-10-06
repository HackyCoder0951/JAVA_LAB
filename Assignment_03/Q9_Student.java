package Assignment_03;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Student class representing a student's data and related operations.
 * Encapsulates fields and provides methods to compute total and grade.
 */
class Q9_Student {
    private int rollNo;
    private String name;
    private int marks1, marks2, marks3;

    // Constructor to initialize student object
    public Q9_Student(int rollNo, String name, int marks1, int marks2, int marks3) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    // Getters
    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getMarks1() {
        return marks1;
    }

    public int getMarks2() {
        return marks2;
    }

    public int getMarks3() {
        return marks3;
    }

    // Calculate total marks
    public int getTotal() {
        return marks1 + marks2 + marks3;
    }

    // Calculate grade based on average
    public String getGrade() {
        double avg = getTotal() / 3.0;
        if (avg >= 75)
            return "A";
        else if (avg >= 50)
            return "B";
        else
            return "C";
    }

    // Nicely formatted display string for this student
    @Override
    public String toString() {
        return String.format("Roll: %d | Name: %s | Marks: [%d, %d, %d] | Total: %d | Grade: %s",
                rollNo, name, marks1, marks2, marks3, getTotal(), getGrade());
    }
}

/**
 * Main runner class with menu to manage multiple students.
 */
public class Q9_StudentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Q9_Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Management System ===");

        boolean exit = false;
        while (!exit) {
            // Menu
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Show Topper (highest total)");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = readIntInRange(sc, 1, 4);

            switch (choice) {
                case 1:
                    // Add a new student with validated inputs
                    System.out.println("\n-- Add Student --");
                    int roll = readPositiveInt(sc, "Enter Roll Number: ");

                    // Read name (non-empty)
                    String name = readNonEmptyString(sc, "Enter Student Name: ");

                    // Read three marks with validation 0..100
                    int m1 = readMarks(sc, "Enter Marks for Subject 1 (0-100): ");
                    int m2 = readMarks(sc, "Enter Marks for Subject 2 (0-100): ");
                    int m3 = readMarks(sc, "Enter Marks for Subject 3 (0-100): ");

                    // Create and add student
                    Q9_Student s = new Q9_Student(roll, name, m1, m2, m3);
                    students.add(s);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    // Display all students
                    System.out.println("\n=== All Students ===");
                    if (students.isEmpty()) {
                        System.out.println("No students available. Add some first.");
                    } else {
                        int i = 1;
                        for (Q9_Student st : students) {
                            System.out.println((i++) + ". " + st.toString());
                        }
                    }
                    break;

                case 3:
                    // Find topper(s) by maximum total marks
                    System.out.println("\n=== Topper(s) ===");
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        int maxTotal = Integer.MIN_VALUE;
                        // find maximum total
                        for (Q9_Student st : students) {
                            if (st.getTotal() > maxTotal) {
                                maxTotal = st.getTotal();
                            }
                        }
                        // display all students who have that total (handles ties)
                        for (Q9_Student st : students) {
                            if (st.getTotal() == maxTotal) {
                                System.out.println(st.toString());
                            }
                        }
                    }
                    break;

                case 4:
                    // Exit program
                    exit = true;
                    System.out.println("\nExiting Student Grade Management System. Goodbye!");
                    break;

                default:
                    // Defensive: should not occur due to input validation
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close(); // close scanner
    }

    /* -------------------- Helper input methods -------------------- */

    // Read integer within inclusive range [min..max]
    private static int readIntInRange(Scanner sc, int min, int max) {
        while (true) {
            try {
                int val = sc.nextInt();
                sc.nextLine(); // consume newline
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

    // Read a positive integer (> 0)
    private static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int val = sc.nextInt();
                sc.nextLine(); // consume newline
                if (val <= 0) {
                    System.out.println("Value must be positive. Try again.");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.print("Invalid input! Please enter an integer: ");
                sc.nextLine();
            }
        }
    }

    // Read a non-empty string
    private static String readNonEmptyString(Scanner sc, String prompt) {
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

    // Read marks within 0..100
    private static int readMarks(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int val = sc.nextInt();
                sc.nextLine(); // consume newline
                if (val < 0 || val > 100) {
                    System.out.println("Marks must be between 0 and 100. Try again.");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.print("Invalid input! Please enter an integer between 0 and 100: ");
                sc.nextLine();
            }
        }
    }
}
