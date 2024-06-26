public class StringHelper {

    /**
     * Removes all carriage return characters from a string.
     *
     *
     * @param input the string to sanitize.
     * @return The sanitized string.
     */
    public static String RemoveReturns(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }
        String replaced = input.replaceAll("\r\n|\r|\n", " ");
        return replaced.trim();
    }

    /**
     * Removes all carriage return characters from a string.
     *
     *
     * @param input the string to sanitize.
     * @param replacement the value to replace returns with.
     * @return The sanitized string.
     */
    public static String RemoveReturns(String input, String replacement) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }
        String replaced = input.replaceAll("\r\n|\r|\n", replacement);
        return replaced.trim();
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