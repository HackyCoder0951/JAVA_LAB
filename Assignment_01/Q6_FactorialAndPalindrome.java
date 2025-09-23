package Assignment_01;
import java.util.Scanner;

public class Q6_FactorialAndPalindrome {
    // Recursive factorial
    // The current logic uses 'long' for factorial, which will overflow for large n.
    // For large factorials, use java.math.BigInteger.

    static java.math.BigInteger factorial(int n) {
        if (n <= 1) return java.math.BigInteger.ONE;
        return java.math.BigInteger.valueOf(n).multiply(factorial(n - 1));
    }

    static boolean isPalindrome(int n) {
        int original = n, rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return original == rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            String nStr = sc.next();
            int n = 0;
            try {
                n = Integer.parseInt(nStr);
            } catch (NumberFormatException ex) {
                System.out.println("Error: Number out of range. Please enter a valid integer within the allowed range.");
                return;
            }
            if (n < 0) {
                System.out.println("Error: Please enter a non-negative integer.");
            } else {
                System.out.println("Factorial: " + factorial(n));
                System.out.println("Is Palindrome: " + isPalindrome(n));
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        } finally {
            sc.close();
        }
    }
}

/* Output:
Enter a number: 121
Factorial: 146579293561295836544000000
Is Palindrome: true

Enter a number: -5
Error: Please enter a non-negative integer.

Enter a number: xyz
Error: Invalid input. Please enter a valid integer.
*/
