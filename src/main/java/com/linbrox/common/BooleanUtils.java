package com.linbrox.common;

import lombok.NonNull;

public final class BooleanUtils {

    private BooleanUtils() {}

    public static Boolean toBoolean(@NonNull String value) {
        return Boolean.valueOf(value);
    }

    public static Boolean toBoolean(@NonNull Integer value) {
        if (value != 0 && value != 1) {
            throw new IllegalArgumentException("Integer value must be either 0 or 1");
        }
        return value != 0;
    }

}
