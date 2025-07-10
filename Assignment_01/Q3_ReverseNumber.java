package Assignment_01;
import java.util.Scanner;

public class Q3_ReverseNumber {
    static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            int n = sc.nextInt();
            System.out.println("Reversed number: " + reverse(n));
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        } finally {
            sc.close();
        }
    }
}

/* Output:
Enter a number: 1234
Reversed number: 4321

Enter a number: abc
Error: Invalid input. Please enter a valid integer.
*/
