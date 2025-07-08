package Assignment_01;
import java.util.Scanner;

public class Q4_SumOfDigits {
    static int sumDigitsIterative(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    static int sumDigitsRecursive(int n) {
        if (n == 0) return 0;
        return n % 10 + sumDigitsRecursive(n / 10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.println("Sum of digits (Iterative): " + sumDigitsIterative(n));
        System.out.println("Sum of digits (Recursive): " + sumDigitsRecursive(n));
        sc.close();
    }
}

/*
Output:
Enter a number: 1234
Sum of digits (Iterative): 10
Sum of digits (Recursive): 10
*/