package Assignment_01;
import java.util.Scanner;

public class Q6_FactorialAndPalindrome {
    static long factorialIterative(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
    static long factorialRecursive(int n) {
        if (n <= 1) return 1;
        return n * factorialRecursive(n - 1);
    }
    static boolean isPalindrome(int n) {
        int rev = 0, temp = n;
        while (temp != 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return n == rev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.println("Factorial (Iterative): " + factorialIterative(n));
        System.out.println("Factorial (Recursive): " + factorialRecursive(n));
        System.out.println("Is Palindrome: " + isPalindrome(n));
        if (isPalindrome(n)) {
            System.out.println(n + " is a palindrome.");
        } else {
            System.out.println(n + " is not a palindrome.");
        }
        sc.close();
    }
}