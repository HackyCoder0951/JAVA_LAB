package Assignment_01;
import java.util.Scanner;

public class Q1_SumOfNNaturalNumbers {
    // Recursive function to calculate sum
    static int sum(int n) {
        if (n <= 1)
            return n;
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
            int n = sc.nextInt();
        System.out.println("Sum of first " + n + " natural numbers: " + sum(n));
        sc.close();
    }
}

/* Output:
Enter N: 5
Sum of first 5 natural numbers: 15
*/
