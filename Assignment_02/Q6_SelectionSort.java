// Q6: Selection Sort
class Q6_SelectionSort {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Outer loop selects each element
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            // Find the smallest element in unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            // Swap
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Sorted array:");
        for (int val : arr) System.out.print(val + " ");
        sc.close();
    }
}

/*  Input/Output Example:
    Enter number of elements: 5
    Enter 5 elements:
    64 25 12 22 11
    Sorted array:
    11 12 22 25 64 
*/