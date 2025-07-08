package Assignment_01;
import java.util.Scanner;

public class MaxOrMinFromList {
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) if (num > max) max = num;
        return max;
    }
    static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) if (num < min) min = num;
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print("Find (1) Max or (2) Min? Enter 1 or 2: ");
        int choice = sc.nextInt();
        if (choice == 1)
            System.out.println("Maximum: " + findMax(arr));
        else
            System.out.println("Minimum: " + findMin(arr));
        sc.close();
    }
}
