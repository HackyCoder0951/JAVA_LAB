package Assignment_01;
import java.util.Scanner;

public class Q2_CountFrequency {
    static void countNumbers(int[] arr) {
        int pos = 0, neg = 0, zero = 0;
        for (int num : arr) {
            if (num > 0) pos++;
            else if (num < 0) neg++;
            else zero++;
        }
        System.out.println("Positive: " + pos + ", Negative: " + neg + ", Zero: " + zero);
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter numbers:");
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            countNumbers(arr);
        }
    }
}

/*
Output:
Enter number of elements: 6
Enter elements: 1 -2 0 3 -4 0
Positive: 2
Negative: 2
Zero: 2
*/