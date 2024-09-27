package com.linbrox.common;

import lombok.NonNull;

public final class StringUtils {

    public static final String DIGIT_FORMAT_PATTERN = "-?\\d+(\\.\\d+)?";
    public static final String EMAIL_FORMAT_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String ALPHA_NUMERIC_REGEX = "[a-zA-Z0-9]+";
    public static final String ALPHA_REGEX = "[a-zA-Z]+";

    private StringUtils() {
    }

    public static boolean isEmpty(@NonNull String str) {
        return str.isEmpty();
    }

    public static boolean isNotEmpty(@NonNull String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(@NonNull String str) {
        return isEmpty(str) || str.trim().isEmpty();
    }

    public static boolean isNotBlank(@NonNull String str) {
        return !isBlank(str);
    }

    public static boolean isNumeric(@NonNull String str) {
        return str.matches(DIGIT_FORMAT_PATTERN);
    }

    public static boolean isEmail(@NonNull String str) {
        return str.matches(EMAIL_FORMAT_PATTERN);
    }

    public static boolean isAlphaNumeric(@NonNull String str) {
        return str.matches(ALPHA_NUMERIC_REGEX);
    }

    public static boolean isAlpha(@NonNull String str) {
        return str.matches(ALPHA_REGEX);
    }
}
