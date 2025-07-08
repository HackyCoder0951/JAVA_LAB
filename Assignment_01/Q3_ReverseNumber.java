package Assignment_01;
import java.util.Scanner;

public class Q3_ReverseNumber {
    static int reverseIterative(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
    static int reverseRecursive(int n, int rev) {
        if (n == 0) return rev;
        return reverseRecursive(n / 10, rev * 10 + n % 10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.println("Reverse (Iterative): " + reverseIterative(n));
        System.out.println("Reverse (Recursive): " + reverseRecursive(n, 0));
        sc.close();
    }
}

/*
Output:
Enter a number: 1234
Reverse (Iterative): 4321
Reverse (Recursive): 4321
*/