package Assignment_01;
import java.util.Scanner;

public class Q5_EvenOddFromList {
    static void printEvenOdd(int[] arr) {
        for (int num : arr) {
            if (num % 2 == 0)
                System.out.println(num + " is Even");
            else
                System.out.println(num + " is Odd");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printEvenOdd(arr);
        sc.close();
    }
}

/* Sample Output:
Enter number of elements: 4
Enter the numbers:
2 7 0 5
2 is Even
7 is Odd
0 is Even
5 is Odd
*/
