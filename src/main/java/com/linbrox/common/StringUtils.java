package com.linbrox.common;

import java.util.Objects;
import java.util.regex.Pattern;

public final class StringUtils {

    public static final String EMAIL_FORMAT_PATTERN = "^(?!-)[\\w.!#$%&'*+/=?^_`{|}~-]+@(?!-)[A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)*(?:\\.[A-Za-z]{2,})$";
    private static final Pattern ALPHA_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    private static final Pattern ALPHA_NUMERIC_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[+-]?\\d+$");
    private static final Pattern NUMERIC_WITH_DECIMAL_PATTERN = Pattern.compile("^[+-]?\\d+\\.\\d+$");
    private static final String STRING_CANNOT_BE_NULL = "String cannot be null";

    private StringUtils() {
    }

    /**
     * Checks if a string is empty (null or blank).
     *
     * @param str the string to check
     * @return {@code true} if the string is empty or blank, {@code false} otherwise
     * @throws NullPointerException if the string is null
     * @example StringUtils.isEmpty(" "); // returns true
     * StringUtils.isEmpty("  "); // returns true
     * StringUtils.isEmpty("text"); // returns false
     */
    public static boolean isEmpty(String str) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        return isBlank(str);
    }

    /**
     * Checks if a string is not empty (not null or not blank).
     *
     * @param str the string to check
     * @return {@code true} if the string is not empty or not blank, {@code false} otherwise
     * @throws NullPointerException if the string is null
     * @example StringUtils.isNotEmpty(" "); // returns false
     * StringUtils.isNotEmpty("  "); // returns false
     * StringUtils.isNotEmpty("text"); // returns true
     */
    public static boolean isNotEmpty(String str) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        return !isEmpty(str);
    }

    /**
     * Checks if a string is blank.
     *
     * @param str the string to check
     * @return {@code true} if the string is blank, {@code false} otherwise
     * @throws NullPointerException if the string is null
     * @example StringUtils.isBlank(" "); // returns true
     * StringUtils.isBlank("  "); // returns true
     * StringUtils.isBlank("text"); // returns false
     */
    public static boolean isBlank(String str) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        return str.trim().isEmpty();
    }

    /**
     * Checks if a string is not blank.
     *
     * @param str the string to check
     * @return {@code true} if the string is not blank, {@code false} otherwise
     * @throws NullPointerException if the string is null
     * @example StringUtils.isNotBlank(" "); // returns false
     * StringUtils.isNotBlank("  "); // returns false
     * StringUtils.isNotBlank("text"); // returns true
     */
    public static boolean isNotBlank(String str) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        return !str.trim().isEmpty();
    }

    /**
     * Checks if a string is numeric.
     *
     * @param str the string to check
     * @return {@code true} if the string is numeric, {@code false} otherwise
     * @throws NullPointerException if the string is null
     * @example StringUtils.isNumeric(" 123 "); // returns true
     * StringUtils.isNumeric("-1563"); // returns true
     * StringUtils.isNumeric("+1563"); // returns true
     * StringUtils.isNumeric("abc"); // returns false
     */
    public static boolean isNumeric(String str) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        return NUMERIC_PATTERN.matcher(str.trim()).matches();
    }

    /**
     * Checks if a string is numeric with a decimal point.
     *
     * @param str the string to check
     * @return {@code true} if the string is numeric with a decimal, {@code false} otherwise
     * @throws NullPointerException if the string is null
     * @example StringUtils.isNumericWithDecimal(" 123.45 "); // returns true
     * StringUtils.isNumericWithDecimal("-123.45"); // returns true
     * StringUtils.isNumericWithDecimal("abc"); // returns false
     */
    public static boolean isNumericWithDecimal(String str) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        return NUMERIC_WITH_DECIMAL_PATTERN.matcher(str.trim()).matches();
    }

    /**
     * Checks if a string is a valid email address.
     *
     * @param str the string to check
     * @return {@code true} if the string is a valid email, {@code false} otherwise
     * @throws NullPointerException if the string is null
     * @example StringUtils.isEmail("example@example.com"); // returns true
     * StringUtils.isEmail("example@.com"); // returns false
     * StringUtils.isEmail("example.com"); // returns false
     */
    public static boolean isEmail(String str) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        return str.matches(EMAIL_FORMAT_PATTERN);
    }

    /**
     * Checks if a string is alphanumeric.
     *
     * @param str the string to check
     * @return {@code true} if the string is alphanumeric, {@code false} otherwise
     * @throws NullPointerException if the string is null
     * @example StringUtils.isAlphaNumeric(" abc123 "); // returns true
     * StringUtils.isAlphaNumeric("abc 123"); // returns false
     * StringUtils.isAlphaNumeric("abc!123"); // returns false
     */
    public static boolean isAlphaNumeric(String str) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        return ALPHA_NUMERIC_PATTERN.matcher(str.trim()).matches();
    }

    /**
     * Checks if a string contains only letters.
     *
     * @param str the string to check
     * @return {@code true} if the string contains only letters, {@code false} otherwise
     * @throws NullPointerException if the string is null
     * @example StringUtils.isAlpha(" abc "); // returns true
     * StringUtils.isAlpha("123"); // returns false
     * StringUtils.isAlpha("abc123"); // returns false
     */
    public static boolean isAlpha(String str) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        return ALPHA_PATTERN.matcher(str.trim()).matches();
    }

    public static String capitalize(String str) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        if (str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String uncapitalize(String str) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        if (str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static String reverse(String str) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        return str.isEmpty() ? str : new StringBuilder(str).reverse().toString();
    }

    public static String leftPad(String str, int size, String pad) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        if (str.length() >= size) {
            return str;
        }
        StringBuilder padded = new StringBuilder(size);
        padded.append(String.valueOf(pad).repeat(size - str.length()));
        padded.append(str);
        return padded.substring(0, size);
    }

    public static String leftPad(String str, int size) {
        return leftPad(str, size, "0");
    }

    public static String rightPad(String str, int size, String pad) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        if (str.length() >= size) {
            return str;
        }
        StringBuilder padded = new StringBuilder(size);
        padded.append(str);
        padded.append(String.valueOf(pad).repeat(size - str.length()));
        return padded.substring(0, size);
    }

    public static String rightPad(String str, int size) {
        return rightPad(str, size, "0");
    }

    public static String repeat(String str, int count) {
        Objects.requireNonNull(str, STRING_CANNOT_BE_NULL);
        if (count <= 0) {
            return "";
        }
        return str.repeat(count);
    }
    
    public static boolean areStringsEqual(String str1, String str2) {
        Objects.requireNonNull(str1, "String 1 cannot be null");
        Objects.requireNonNull(str2, "String 2 cannot be null");
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean areStringsEqualIgnoreCase(String str1, String str2) {
        Objects.requireNonNull(str1, "String 1 cannot be null");
        Objects.requireNonNull(str2, "String 2 cannot be null");
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (Character.toLowerCase(str1.charAt(i)) != Character.toLowerCase(str2.charAt(i))) {
                return false;
            }
        }
        return true;
    }



}
