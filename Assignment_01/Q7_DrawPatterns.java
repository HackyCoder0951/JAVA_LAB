package Assignment_01;

public class Q7_DrawPatterns {
    static void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Pattern 1:");
        pattern1(n);
        System.out.println("Pattern 2:");
        pattern2(n);
        System.out.println("Pattern 3:");
        pattern3(n);
    }
}

/* Sample Output:
Pattern 1:
    * 
   * * 
  * * * 
 * * * * 
* * * * * 
Pattern 2:
    *
   **
  ***
 ****
*****
Pattern 3:
    *
   **
  ***
 ****
*****
*/
