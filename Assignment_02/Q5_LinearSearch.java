// Q5: Linear Search
import java.util.*;
class Q5_LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40, 50};
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