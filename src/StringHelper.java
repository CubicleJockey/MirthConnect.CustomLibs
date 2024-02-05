public class StringHelper {
    /**
     * Removes all carriage return characters from a string.
     *
     * @param input The string to sanitize.
     * @return The sanitized string.
     */
    public static String RemoveCarriageReturns(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }
        return input.replace("\r", "");
    }

    /**
     * Checks if a string is null, empty, or contains only white space characters.
     *
     * @param str the string to check
     * @return true if the string is null, empty, or contains only white space characters; false otherwise.
     */
    public static boolean IsNullOrWhitespace(String str) {
        return str == null || str.trim().isEmpty();
    }
}
