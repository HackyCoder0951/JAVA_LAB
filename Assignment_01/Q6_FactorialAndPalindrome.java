package Assignment_01;
import java.util.Scanner;

public class Q6_FactorialAndPalindrome {
    // Recursive factorial
    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
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
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Factorial: " + factorial(n));
        System.out.println("Is Palindrome: " + isPalindrome(n));
        sc.close();
    }
}
