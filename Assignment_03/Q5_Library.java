package Assignment_03;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Book class demonstrating encapsulation with getters/setters and validation.
 */
class Book {
    private String title;
    private String author;
    private double price;

    public Book(String t, String a, double p) {
        this.title = t;
        this.author = a;
        this.price = p;
    }

    /* Getters and setters with basic validation */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title.trim();
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author.trim();
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Price must be positive. Update skipped.");
        }
    }

    // Nicely formatted display for a book
    public void display() {
        System.out.printf("Title : %s | Author: %s | Price: Rs. %.2f%n", title, author, price);
    }

    @Override
    public String toString() {
        return String.format("%s by %s - Rs. %.2f", title, author, price);
    }
}

/**
 * Q5_Library (enhanced) — menu-driven library system supporting multiple books.
 */
public class Q5_Library {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Book> library = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Library Management (Multiple Books) ===");

        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = readIntInRange("Choose an option (1-6): ", 1, 6);
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBookPrice();
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    listAllBooks();
                    break;
                case 5:
                    removeBook();
                    break;
                case 6:
                    exit = true;
                    System.out.println("\nExiting Library Management. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Book");
        System.out.println("2. Update Book Price");
        System.out.println("3. Search Books (by title or author)");
        System.out.println("4. List All Books");
        System.out.println("5. Remove Book (by title)");
        System.out.println("6. Exit");
    }

    /**
     * Add a book to library with validated inputs.
     */
    private static void addBook() {
        System.out.println("\n-- Add Book --");
        String title = readNonEmptyString("Enter Book Title: ");
        String author = readNonEmptyString("Enter Author Name: ");
        double price = readPositiveDouble("Enter Book Price (Rs.): ");

        Book b = new Book(title, author, price);
        library.add(b);
        System.out.println("Book added successfully:");
        b.display();
    }

    /**
     * Update price for a book (search by title, case-insensitive).
     * If multiple books share title, update the first match or show options.
     */
    private static void updateBookPrice() {
        System.out.println("\n-- Update Book Price --");
        if (library.isEmpty()) {
            System.out.println("No books in library. Add books first.");
            return;
        }
        String title = readNonEmptyString("Enter Book Title to update: ");
        List<Book> matches = findBooksByTitle(title);

        if (matches.isEmpty()) {
            System.out.println("No book found with title containing: " + title);
            return;
        }

        if (matches.size() == 1) {
            Book b = matches.get(0);
            System.out.println("Found: " + b);
            double newPrice = readPositiveDouble("Enter new price (Rs.): ");
            b.setPrice(newPrice);
            System.out.println("Price updated.");
            b.display();
        } else {
            // Multiple matches — show list and allow user to pick
            System.out.println("Multiple books found:");
            for (int i = 0; i < matches.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, matches.get(i));
            }
            int idx = readIntInRange("Choose book number to update: ", 1, matches.size()) - 1;
            Book chosen = matches.get(idx);
            double newPrice = readPositiveDouble("Enter new price (Rs.): ");
            chosen.setPrice(newPrice);
            System.out.println("Price updated.");
            chosen.display();
        }
    }

    /**
     * Search books by title or author (case-insensitive substring match).
     */
    private static void searchBooks() {
        System.out.println("\n-- Search Books --");
        if (library.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        String keyword = readNonEmptyString("Enter title or author to search: ").toLowerCase();
        List<Book> results = new ArrayList<>();
        for (Book b : library) {
            if (b.getTitle().toLowerCase().contains(keyword) || b.getAuthor().toLowerCase().contains(keyword)) {
                results.add(b);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No books found matching: " + keyword);
        } else {
            System.out.println("Search results:");
            for (Book b : results) {
                b.display();
            }
        }
    }

    /**
     * List all books currently in the library.
     */
    private static void listAllBooks() {
        System.out.println("\n-- All Books --");
        if (library.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        int idx = 1;
        for (Book b : library) {
            System.out.printf("%d. %s%n", idx++, b);
        }
    }

    /**
     * Remove a book by title (first matching). If multiple matches, allow selection.
     */
    private static void removeBook() {
        System.out.println("\n-- Remove Book --");
        if (library.isEmpty()) {
            System.out.println("No books to remove.");
            return;
        }
        String title = readNonEmptyString("Enter Book Title to remove: ");
        List<Book> matches = findBooksByTitle(title);

        if (matches.isEmpty()) {
            System.out.println("No book found with title containing: " + title);
            return;
        }

        if (matches.size() == 1) {
            Book b = matches.get(0);
            library.remove(b);
            System.out.println("Removed: " + b);
        } else {
            System.out.println("Multiple books found:");
            for (int i = 0; i < matches.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, matches.get(i));
            }
            int idx = readIntInRange("Choose book number to remove: ", 1, matches.size()) - 1;
            Book chosen = matches.get(idx);
            library.remove(chosen);
            System.out.println("Removed: " + chosen);
        }
    }

    /* ---------- Utility methods ---------- */

    // Find books whose title contains the query (case-insensitive)
    private static List<Book> findBooksByTitle(String title) {
        List<Book> results = new ArrayList<>();
        String lower = title.toLowerCase();
        for (Book b : library) {
            if (b.getTitle().toLowerCase().contains(lower)) {
                results.add(b);
            }
        }
        return results;
    }

    // Read integer in [min..max]
    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = sc.nextInt();
                sc.nextLine(); // consume newline
                if (val < min || val > max) {
                    System.out.printf("Please enter a number between %d and %d.%n", min, max);
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input! Please enter an integer.");
                sc.nextLine();
            }
        }
    }

    // Read a positive double (> 0)
    private static double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = sc.nextDouble();
                sc.nextLine(); // consume newline
                if (val <= 0) {
                    System.out.println("Value must be greater than 0. Try again.");
                    continue;
                }
                return val;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input! Please enter a numeric value.");
                sc.nextLine();
            }
        }
    }

    // Read a non-empty string
    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("Input cannot be empty. Try again.");
                continue;
            }
            return s;
        }
    }
}
