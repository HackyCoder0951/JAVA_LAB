package Assignment_01;

import java.util.Scanner;
import java.util.Arrays;

public class Q11_QuestionSelector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Java Lab Assignment 1: Question Selector ---");
            System.out.println("1. Sum of N natural numbers");
            System.out.println("2. Frequency of positive, negative, zero");
            System.out.println("3. Reverse a number");
            System.out.println("4. Sum of digits of a number");
            System.out.println("5. Even or odd from the list");
            System.out.println("6. Factorial & palindrome check");
            System.out.println("7. Draw patterns");
            System.out.println("8. Max or min from the list");
            System.out.println("9. Maximum of three numbers");
            System.out.println("10. Frequency of element in the list");
            System.out.println("0. Exit");
            System.out.print("Select a question (0-10): ");
            int choice = sc.nextInt();
            if (choice == 0)
                break;
            switch (choice) {
                case 1:
                    System.out.print("Enter N: ");
                    int n = sc.nextInt();
                    System.out.println("Sum (iterative): " + ModuleUtils.sumIterative(n));
                    System.out.println("Sum (recursive): " + ModuleUtils.sumRecursive(n));
                    break;
                case 2:
                    System.out.print("Enter number of elements: ");
                    int n2 = sc.nextInt();
                    int[] arr2 = new int[n2];
                    System.out.println("Enter the numbers:");
                    for (int i = 0; i < n2; i++)
                        arr2[i] = sc.nextInt();
                    int[] freq = ModuleUtils.countNumbers(arr2);
                    System.out.println("Positive: " + freq[0] + ", Negative: " + freq[1] + ", Zero: " + freq[2]);
                    break;
                case 3:
                    System.out.print("Enter a number: ");
                    int n3 = sc.nextInt();
                    System.out.println("Reverse (iterative): " + ModuleUtils.reverseIterative(n3));
                    System.out.println("Reverse (recursive): " + ModuleUtils.reverseRecursive(n3));
                    break;
                case 4:
                    System.out.print("Enter a number: ");
                    int n4 = sc.nextInt();
                    System.out.println("Sum of digits (iterative): " + ModuleUtils.sumDigitsIterative(n4));
                    System.out.println("Sum of digits (recursive): " + ModuleUtils.sumDigitsRecursive(n4));
                    break;
                case 5:
                    System.out.print("Enter number of elements: ");
                    int n5 = sc.nextInt();
                    int[] arr5 = new int[n5];
                    System.out.println("Enter the numbers:");
                    for (int i = 0; i < n5; i++)
                        arr5[i] = sc.nextInt();
                    System.out.println("Even numbers: " + Arrays.toString(ModuleUtils.evenNumbers(arr5)));
                    System.out.println("Odd numbers: " + Arrays.toString(ModuleUtils.oddNumbers(arr5)));
                    break;
                case 6:
                    System.out.print("Enter a number: ");
                    int n6 = sc.nextInt();
                    System.out.println("Factorial (iterative): " + ModuleUtils.factorialIterative(n6));
                    System.out.println("Factorial (recursive): " + ModuleUtils.factorialRecursive(n6));
                    System.out.println("Is Palindrome: " + ModuleUtils.isPalindrome(n6));
                    break;
                case 7:
                    System.out.print("Enter n for patterns: ");
                    int n7 = sc.nextInt();
                    System.out.println("Pattern 1:");
                    ModuleUtils.pattern1(n7);
                    System.out.println("Pattern 2:");
                    ModuleUtils.pattern2(n7);
                    System.out.println("Pattern 3:");
                    ModuleUtils.pattern3(n7);
                    break;
                case 8:
                    System.out.print("Enter number of elements: ");
                    int n8 = sc.nextInt();
                    int[] arr8 = new int[n8];
                    System.out.println("Enter the numbers:");
                    for (int i = 0; i < n8; i++)
                        arr8[i] = sc.nextInt();
                    System.out.print("Find (1) Max or (2) Min? Enter 1 or 2: ");
                    int ch8 = sc.nextInt();
                    if (ch8 == 1)
                        System.out.println("Maximum: " + ModuleUtils.max(arr8));
                    else
                        System.out.println("Minimum: " + ModuleUtils.min(arr8));
                    break;
                case 9:
                    System.out.print("Enter three numbers: ");
                    int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
                    System.out.println("Maximum: " + ModuleUtils.maxOfThree(a, b, c));
                    break;
                case 10:
                    System.out.print("Enter number of elements: ");
                    int n10 = sc.nextInt();
                    int[] arr10 = new int[n10];
                    System.out.println("Enter the numbers:");
                    for (int i = 0; i < n10; i++)
                        arr10[i] = sc.nextInt();
                    System.out.print("Enter element to count frequency: ");
                    int x = sc.nextInt();
                    System.out.println("Frequency of " + x + ": " + ModuleUtils.frequency(arr10, x));
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        System.out.println("Exiting. Thank you!");
        sc.close();
    }
}
