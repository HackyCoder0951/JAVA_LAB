package Assignment_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * FileHandler class encapsulates file operations:
 * - writeToFile  -> overwrite file with new content
 * - appendToFile -> append content to existing file (or create if not exists)
 * - readFromFile -> read and print file contents
 */
class FileHandler {
    private final String filename;

    public FileHandler(String filename) {
        this.filename = filename;
    }

    /**
     * Overwrite (write) content to the file. Uses try-with-resources to ensure the writer is closed.
     *
     * @param content text to write into file (overwrites existing content)
     */
    public void writeToFile(String content) {
        // FileWriter default (no append) will overwrite the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            writer.write(content);
            writer.newLine();
            System.out.println("File written successfully (overwrite mode).");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Append content to the file. If the file doesn't exist it will be created.
     *
     * @param content text to append
     */
    public void appendToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

    /**
     * Read and print the file contents line by line.
     */
    public void readFromFile() {
        System.out.println("\n=== Reading from file: " + filename + " ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean hasContent = false;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                hasContent = true;
            }
            if (!hasContent) {
                System.out.println("(File is empty)");
            }
            System.out.println("File read completed.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

/**
 * Main program for Q10_File: provides a menu to perform file operations interactively.
 */
public class Q10_File {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("=== Java File Handling Program ===");

            // Ask filename once (menu will operate on this file)
            String filename = "";
            while (true) {
                System.out.print("Enter filename (e.g., notes.txt): ");
                filename = sc.nextLine().trim();
                if (filename.isEmpty()) {
                    System.out.println("Filename cannot be empty. Try again.");
                    continue;
                }
                break;
            }

            FileHandler fh = new FileHandler(filename);

            boolean exit = false;
            while (!exit) {
                // Menu
                System.out.println("\nMenu:");
                System.out.println("1. Write (overwrite) file");
                System.out.println("2. Append to file");
                System.out.println("3. Read file");
                System.out.println("4. Exit");
                System.out.print("Choose an option (1-4): ");

                int choice = readIntInRange(sc, 1, 4);

                switch (choice) {
                    case 1:
                        // Overwrite file: get content (multi-line until a sentinel)
                        System.out.println("\n-- Write (overwrite) --");
                        String content = readMultilineContent(sc);
                        fh.writeToFile(content);
                        break;

                    case 2:
                        // Append mode: get content to append
                        System.out.println("\n-- Append --");
                        String appendContent = readMultilineContent(sc);
                        fh.appendToFile(appendContent);
                        break;

                    case 3:
                        // Read and display file contents
                        fh.readFromFile();
                        break;

                    case 4:
                        // Exit
                        exit = true;
                        System.out.println("\nExiting File Handling Program. Goodbye!");
                        break;

                    default:
                        // Defensive: should not happen due to input validation
                        System.out.println("Invalid option. Try again.");
                }
            }
        } catch (Exception e) {
            // Catch unexpected exceptions to avoid abrupt termination
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Ensure scanner closed
            sc.close();
        }
    }

    /**
     * Read an integer within inclusive [min..max] from the scanner.
     * Keeps prompting until the user enters a valid integer in range.
     */
    private static int readIntInRange(Scanner sc, int min, int max) {
        while (true) {
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                if (val < min || val > max) {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                    continue;
                }
                return val;
            } catch (NumberFormatException nfe) {
                System.out.print("Invalid input! Please enter an integer: ");
            }
        }
    }

    /**
     * Helper to read multiline content from the user.
     * Instruction: user types lines; entering a single line with only "END" will finish input.
     *
     * @param sc Scanner (already initialised)
     * @return concatenated multiline content as a single string
     */
    private static String readMultilineContent(Scanner sc) {
        System.out.println("Enter content. Type a single line with only END to finish:");
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.equals("END")) { // sentinel to finish multiline input
                break;
            }
            sb.append(line).append(System.lineSeparator());
        }
        return sb.toString().trim(); // trim trailing newline
    }
}
