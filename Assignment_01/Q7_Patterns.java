package Assignment_01;
import java.util.Scanner;

/**
 * Q7_Patterns
 * Demonstrates printing three different star patterns using LabUtils module methods.
 */
public class Q7_Patterns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Prompt user for number of rows
        System.out.print("Enter number of rows for patterns (n): ");
        int n = sc.nextInt();

        // Print Pattern 1
        System.out.println("\nPattern 1 (Pyramid with spaces and stars):");
        LabUtils.pattern1(n);

        // Print Pattern 2
        System.out.println("\nPattern 2 (Left-aligned triangle of stars):");
        LabUtils.pattern2(n);

        // Print Pattern 3
        System.out.println("\nPattern 3 (Same as Pattern 2 for assignment completeness):");
        LabUtils.pattern3(n);

        sc.close();
    }
}
