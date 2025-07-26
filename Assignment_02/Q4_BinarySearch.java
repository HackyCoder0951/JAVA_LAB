// Q4: Binary Search
import java.util.*;
class Q4_BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {2, 4, 6, 8, 10, 12, 14};
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
