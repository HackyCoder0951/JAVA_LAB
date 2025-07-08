package Assignment_01;
import java.util.Scanner;

public class Q8_MaxMinFromList {
    static int max(int[] arr) {
        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }
    static int min(int[] arr) {
        int min = arr[0];
        for (int n : arr) if (n < min) min = n;
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter numbers:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Max: " + max(arr));
        System.out.println("Min: " + min(arr));
        sc.close();
    }
}