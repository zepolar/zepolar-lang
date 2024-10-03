package com.linbrox.common;

import java.util.Objects;

public final class BooleanUtils {

    private BooleanUtils() {}


    /**
     * Converts a String to a Boolean.
     *
     * @param value the String to be converted
     * @return the Boolean value represented by the string
     * @throws NullPointerException if the value is null
     *
     *                              <p>Examples:</p>
     *                              <pre>
     *                              {@code
     *                              Boolean result1 = BooleanUtils.toBoolean("true"); // returns true
     *                              Boolean result2 = BooleanUtils.toBoolean("false"); // returns false
     *                              }
     *                              </pre>
     */
    public static Boolean toBoolean(String value) {
        Objects.requireNonNull(value, "String cannot be null");
        return Boolean.valueOf(value);
    }

    /**
     * Converts an Integer to a Boolean.
     *
     * @param value the Integer to be converted, must be either 0 or 1
     * @return the Boolean value represented by the integer
     * @throws IllegalArgumentException if the value is not 0 or 1
     * @throws NullPointerException     if the value is null
     *
     *                                  <p>Examples:</p>
     *                                  <pre>
     *                                  {@code
     *                                  Boolean result1 = BooleanUtils.toBoolean(1); // returns true
     *                                  Boolean result2 = BooleanUtils.toBoolean(0); // returns false
     *                                  }
     *                                  </pre>
     */
    public static Boolean toBoolean(Integer value) {
        Objects.requireNonNull(value, "Integer cannot be null");
        if (value != 0 && value != 1) {
            throw new IllegalArgumentException("Integer value must be either 0 or 1");
        }
        return value != 0;
    }



}
