package Assignment_03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Q11 — Binary to Decimal Converter
 *
 * Demonstrates:
 * - Encapsulation (private field)
 * - Constructors (default & parameterized)
 * - Validation (binary input)
 * - Exception handling
 * - Data abstraction
 * - File handling (save conversion results)
 */
class BinaryNumber {
    // Private field for encapsulation
    private String binary;

    // Default constructor
    public BinaryNumber() {
        this.binary = "0";
    }

    // Parameterized constructor (validates input)
    public BinaryNumber(String binary) {
        setBinary(binary);
    }

    // Validate binary input
    private boolean isValidBinary(String s) {
        return s != null && s.matches("[01]+");
    }

    // Setter with validation
    public void setBinary(String binary) {
        if (!isValidBinary(binary)) {
            throw new IllegalArgumentException("Invalid binary number. Only 0 and 1 are allowed.");
        }
        this.binary = binary;
    }

    // Getter
    public String getBinary() {
        return binary;
    }

    // Convert binary to decimal manually
    public int toDecimal() {
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }

    // Save conversion result to file
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Binary: " + binary + " -> Decimal: " + toDecimal());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

/**
 * Main class to interact with the user and perform file-based conversions.
 */
public class Q11_BinaryToDecimalConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String FILE_NAME = "converted_binary_numbers.txt";

        System.out.println("=== Binary to Decimal Converter (OOP + File Handling) ===");

        while (true) {
            System.out.print("\nEnter a binary number (only 0 and 1) or type 'exit' to quit: ");
            String input = sc.nextLine().trim();

            // Exit condition
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("\nExiting converter. Goodbye!");
                break;
            }

            try {
                // Create object and validate input
                BinaryNumber bn = new BinaryNumber(input);

                // Convert and display
                int decimalValue = bn.toDecimal();
                System.out.println("Conversion Successful!");
                System.out.println("Binary: " + bn.getBinary());
                System.out.println("Decimal: " + decimalValue);

                // Save conversion to file
                bn.saveToFile(FILE_NAME);
                System.out.println("Conversion saved to file: " + FILE_NAME);

            } catch (IllegalArgumentException iae) {
                System.out.println("Error: " + iae.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
