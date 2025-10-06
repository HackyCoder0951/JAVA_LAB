package Assignment_03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Base class Vehicle demonstrating method overriding and polymorphism.
 */
class Vehicle {
    // Default implementation (overridden by subclasses)
    void fuelType() {
        System.out.println("Generic fuel type");
    }
}

/**
 * Car subclass overriding the fuelType() method.
 */
class Car extends Vehicle {
    @Override
    void fuelType() {
        System.out.println("Car uses Petrol or Diesel");
    }
}

/**
 * Bike subclass overriding the fuelType() method.
 */
class Bike extends Vehicle {
    @Override
    void fuelType() {
        System.out.println("Bike uses Petrol");
    }
}

/**
 * Main class Q6_Vehicle — demonstrates polymorphism using user-based input.
 */
public class Q6_Vehicle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Vehicle Fuel Type Checker ===");

        boolean exit = false;
        while (!exit) {
            try {
                // Menu for user input
                System.out.println("\nMenu:");
                System.out.println("1. Car");
                System.out.println("2. Bike");
                System.out.println("3. Exit");
                System.out.print("Enter your choice (1-3): ");

                int choice = sc.nextInt();

                Vehicle vehicle = null;

                switch (choice) {
                    case 1:
                        vehicle = new Car();
                        System.out.println("\n--- Selected: Car ---");
                        vehicle.fuelType(); // Calls Car's version
                        break;

                    case 2:
                        vehicle = new Bike();
                        System.out.println("\n--- Selected: Bike ---");
                        vehicle.fuelType(); // Calls Bike's version
                        break;

                    case 3:
                        exit = true;
                        System.out.println("\nExiting Vehicle Fuel Type Checker. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please select 1, 2, or 3.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input! Please enter a numeric value (1-3).");
                sc.nextLine(); // Clear the invalid input
            }
        }

        sc.close();
    }
}
