package library.util;

// Utility class inside library.util package to validate resource parameters
public class InputValidator {

    // Validate that Resource ID is strictly positive (> 0)
    public static boolean validateResourceId(int resourceId) {
        return resourceId > 0;
    }

    // Validate that Fine days is non-negative (>= 0)
    public static boolean validateFineDays(int overdueDays) {
        return overdueDays >= 0;
    }
}
