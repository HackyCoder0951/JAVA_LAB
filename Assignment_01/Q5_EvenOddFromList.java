package Assignment_01;
import java.util.Scanner;

public class Q5_EvenOddFromList {
    static void printEvenOdd(int[] arr) {
        for (int num : arr) {
            if (num % 2 == 0)
                System.out.println(num + " is Even");
            else
                System.out.println(num + " is Odd");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter number of elements: ");
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
                System.out.println("Error: Please enter a positive integer for the number of elements.");
            } else if (n > MAX_LIMIT) {
                System.out.println("Error: Number of elements cannot exceed " + MAX_LIMIT + ".");
            } else {
                int[] arr = new int[n];
                System.out.println("Enter the numbers:");
                for (int i = 0; i < n; i++) {
                    String numStr = sc.next();
                    try {
                        arr[i] = Integer.parseInt(numStr);
                    } catch (NumberFormatException ex) {
                        System.out.println("Error: Number out of range. Please enter valid integers within the allowed range.");
                        return;
                    }
                }
                printEvenOdd(arr);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter valid integers.");
        } finally {
            sc.close();
        }
    }
}

/* Output:
Enter number of elements: 4
Enter the numbers:
2 7 0 5
2 is Even
7 is Odd
0 is Even
5 is Odd

Enter number of elements: -1
Error: Please enter a positive integer for the number of elements.

Enter number of elements: abc
Error: Invalid input. Please enter valid integers.
*/
