package Assignment_03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Abstract base class representing a polygon.
 * Subclasses must implement perimeter().
 */
abstract class Polygon {
    abstract double perimeter();
}

/**
 * Triangle class (3 sides).
 */
class Triangle extends Polygon {
    double a, b, c;

    // Constructor initializes triangle sides
    Triangle(double x, double y, double z) {
        this.a = x;
        this.b = y;
        this.c = z;
    }

    // Perimeter of triangle = a + b + c
    @Override
    double perimeter() {
        return a + b + c;
    }
}

/**
 * Square class (all sides equal).
 */
class Square extends Polygon {
    double side;

    // Constructor initializes side length
    Square(double s) {
        this.side = s;
    }

    // Perimeter of square = 4 * side
    @Override
    double perimeter() {
        return 4 * side;
    }
}

/**
 * Main class Q8_Polygon — menu-driven perimeter calculator.
 */
public class Q8_Polygon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Polygon Perimeter Calculator ===");

        boolean exit = false;
        while (!exit) {
            // Show main menu
            System.out.println("\nMenu:");
            System.out.println("1. Triangle (compute perimeter)");
            System.out.println("2. Square (compute perimeter)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            int choice = readIntInRange(sc, 1, 3);

            switch (choice) {
                case 1:
                    // Triangle: read and validate three sides
                    System.out.println("\n-- Triangle Selected --");
                    double a = readPositiveDouble(sc, "Enter side a: ");
                    double b = readPositiveDouble(sc, "Enter side b: ");
                    double c = readPositiveDouble(sc, "Enter side c: ");

                    // Validate triangle inequality: sum of any two sides > third
                    if (isValidTriangle(a, b, c)) {
                        Polygon triangle = new Triangle(a, b, c);
                        System.out.printf("Perimeter of triangle (%.4f, %.4f, %.4f) = %.4f%n",
                                a, b, c, triangle.perimeter());
                    } else {
                        System.out.println("Invalid triangle! Sum of any two sides must be greater than the third side.");
                    }
                    break;

                case 2:
                    // Square: read and validate side
                    System.out.println("\n-- Square Selected --");
                    double side = readPositiveDouble(sc, "Enter side length: ");
                    Polygon square = new Square(side);
                    System.out.printf("Perimeter of square (side = %.4f) = %.4f%n", side, square.perimeter());
                    break;

                case 3:
                    // Exit program
                    exit = true;
                    System.out.println("\nExiting Polygon Perimeter Calculator. Goodbye!");
                    break;

                default:
                    // Defensive: unreachable because readIntInRange enforces range
                    System.out.println("Invalid option. Please try again.");
            }
        }

        sc.close(); // close scanner resource
    }

    /**
     * Helper: read an integer in [min..max] from scanner, re-prompt on invalid input.
     */
    private static int readIntInRange(Scanner sc, int min, int max) {
        while (true) {
            try {
                int val = sc.nextInt();
                sc.nextLine(); // consume newline
                if (val < min || val > max) {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.print("Invalid input! Please enter an integer: ");
                sc.nextLine(); // clear invalid token
            }
        }
    }

    /**
     * Helper: read a positive double value ( > 0 ). Re-prompts on invalid input.
     *
     * @param sc     Scanner instance
     * @param prompt Prompt message to display
     * @return validated positive double
     */
    private static double readPositiveDouble(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double val = sc.nextDouble();
                sc.nextLine(); // consume newline
                if (val <= 0) {
                    System.out.println("Value must be positive. Please try again.");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input! Please enter a numeric value.");
                sc.nextLine(); // clear invalid token
            }
        }
    }

    /**
     * Validate triangle by checking triangle inequality theorem.
     *
     * @return true if a, b, c can form a triangle
     */
    private static boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
