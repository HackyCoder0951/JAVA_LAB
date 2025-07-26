// Q6: Selection Sort
class Q6_SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int n = arr.length;

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
    }
}