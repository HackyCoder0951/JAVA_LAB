package Assignment_03;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Q11_BinaryToDecimalConverter
 *
 * Menu-driven converter:
 * 1) Binary -> Decimal
 * 2) Decimal -> Binary
 * 3) Exit
 *
 * Input is validated. Conversion uses BigInteger so large numbers are handled safely.
 */
public class Q11_BinaryToDecimalConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("=== Binary <-> Decimal Converter ===");

            boolean exit = false;
            while (!exit) {
                // Menu
                System.out.println("\nMenu:");
                System.out.println("1. Binary -> Decimal");
                System.out.println("2. Decimal -> Binary");
                System.out.println("3. Exit");
                System.out.print("Enter choice (1-3): ");

                int choice = readIntInRange(sc, 1, 3);

                switch (choice) {
                    case 1:
                        // Binary to Decimal
                        System.out.print("\nEnter a binary number (only 0 and 1): ");
                        String bin = sc.nextLine().trim();
                        // Validate binary string
                        while (!isValidBinary(bin)) {
                            System.out.print("Invalid binary. Enter again (only 0 and 1): ");
                            bin = sc.nextLine().trim();
                        }
                        // Convert using BigInteger (base 2)
                        BigInteger decimal = new BigInteger(bin, 2);
                        System.out.println("Binary: " + bin);
                        System.out.println("Decimal equivalent: " + decimal.toString());
                        break;

                    case 2:
                        // Decimal to Binary
                        System.out.print("\nEnter a non-negative decimal integer: ");
                        String decInput = sc.nextLine().trim();
                        while (!isValidNonNegativeInteger(decInput)) {
                            System.out.print("Invalid decimal integer. Enter a non-negative integer: ");
                            decInput = sc.nextLine().trim();
                        }
                        // Convert decimal string to BigInteger, then to binary string
                        BigInteger dec = new BigInteger(decInput); // dec >= 0 guaranteed by validation
                        String binary = dec.toString(2); // base-2 string
                        System.out.println("Decimal: " + dec.toString());
                        System.out.println("Binary equivalent: " + binary);
                        break;

                    case 3:
                        // Exit
                        exit = true;
                        System.out.println("\nExiting converter. Goodbye!");
                        break;

                    default:
                        // unreachable due to readIntInRange validation
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (Exception e) {
            // Generic catch to prevent abrupt termination and show message
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close(); // close scanner resource
        }
    }

    /**
     * Validate that the input string is a binary number containing only '0' and '1'
     * and at least one character.
     */
    private static boolean isValidBinary(String s) {
        return s != null && s.matches("[01]+");
    }

    /**
     * Validate that the input string is a non-negative integer (no signs, digits only).
     * Accepts "0" and positive integers. Uses regex to avoid NumberFormatException on very long strings.
     */
    private static boolean isValidNonNegativeInteger(String s) {
        return s != null && s.matches("\\d+");
    }

    /**
     * Read an integer from scanner and ensure it's within [min..max].
     * Re-prompts on invalid input.
     */
    private static int readIntInRange(Scanner sc, int min, int max) {
        while (true) {
            String line = sc.nextLine().trim();
            if (!line.matches("\\d+")) {
                System.out.print("Please enter a numeric choice (" + min + "-" + max + "): ");
                continue;
            }
            int val;
            try {
                val = Integer.parseInt(line);
            } catch (NumberFormatException nfe) {
                System.out.print("Choice out of range. Enter (" + min + "-" + max + "): ");
                continue;
            }
            if (val < min || val > max) {
                System.out.print("Please enter a choice between " + min + " and " + max + ": ");
                continue;
            }
            return val;
        }
    }
}
