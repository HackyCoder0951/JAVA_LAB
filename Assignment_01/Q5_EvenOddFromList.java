package Assignment_01;
import java.util.Scanner;

public class Q5_EvenOddFromList {
    static void evenOdd(int[] arr) {
        System.out.print("Even numbers: ");
        for (int n : arr) if (n % 2 == 0) System.out.print(n + " ");
        System.out.print("\nOdd numbers: ");
        for (int n : arr) if (n % 2 != 0) System.out.print(n + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter numbers:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        evenOdd(arr);
        sc.close();
    }
}

/*
Output:
Enter number of elements: 6
Enter elements: 1 2 3 4 5 6
Even numbers: 2 4 6 
Odd numbers: 1 3 5 
*/