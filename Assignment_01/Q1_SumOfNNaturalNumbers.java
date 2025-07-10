package Assignment_01;
import java.util.Scanner;

public class Q1_SumOfNNaturalNumbers {
    // Recursive function to calculate sum
    static int sum(int n) {
        if (n <= 1)
            return n;
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter N: ");
            int n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Error: Please enter a positive integer greater than 0.");
            } else {
                System.out.println("Sum of first " + n + " natural numbers: " + sum(n));
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        } finally {
            sc.close();
        }
    }
}

/* Output:
Enter N: 5
Sum of first 5 natural numbers: 15

Enter N: -3
Error: Please enter a positive integer greater than 0.

Enter N: abc
Error: Invalid input. Please enter a valid integer.
*/
