package Assignment_03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Simple Book class demonstrating encapsulation (private fields),
 * getters/setters with validation, and a display method.
 */
class Book {
    // Private fields — encapsulated data
    private String title;
    private String author;
    private double price;

    // Constructor to initialize all fields
    public Book(String t, String a, double p) {
        this.title = t;
        this.author = a;
        this.price = p;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String t) {
        this.title = t;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Setter for author
    public void setAuthor(String a) {
        this.author = a;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price with validation (price must be positive)
    public void setPrice(double p) {
        if (p > 0) {
            this.price = p;
        } else {
            System.out.println("Price must be positive. Update skipped.");
        }
    }

    // Display method to print book details neatly
    void display() {
        System.out.println("\n--- Book Details ---");
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("Price : Rs. " + price);
    }
}

/**
 * Main class Q5_Library — handles user interaction for creating and updating a Book.
 */
public class Q5_Library {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("=== Library Book Entry System ===");

            // 1) Read book title (non-empty)
            String title;
            while (true) {
                System.out.print("Enter Book Title: ");
                title = input.nextLine().trim();
                if (title.isEmpty()) {
                    System.out.println("Title cannot be empty. Please try again.");
                    continue;
                }
                break;
            }

            // 2) Read author name (non-empty)
            String author;
            while (true) {
                System.out.print("Enter Author Name: ");
                author = input.nextLine().trim();
                if (author.isEmpty()) {
                    System.out.println("Author cannot be empty. Please try again.");
                    continue;
                }
                break;
            }

            // 3) Read price (positive double) with validation & exception handling
            double price = 0.0;
            while (true) {
                try {
                    System.out.print("Enter Book Price (Rs.): ");
                    price = input.nextDouble();
                    input.nextLine(); // consume newline
                    if (price <= 0) {
                        System.out.println("Price must be a positive number. Try again.");
                        continue;
                    }
                    break; // valid price
                } catch (InputMismatchException ime) {
                    System.out.println("Invalid input! Please enter a numeric value for price.");
                    input.nextLine(); // clear invalid token
                }
            }

            // Create Book object using validated inputs
            Book b1 = new Book(title, author, price);
            System.out.println("\nBook added successfully.");
            b1.display(); // show details

            // 4) Offer option to update price
            while (true) {
                System.out.print("\nDo you want to update the price? (yes/no): ");
                String choice = input.nextLine().trim();
                if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
                    // Read new price with validation
                    while (true) {
                        try {
                            System.out.print("Enter new price (Rs.): ");
                            double newPrice = input.nextDouble();
                            input.nextLine(); // consume newline
                            if (newPrice <= 0) {
                                System.out.println("Price must be positive. Try again.");
                                continue;
                            }
                            b1.setPrice(newPrice); // update via setter (includes validation)
                            System.out.println("Price updated successfully.");
                            b1.display();
                            break;
                        } catch (InputMismatchException ime) {
                            System.out.println("Invalid input! Please enter a numeric value for price.");
                            input.nextLine(); // clear invalid token
                        }
                    }
                    break; // after update return to end
                } else if (choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("n")) {
                    // No update requested
                    System.out.println("No changes made to price.");
                    break;
                } else {
                    // Invalid response — re-prompt
                    System.out.println("Please answer 'yes' or 'no'.");
                }
            }

            System.out.println("\nFinal Book Record:");
            b1.display();

        } catch (Exception e) {
            // Generic catch to handle unexpected runtime exceptions gracefully
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Ensure scanner resource is closed
            input.close();
            System.out.println("\nThank you for using the Library Book Entry System!");
        }
    }
}
