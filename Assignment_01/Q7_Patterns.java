package Assignment_01;
import java.util.Scanner;

public class Q7_Patterns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows for patterns (n): ");
        int n = sc.nextInt();

        System.out.println("\nPattern 1 (Pyramid with spaces and stars):");
        LabUtils.pattern1(n);

        System.out.println("\nPattern 2 (Left-aligned triangle of stars):");
        LabUtils.pattern2(n);

  
        System.out.println("\nPattern 3 (Same as Pattern 2 for assignment completeness):");
        LabUtils.pattern3(n);

        sc.close();
    }
}

/*
Output:
Enter number of rows for patterns (n): 5

Pattern 1 (Pyramid with spaces and stars):
    * 
   * * 
  * * * 
 * * * * 
* * * * * 

Pattern 2 (Left-aligned triangle of stars):
*
**
***
****
*****

Pattern 3 (Same as Pattern 2 for assignment completeness):
*
**
***
****
*****
*/