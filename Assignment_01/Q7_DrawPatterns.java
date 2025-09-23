package Assignment_01;

import java.util.Scanner;

public class Q7_DrawPatterns {
    static void pattern1(int n) {
           for (int i = 1; i <= n; i++) {
            // leading spaces
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            // print (2*i - 1) stars
            for (int k = 1; k <= 2 * i - 1; k++) System.out.print("*");
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println(" ");
        }
    }

    static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            // leading spaces to push stars to right
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter n for patterns: ");
            String nStr = sc.next();
            int n = 0;
            int MAX_LIMIT = 1000;
            try {
                n = Integer.parseInt(nStr);
            } catch (NumberFormatException ex) {
                System.out.println("Error: Number out of range. Please enter a valid integer within the allowed range.");
                return;
            }
            if (n <= 0) {
                System.out.println("Error: Please enter a positive integer for n.");
            } else if (n > MAX_LIMIT) {
                System.out.println("Error: n cannot exceed " + MAX_LIMIT + ".");
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
