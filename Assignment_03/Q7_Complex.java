package Assignment_03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class representing a complex number and common operations.
 * Demonstrates:
 *  - Default constructor
 *  - Parameterized constructor
 *  - Copy constructor
 *  - Encapsulation of fields (package-private for simplicity here)
 */
class Complex {
    double real;   // real part
    double imag;   // imaginary part

    /**
     * Default constructor: initializes to 0 + 0i
     */
    Complex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    /**
     * Parameterized constructor: initializes with provided real and imaginary parts
     *
     * @param r real part
     * @param i imaginary part
     */
    Complex(double r, double i) {
        this.real = r;
        this.imag = i;
    }

    /**
     * Copy constructor: creates a new Complex copying values from another Complex
     *
     * @param c Complex object to copy from
     */
    Complex(Complex c) {
        this.real = c.real;
        this.imag = c.imag;
    }

    /**
     * Display complex number in human-friendly format.
     * Example outputs:
     *   3.0 + 4.0i
     *   5.0 - 2.0i
     */
    void display() {
        // Choose sign for imaginary part
        if (imag >= 0) {
            System.out.printf("%.4f + %.4fi%n", real, imag);
        } else {
            // imag already negative, print like "3.0000 - 2.0000i"
            System.out.printf("%.4f - %.4fi%n", real, Math.abs(imag));
        }
    }

    /**
     * Add another complex number to this one and return result as a new Complex.
     *
     * @param other complex number to add
     * @return new Complex representing the sum
     */
    Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }

    /**
     * Subtract another complex number from this one and return result as a new Complex.
     *
     * @param other complex number to subtract
     * @return new Complex representing the difference (this - other)
     */
    Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }
}

/**
 * Main class for Q7_Complex — interacts with user and demonstrates constructors and operations.
 */
public class Q7_Complex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("=== Complex Number Program ===");

            // 1) Show default constructor result
            Complex cDefault = new Complex(); // default constructor
            System.out.print("Default constructor (cDefault) : ");
            cDefault.display();

            // 2) Read real and imaginary parts from user for parameterized constructor
            double r = 0.0, i = 0.0;
            while (true) {
                try {
                    System.out.print("\nEnter real part for parameterized complex number: ");
                    r = input.nextDouble();
                    System.out.print("Enter imaginary part for parameterized complex number: ");
                    i = input.nextDouble();
                    break; // valid numeric inputs entered
                } catch (InputMismatchException ime) {
                    System.out.println("Invalid input! Please enter numeric values for real and imaginary parts.");
                    input.next(); // clear invalid token
                }
            }

            Complex cParam = new Complex(r, i); // parameterized constructor
            System.out.print("Parameterized constructor (cParam): ");
            cParam.display();

            // 3) Create copy using copy constructor
            Complex cCopy = new Complex(cParam); // copy constructor
            System.out.print("Copy constructor (cCopy)        : ");
            cCopy.display();

            // 4) Demonstrate add and subtract methods
            System.out.println("\n--- Operations Demo ---");
            System.out.print("Enter real part for second complex number (for operations): ");
            double r2 = readDouble(input);
            System.out.print("Enter imaginary part for second complex number (for operations): ");
            double i2 = readDouble(input);
            Complex cOther = new Complex(r2, i2);

            System.out.print("First complex  : ");
            cParam.display();
            System.out.print("Second complex : ");
            cOther.display();

            // Addition
            Complex sum = cParam.add(cOther);
            System.out.print("Sum            : ");
            sum.display();

            // Subtraction
            Complex diff = cParam.subtract(cOther);
            System.out.print("Difference     : ");
            diff.display();

            System.out.println("\nThank you for using Complex Number Program!");

        } catch (Exception e) {
            // Catch any unexpected exception to avoid abrupt program termination
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Ensure Scanner resource is closed
            input.close();
        }
    }

    /**
     * Helper to read a double value with re-prompting on invalid input.
     *
     * @param sc Scanner instance
     * @return valid double value
     */
    private static double readDouble(Scanner sc) {
        while (true) {
            try {
                double val = sc.nextDouble();
                return val;
            } catch (InputMismatchException ime) {
                System.out.print("Invalid input! Please enter a numeric value: ");
                sc.next(); // clear invalid token
            }
        }
    }
}
