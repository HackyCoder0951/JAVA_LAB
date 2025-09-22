// Q5: Linear Search
import java.util.*;
class Q5_LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        boolean found = false;

        // Traverse and compare each element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index " + i);
                found = true;
                break;
            }
        }
        sc.close();
        if (!found) System.out.println("Element not found");

    }
}

/*  Input/Output Example:
    Enter number of elements: 5
    Enter 5 elements:
    10
    20
    30
    40
    50
    Enter element to search: 30
    Element found at index 2
*/