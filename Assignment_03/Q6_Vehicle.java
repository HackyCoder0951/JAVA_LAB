package Assignment_03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Base Vehicle class.
 * Demonstrates method overriding: subclasses provide specific fuelType() implementations.
 */
class Vehicle {
    // Default implementation (can be overridden by subclasses)
    void fuelType() {
        System.out.println("Generic fuel type");
    }
}

/**
 * Car subclass: typical petrol/diesel vehicle.
 */
class Car extends Vehicle {
    @Override
    void fuelType() {
        System.out.println("Car uses Petrol/Diesel");
    }
}

/**
 * Bike subclass: typical petrol two-wheeler.
 */
class Bike extends Vehicle {
    @Override
    void fuelType() {
        System.out.println("Bike uses Petrol");
    }
}

/**
 * Truck subclass: heavy vehicle (diesel typical).
 */
class Truck extends Vehicle {
    @Override
    void fuelType() {
        System.out.println("Truck uses Diesel");
    }
}

/**
 * ElectricCar subclass: zero tailpipe emissions.
 */
class ElectricCar extends Vehicle {
    @Override
    void fuelType() {
        System.out.println("Electric Car uses Electricity (Battery)");
    }
}

/**
 * Main program Q6_Vehicle — menu-driven vehicle fuel type checker.
 */
public class Q6_Vehicle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Vehicle Fuel Type Checker ===");

        boolean exit = false;
        while (!exit) {
            // Print menu
            System.out.println("\nSelect a vehicle type:");
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.println("3. Truck");
            System.out.println("4. Electric Car");
            System.out.println("5. Exit");
            System.out.print("Enter choice (1-5): ");

            int choice = readIntInRange(sc, 1, 5);

            Vehicle vehicle = null; // polymorphic reference

            switch (choice) {
                case 1:
                    vehicle = new Car();
                    System.out.println("\n--- Selected: Car ---");
                    vehicle.fuelType(); // calls Car.fuelType()
                    break;

                case 2:
                    vehicle = new Bike();
                    System.out.println("\n--- Selected: Bike ---");
                    vehicle.fuelType(); // calls Bike.fuelType()
                    break;

                case 3:
                    vehicle = new Truck();
                    System.out.println("\n--- Selected: Truck ---");
                    vehicle.fuelType(); // calls Truck.fuelType()
                    break;

                case 4:
                    vehicle = new ElectricCar();
                    System.out.println("\n--- Selected: Electric Car ---");
                    vehicle.fuelType(); // calls ElectricCar.fuelType()
                    break;

                case 5:
                    // Exit the loop and program
                    exit = true;
                    System.out.println("\nExiting Vehicle Fuel Type Checker. Goodbye!");
                    break;

                default:
                    // Defensive programming: should not reach here due to validation
                    System.out.println("Invalid option — please try again.");
            }

            // After performing an action, allow loop to continue until exit selected
        }

        sc.close(); // close scanner to free system resource
    }

    /**
     * Helper method: read integer within inclusive [min..max], re-prompts until valid.
     */
    private static int readIntInRange(Scanner sc, int min, int max) {
        while (true) {
            try {
                int val = sc.nextInt();
                sc.nextLine(); // consume trailing newline
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
}
