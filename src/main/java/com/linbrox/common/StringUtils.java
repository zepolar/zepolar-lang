package com.linbrox.common;

import lombok.NonNull;

public final class StringUtils {

    public static final String DIGIT_FORMAT_PATTERN = "-?\\d+(\\.\\d+)?";

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

}
