package com.linbrox.common;

import java.util.Objects;
import java.util.regex.Pattern;

public final class StringUtils {

    public static final String EMAIL_FORMAT_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern ALPHA_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    private static final Pattern ALPHA_NUMERIC_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[+-]?\\d+$");
    private static final Pattern NUMERIC_WITH_DECIMAL_PATTERN = Pattern.compile("^[+-]?\\d+\\.\\d+$");

    private StringUtils() {
    }


    /**
     * Checks if a string is empty (null or blank).
     *
     * @param str the string to check
     * @return {@code true} if the string is empty or blank, {@code false} otherwise
     * @throws IllegalArgumentException if the string is null
     * @example StringUtils.isEmpty(" "); // returns true
     * StringUtils.isEmpty("  "); // returns true
     * StringUtils.isEmpty("text"); // returns false
     */
    public static boolean isEmpty(String str) {
        return isBlank(str);
    }

    /**
     * Checks if a string is not empty (not null or not blank).
     *
     * @param str the string to check
     * @return {@code true} if the string is not empty or not blank, {@code false} otherwise
     * @throws IllegalArgumentException if the string is null
     * @example StringUtils.isNotEmpty(" "); // returns false
     * StringUtils.isNotEmpty("  "); // returns false
     * StringUtils.isNotEmpty("text"); // returns true
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * Checks if a string is blank.
     *
     * @param str the string to check
     * @return {@code true} if the string is blank, {@code false} otherwise
     * @throws IllegalArgumentException if the string is null
     * @example StringUtils.isBlank(" "); // returns true
     * StringUtils.isBlank("  "); // returns true
     * StringUtils.isBlank("text"); // returns false
     */
    public static boolean isBlank(String str) {
        return str.trim().isEmpty();
    }

    /**
     * Checks if a string is not blank.
     *
     * @param str the string to check
     * @return {@code true} if the string is not blank, {@code false} otherwise
     * @throws IllegalArgumentException if the string is null
     * @example StringUtils.isNotBlank(" "); // returns false
     * StringUtils.isNotBlank("  "); // returns false
     * StringUtils.isNotBlank("text"); // returns true
     */
    public static boolean isNotBlank(String str) {
        return !str.trim().isEmpty();
    }

    /**
     * Checks if a string is numeric.
     *
     * @param str the string to check
     * @return {@code true} if the string is numeric, {@code false} otherwise
     * @throws IllegalArgumentException if the string is null
     * @example StringUtils.isNumeric(" 123 "); // returns true
     * StringUtils.isNumeric("-1563"); // returns true
     * StringUtils.isNumeric("abc"); // returns false
     */
    public static boolean isNumeric(String str) {
        return NUMERIC_PATTERN.matcher(str.trim()).matches();
    }

    /**
     * Checks if a string is numeric with a decimal point.
     *
     * @param str the string to check
     * @return {@code true} if the string is numeric with a decimal, {@code false} otherwise
     * @throws IllegalArgumentException if the string is null
     * @example StringUtils.isNumericWithDecimal(" 123.45 "); // returns true
     * StringUtils.isNumericWithDecimal("-123.45"); // returns true
     * StringUtils.isNumericWithDecimal("abc"); // returns false
     */
    public static boolean isNumericWithDecimal(String str) {
        return NUMERIC_WITH_DECIMAL_PATTERN.matcher(str.trim()).matches();
    }

    /**
     * Checks if a string is a valid email address.
     *
     * @param str the string to check
     * @return {@code true} if the string is a valid email, {@code false} otherwise
     * @throws IllegalArgumentException if the string is null
     * @example StringUtils.isEmail("example@example.com"); // returns true
     * StringUtils.isEmail("example@.com"); // returns false
     * StringUtils.isEmail("example.com"); // returns false
     */
    public static boolean isEmail(String str) {
        return str.matches(EMAIL_FORMAT_PATTERN);
    }

    /**
     * Checks if a string is alphanumeric.
     *
     * @param str the string to check
     * @return {@code true} if the string is alphanumeric, {@code false} otherwise
     * @throws IllegalArgumentException if the string is null
     * @example StringUtils.isAlphaNumeric(" abc123 "); // returns true
     * StringUtils.isAlphaNumeric("abc 123"); // returns false
     * StringUtils.isAlphaNumeric("abc!123"); // returns false
     */
    public static boolean isAlphaNumeric(String str) {
        return ALPHA_NUMERIC_PATTERN.matcher(str.trim()).matches();
    }

    /**
     * Checks if a string contains only letters.
     *
     * @param str the string to check
     * @return {@code true} if the string contains only letters, {@code false} otherwise
     * @throws IllegalArgumentException if the string is null
     * @example StringUtils.isAlpha(" abc "); // returns true
     * StringUtils.isAlpha("123"); // returns false
     * StringUtils.isAlpha("abc123"); // returns false
     */
    public static boolean isAlpha(String str) {
        Objects.requireNonNull(str, "String cannot be null");
        return ALPHA_PATTERN.matcher(str.trim()).matches();
    }
}
