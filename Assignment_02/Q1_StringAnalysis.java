// Q1: String Analysis
import java.util.*;

public class Q1_StringAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String text = sc.nextLine();

        int upper = 0, lower = 0, digits = 0, spaces = 0;

        // Loop to count uppercase, lowercase, digits, and spaces
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) upper++;
            else if (Character.isLowerCase(c)) lower++;
            else if (Character.isDigit(c)) digits++;
            else if (Character.isWhitespace(c)) spaces++;
        }
        sc.close();
        // Count words based on whitespace separation
        int words = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
        // Output the results
        System.out.println("\nString Analysis:");
        System.out.println("Uppercase Letters: " + upper);
        System.out.println("Lowercase Letters: " + lower);
        System.out.println("Digits: " + digits);
        System.out.println("Whitespace Characters: " + spaces);
        System.out.println("Number of Words: " + words);
    }
}

/*  Input/Output Example:
    Enter a line of text:
    Hello World 123
    
    String Analysis:
    Uppercase Letters: 2
    Lowercase Letters: 8
    Digits: 3
    Whitespace Characters: 2
    Number of Words: 3
*/