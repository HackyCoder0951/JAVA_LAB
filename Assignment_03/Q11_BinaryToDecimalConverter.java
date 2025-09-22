package Assignment_03;

// Class to represent a Binary Number
class BinaryNumber {
    // Encapsulation: keeping the data private
    private String binary;

    // Constructor to initialize the binary number
    public BinaryNumber(String binary) {
        if (isValidBinary(binary)) {
            this.binary = binary;
        } else {
            throw new IllegalArgumentException("Invalid binary number! Only 0 and 1 are allowed.");
        }
    }

    // Method to validate if the string is a binary number
    private boolean isValidBinary(String str) {
        return str.matches("[01]+"); // regex ensures only 0s and 1s
    }

    // Method to convert binary to decimal
    public int toDecimal() {
        int decimal = 0;
        int power = 0;
        // Iterate from right to left
        for (int i = binary.length() - 1; i >= 0; i--) {
            char bit = binary.charAt(i);
            if (bit == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }

    // Getter for the binary number (read-only)
    public String getBinary() {
        return binary;
    }
}

// Main class
public class Q11_BinaryToDecimalConverter {
    public static void main(String[] args) {
        try {
            // Creating object using constructor
            BinaryNumber bn = new BinaryNumber("101101");
            // Printing the result
            System.out.println("Binary Number: " + bn.getBinary());
            System.out.println("Decimal Equivalent: " + bn.toDecimal());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}