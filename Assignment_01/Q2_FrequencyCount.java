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
Enter number of elements: 1001
Error: Number of elements cannot exceed 1000.

Enter number of elements: 385921581025810923850912
Error: Number out of range. Please enter a valid integer within the allowed range.

Enter number of elements: 1000
Enter the numbers:
1 2 3 ... (up to 1000)
Positive: ...
Negative: ...
Zero: ...
*/
