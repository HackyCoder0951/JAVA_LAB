package Assignment_01;
import java.util.Arrays;

public class LabUtils {
    // Q1: Sum of N natural numbers
    public static int sumIterative(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum;
    }
    public static int sumRecursive(int n) {
        if (n <= 0) return 0;
        return n + sumRecursive(n - 1);
    }

    // Q2: Count frequency of positive, negative, zero
    public static int[] countNumbers(int[] arr) {
        int pos = 0, neg = 0, zero = 0;
        for (int num : arr) {
            if (num > 0) pos++;
            else if (num < 0) neg++;
            else zero++;
        }
        return new int[]{pos, neg, zero};
    }

    // Q3: Reverse a number
    public static int reverseIterative(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
    public static int reverseRecursive(int n) {
        return reverseRecursiveHelper(n, 0);
    }
    private static int reverseRecursiveHelper(int n, int rev) {
        if (n == 0) return rev;
        return reverseRecursiveHelper(n / 10, rev * 10 + n % 10);
    }

    // Q4: Sum of digits
    public static int sumDigitsIterative(int n) {
        int sum = 0;
        n = Math.abs(n);
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static int sumDigitsRecursive(int n) {
        n = Math.abs(n);
        if (n == 0) return 0;
        return n % 10 + sumDigitsRecursive(n / 10);
    }

    // Q5: Even or odd from list
    public static int[] evenNumbers(int[] arr) {
        return Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
    }
    public static int[] oddNumbers(int[] arr) {
        return Arrays.stream(arr).filter(x -> x % 2 != 0).toArray();
    }

    // Q6: Factorial & palindrome
    public static long factorialIterative(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
    public static long factorialRecursive(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
        if (n <= 1) return 1;
        return n * factorialRecursive(n - 1);
    }
    public static boolean isPalindrome(int n) {
        n = Math.abs(n);
        return n == reverseIterative(n);
    }

    // Q7: Patterns
        /**
         * Pattern 1: Left-aligned pyramid with spaces and stars (e.g. for n=5)
         *      *
         *     * *
         *    * * *
         *   * * * *
         *  * * * * *
         */
            public static void pattern1(int n) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n - i; j++) System.out.print(" ");
                    for (int j = 1; j <= i; j++) System.out.print("* ");
                    System.out.println();
                }
            }

        /**
         * Pattern 2: Left-aligned triangle of stars (e.g. for n=5)
         * *
         * **
         * ***
         * ****
         * *****
         */
            public static void pattern2(int n) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= i; j++) System.out.print("*");
                    System.out.println();
                }
            }

        /**
         * Pattern 3: Same as pattern2 (for assignment completeness)
         */
            public static void pattern3(int n) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= i; j++) System.out.print("*");
                    System.out.println();
                }
            }


    // Q8: Max or min from list
    public static int max(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Array is empty");
        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }
    public static int min(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Array is empty");
        int min = arr[0];
        for (int n : arr) if (n < min) min = n;
        return min;
    }

    // Q9: Max of three
    public static int maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // Q10: Frequency of element
    public static int frequency(int[] arr, int x) {
        int count = 0;
        for (int n : arr) if (n == x) count++;
        return count;
    }
}