package Assignment_01;
import java.util.Scanner;

public class Q9_MaxOfThreeNumbers {
    static int maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter three numbers: ");
            String aStr = sc.next();
            String bStr = sc.next();
            String cStr = sc.next();
            int a, b, c;
            try {
                a = Integer.parseInt(aStr);
                b = Integer.parseInt(bStr);
                c = Integer.parseInt(cStr);
            } catch (NumberFormatException ex) {
                System.out.println("Error: Number out of range. Please enter valid integers within the allowed range.");
                return;
            }
            System.out.println("Maximum: " + maxOfThree(a, b, c));
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter three valid integers.");
        } finally {
            sc.close();
        }
    }
}

/* Output:
Enter three numbers: 7 12 5
Maximum: 12

Enter three numbers: 4 abc 6
Error: Invalid input. Please enter three valid integers.
*/
