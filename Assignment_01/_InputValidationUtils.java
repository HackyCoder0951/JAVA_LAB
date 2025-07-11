package Assignment_01;

public class _InputValidationUtils {
    public static final int INT_MIN = -2147483648;
    public static final int INT_MAX = 2147483647;
    public static boolean isValidInt(String s) {
        try {
            int n = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static int parseIntOrError(String s) throws NumberFormatException {
        return Integer.parseInt(s);
    }
}
