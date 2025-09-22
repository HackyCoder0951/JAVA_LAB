// Q9: Shell Sort

class Q9_ShellSort {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Shell sort with gap reduction
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }

        System.out.println("Sorted array:");
        for (int val : arr) System.out.print(val + " ");
        sc.close();
    }
}

/*  Input/Output Example:
    Enter number of elements: 5
    Enter 5 elements:
    3 1 4 5 2
    Sorted array:
    1 2 3 4 5 
*/