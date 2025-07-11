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
        int n = -1;

        while (true) {
            try {
                System.out.print("Enter N (1 to 1000): ");
                String nStr = sc.next();
                try {
                    n = Integer.parseInt(nStr);
                } catch (NumberFormatException ex) {
                    System.out.println("Error: Number out of range. Please enter a valid integer within the allowed range.");
                    System.out.println("Please try again...\n");
                    continue;
                }

                if (n < 1 || n > 1000) {
                    System.out.println("Error: Please enter a number between 1 and 1000.");
                    System.out.println("Please try again...\n");
                    continue;
                }

                System.out.println("Sum of first " + n + " natural numbers: " + sum(n));
                break; // Exit loop after successful input and output

            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
                sc.nextLine(); // Clear invalid input from buffer
            }
        }

        sc.close();
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
