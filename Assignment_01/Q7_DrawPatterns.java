package Assignment_01;

import java.util.Scanner;

public class Q7_DrawPatterns {
    static void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter n for patterns: ");
            int n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Error: Please enter a positive integer for n.");
            } else {
                System.out.println("Pattern 1:");
                pattern1(n);
                System.out.println("Pattern 2:");
                pattern2(n);
                System.out.println("Pattern 3:");
                pattern3(n);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
            sc.next(); // Clear the invalid input
        } finally {
            sc.close();
        }
    }
}

/* Sample Output:
Enter n for patterns: 5
Pattern 1:
    * 
   * * 
  * * * 
 * * * * 
* * * * * 
Pattern 2:
    *
   **
  ***
 ****
*****
Pattern 3:
    *
   **
  ***
 ****
*****

Enter n for patterns: -2
Error: Please enter a positive integer for n.

Enter n for patterns: abc
Error: Invalid input. Please enter a valid integer.
*/
