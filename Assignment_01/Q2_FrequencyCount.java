package Assignment_01;
import java.util.Scanner;

public class Q2_FrequencyCount {
    static void countFrequencies(int[] arr) {
        int pos = 0, neg = 0, zero = 0;
        for (int num : arr) {
            if (num > 0) pos++;
            else if (num < 0) neg++;
            else zero++;
        }
        System.out.println("Positive: " + pos);
        System.out.println("Negative: " + neg);
        System.out.println("Zero: " + zero);
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
                countFrequencies(arr);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter valid integers.");
        } finally {
            sc.close();
        }
    }
}

/* Output:
Enter number of elements: 5
Enter the numbers:
1 -2 0 3 0
Positive: 2
Negative: 1
Zero: 2

Enter number of elements: -2
Error: Please enter a positive integer for the number of elements.

Enter number of elements: abc
Error: Invalid input. Please enter valid integers.
*/
