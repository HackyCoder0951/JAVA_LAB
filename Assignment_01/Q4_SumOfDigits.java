package Assignment_01;
import java.util.Scanner;

public class Q4_SumOfDigits {
    // Recursive function to calculate sum of digits
    static int sumDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            int n = sc.nextInt();
            System.out.println("Sum of digits: " + sumDigits(n));
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        } finally {
            sc.close();
        }
    }
}

/* Output:
Enter a number: 1234
Sum of digits: 10

Enter a number: xyz
Error: Invalid input. Please enter a valid integer.
*/
