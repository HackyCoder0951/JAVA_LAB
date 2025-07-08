package Assignment_01;
import java.util.Scanner;

public class Q10_FrequencyOfElement {
    static int frequency(int[] arr, int x) {
        int count = 0;
        for (int n : arr) if (n == x) count++;
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter numbers:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print("Enter element to find frequency: ");
        int x = sc.nextInt();
        System.out.println("Frequency of " + x + ": " + frequency(arr, x));
        sc.close();
    }
}

/*
Output:
Enter number of elements: 6
Enter elements: 1 2 3 2 4 2
Enter element to find frequency: 2
Frequency of 2: 3
*/