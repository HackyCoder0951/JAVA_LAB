// Q2: Password Validator
import java.util.*;
class Q2_PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        boolean hasUpper = false, hasLower = false, hasDigit = false;

        // Check each character in the password
        if (password.length() >= 8) {
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUpper = true;
                if (Character.isLowerCase(c)) hasLower = true;
                if (Character.isDigit(c)) hasDigit = true;
            }
        }
        sc.close();

        // Validate based on conditions
        if (hasUpper && hasLower && hasDigit && password.length() >= 8) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password: Must contain at least 8 characters with at least one uppercase, lowercase, and digit.");
        }
    }
}