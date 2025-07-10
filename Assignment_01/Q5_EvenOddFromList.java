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
            int n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Error: Please enter a positive integer for the number of elements.");
            } else {
                int[] arr = new int[n];
                System.out.println("Enter the numbers:");
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
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

/* Sample Output:
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
