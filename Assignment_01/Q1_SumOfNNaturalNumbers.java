package Assignment_01;
import java.util.Scanner;

public class Q1_SumOfNNaturalNumbers {
    static int sumIterative(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i; 
        return sum;
    }

    static int sumRecursive(int n) {
        if (n == 0) return 0;
        return n + sumRecursive(n - 1); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
   
        System.out.println("Sum (Iterative, Local): " + sumIterative(n));
        System.out.println("Sum (Recursive, Local): " + sumRecursive(n));


        System.out.println("Sum (Iterative, LabUtils): " + LabUtils.sumIterative(n));
        System.out.println("Sum (Recursive, LabUtils): " + LabUtils.sumRecursive(n));

        sc.close();
    }
}

/*
Output:
Enter N: 5
Sum (Iterative, Local): 15
Sum (Recursive, Local): 15
Sum (Iterative, LabUtils): 15
Sum (Recursive, LabUtils): 15
*/
