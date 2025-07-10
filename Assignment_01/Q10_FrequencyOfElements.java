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
            int n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Error: Please enter a positive integer for the number of elements.");
            } else {
                int[] arr = new int[n];
                System.out.println("Enter the numbers:");
                for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
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
