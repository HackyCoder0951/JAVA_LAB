// Q10: Matrix Operations (Menu Driven)
import java.util.*;
class Q10_MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Predefined 2x2 matrices
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int[][] result = new int[2][2];

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Matrix addition
                    for (int i = 0; i < 2; i++)
                        for (int j = 0; j < 2; j++)
                            result[i][j] = A[i][j] + B[i][j];
                    break;
                case 2:
                    // Matrix subtraction
                    for (int i = 0; i < 2; i++)
                        for (int j = 0; j < 2; j++)
                            result[i][j] = A[i][j] - B[i][j];
                    break;
                case 3:
                    // Matrix multiplication
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            result[i][j] = 0;
                            for (int k = 0; k < 2; k++)
                                result[i][j] += A[i][k] * B[k][j];
                        }
                    }
                    break;
                case 4:
                    System.exit(0);
            }

            // Display result matrix
            System.out.println("Result:");
            for (int[] row : result) {
                for (int val : row) System.out.print(val + " ");
                System.out.println();
            }
            sc.close();
        }
    }
}
