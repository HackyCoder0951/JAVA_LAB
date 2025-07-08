package Assignment_01;
import java.util.Scanner;

public class Q9_MaxOfThreeNumbers {
    static int maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("Maximum: " + maxOfThree(a, b, c));
        sc.close();
    }
}
