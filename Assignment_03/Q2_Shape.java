package Assignment_03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Abstract base class for shapes.
 */
abstract class Shape {
    // Calculate area of the shape
    abstract double area();

    // Calculate perimeter of the shape
    abstract double perimeter();
}

/**
 * Circle class implements Shape methods for area and perimeter.
 */
class Circle extends Shape {
    double radius;

    Circle(double r) {
        radius = r;
    }

    @Override
    double area() {
        return Math.PI * radius * radius; // πr^2
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius; // 2πr
    }
}

/**
 * Rectangle class implements Shape methods for area and perimeter.
 */
class Rectangle extends Shape {
    double length, breadth;

    Rectangle(double l, double b) {
        length = l;
        breadth = b;
    }

    @Override
    double area() {
        return length * breadth; // l * b
    }

    @Override
    double perimeter() {
        return 2 * (length + breadth); // 2(l + b)
    }
}

/**
 * Menu-driven program to compute area and perimeter for Circle and Rectangle.
 */
public class Q2_Shape {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("=== Shape Calculator (Area & Perimeter) ===");

            boolean exitProgram = false;
            while (!exitProgram) {
                // Main menu
                System.out.println("\nMain Menu:");
                System.out.println("1. Circle");
                System.out.println("2. Rectangle");
                System.out.println("3. Exit");
                System.out.print("Choose an option (1-3): ");

                int mainChoice = readInt(input, 1, 3);

                switch (mainChoice) {
                    case 1:
                        // Circle selected
                        System.out.println("\n-- Circle --");
                        System.out.print("Enter radius: ");
                        double radius = readPositiveDouble(input);
                        Circle circle = new Circle(radius);

                        // Operation menu for circle
                        System.out.println("\nChoose operation:");
                        System.out.println("1. Area");
                        System.out.println("2. Perimeter");
                        System.out.println("3. Back to Main Menu");
                        System.out.print("Enter choice (1-3): ");
                        int circOp = readInt(input, 1, 3);

                        if (circOp == 1) {
                            System.out.printf("Area of circle (r=%.4f) = %.6f%n", radius, circle.area());
                        } else if (circOp == 2) {
                            System.out.printf("Perimeter of circle (r=%.4f) = %.6f%n", radius, circle.perimeter());
                        }
                        // if 3 -> do nothing, returns to main menu
                        break;

                    case 2:
                        // Rectangle selected
                        System.out.println("\n-- Rectangle --");
                        System.out.print("Enter length: ");
                        double length = readPositiveDouble(input);
                        System.out.print("Enter breadth: ");
                        double breadth = readPositiveDouble(input);

                        Rectangle rect = new Rectangle(length, breadth);

                        // Operation menu for rectangle
                        System.out.println("\nChoose operation:");
                        System.out.println("1. Area");
                        System.out.println("2. Perimeter");
                        System.out.println("3. Back to Main Menu");
                        System.out.print("Enter choice (1-3): ");
                        int rectOp = readInt(input, 1, 3);

                        if (rectOp == 1) {
                            System.out.printf("Area of rectangle (L=%.4f, B=%.4f) = %.6f%n",
                                    length, breadth, rect.area());
                        } else if (rectOp == 2) {
                            System.out.printf("Perimeter of rectangle (L=%.4f, B=%.4f) = %.6f%n",
                                    length, breadth, rect.perimeter());
                        }
                        // if 3 -> back to main menu
                        break;

                    case 3:
                        // Exit chosen
                        exitProgram = true;
                        System.out.println("\nExiting program. Goodbye!");
                        break;

                    default:
                        // (Should not happen because readInt enforces range)
                        System.out.println("Invalid option. Try again.");
                }
            }
        } catch (Exception e) {
            // Catch unexpected exceptions to avoid abrupt termination
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            input.close();
        }
    }

    /**
     * Read an integer from scanner and ensure it's within [min..max].
     * Re-prompts on invalid input.
     */
    private static int readInt(Scanner sc, int min, int max) {
        while (true) {
            try {
                int val = sc.nextInt();
                if (val < min || val > max) {
                    System.out.print("Please enter a valid choice (" + min + "-" + max + "): ");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.print("Invalid input! Please enter an integer: ");
                sc.next(); // clear invalid token
            }
        }
    }

    /**
     * Read a positive double value from scanner. Re-prompts on invalid or non-positive input.
     */
    private static double readPositiveDouble(Scanner sc) {
        while (true) {
            try {
                double val = sc.nextDouble();
                if (val <= 0) {
                    System.out.print("Value must be positive. Please enter again: ");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.print("Invalid input! Please enter a numeric value: ");
                sc.next(); // clear invalid token
            }
        }
    }
}
