package Assignment_01;
import java.util.Scanner;

public class Q8_MaxOrMinFromList {
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) if (num > max) max = num;
        return max;
    }
    static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) if (num < min) min = num;
        return min;
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
                System.out.print("Find (1) Max or (2) Min? Enter 1 or 2: ");
                String choiceStr = sc.next();
                int choice;
                try {
                    choice = Integer.parseInt(choiceStr);
                } catch (NumberFormatException ex) {
                    System.out.println("Error: Number out of range. Please enter 1 or 2.");
                    return;
                }
                if (choice == 1)
                    System.out.println("Maximum: " + findMax(arr));
                else if (choice == 2)
                    System.out.println("Minimum: " + findMin(arr));
                else
                    System.out.println("Error: Invalid choice. Enter 1 for Max or 2 for Min.");
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
5 2 9 1
Find (1) Max or (2) Min? Enter 1 or 2: 1
Maximum: 9

Enter number of elements: 3
Enter the numbers:
8 4 6
Find (1) Max or (2) Min? Enter 1 or 2: 2
Minimum: 4

Enter number of elements: -2
Error: Please enter a positive integer for the number of elements.

Enter number of elements: abc
Error: Invalid input. Please enter valid integers.
*/
