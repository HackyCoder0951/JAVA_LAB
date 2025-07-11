package Assignment_01;
import java.util.HashMap;
import java.util.Scanner;

public class Q10_FrequencyOfElements {
    static void countFrequency(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        System.out.println("Element : Frequency");
        for (int key : freq.keySet()) {
            System.out.println(key + " : " + freq.get(key));
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
                countFrequency(arr);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter valid integers.");
        } finally {
            sc.close();
        }
    }
}

/* Output:
Enter number of elements: 6
Enter the numbers:
1 2 2 3 1 2
Element : Frequency
1 : 2
2 : 3
3 : 1

Enter number of elements: -3
Error: Please enter a positive integer for the number of elements.

Enter number of elements: abc
Error: Invalid input. Please enter valid integers.
*/
