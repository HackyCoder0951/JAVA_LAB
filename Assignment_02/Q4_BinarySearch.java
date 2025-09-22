// Q4: Binary Search
import java.util.*;
class Q4_BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter number to search: ");
        int key = sc.nextInt();

        int low = 0, high = arr.length - 1;
        boolean found = false;

        // Standard binary search loop
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                found = true;
                System.out.println("Element found at index " + mid);
                break;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        sc.close();

        if (!found) System.out.println("Element not found");
    }
}

/*  Input/Output Example:
    Enter number of elements: 5
    Enter 5 sorted elements:
    10
    20
    30
    40
    50
    Enter number to search: 30
    Element found at index 2
*/