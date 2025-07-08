package Assignment_01;
import java.util.Scanner;

/**
 * Q1_SumOfNNaturalNumbers
 * Demonstrates four ways to calculate the sum of first N natural numbers:
 * 1. Iterative (local method)
 * 2. Recursive (local method)
 * 3. Iterative (using LabUtils module)
 * 4. Recursive (using LabUtils module)
 */
public class Q1_SumOfNNaturalNumbers {
    /**
     * Calculates sum of first n natural numbers using an iterative approach (local method).
     * @param n the number up to which sum is calculated
     * @return sum of first n natural numbers
     */
    static int sumIterative(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i; // Add each number from 1 to n
        return sum;
    }

    /**
     * Calculates sum of first n natural numbers using recursion (local method).
     * @param n the number up to which sum is calculated
     * @return sum of first n natural numbers
     */
    static int sumRecursive(int n) {
        if (n == 0) return 0; // Base case: sum of 0 is 0
        return n + sumRecursive(n - 1); // Recursive case
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create Scanner object for input
        System.out.print("Enter N: ");
        int n = sc.nextInt(); // Read user input

        // Using local methods
        System.out.println("Sum (Iterative, Local): " + sumIterative(n));
        System.out.println("Sum (Recursive, Local): " + sumRecursive(n));

        // Using methods from LabUtils module
        System.out.println("Sum (Iterative, LabUtils): " + LabUtils.sumIterative(n));
        System.out.println("Sum (Recursive, LabUtils): " + LabUtils.sumRecursive(n));

        sc.close(); // Close the scanner
    }
}
