package com.linbrox.common;

import java.math.BigDecimal;

public final class NumericUtils {

    private NumericUtils() {

    }

    public static Integer toInteger(String value) {
        return Integer.valueOf(value);
    }

    public static Double toDouble(String value){
        return Double.valueOf(value);
    }

    public static BigDecimal toBigDecimal(String value){
        return new BigDecimal(value);
    }

    /**
     * Converts a String to a Long.
     *
     * @param value the String to be converted
     * @return the Long representation of the String
     * @throws NumberFormatException if the string cannot be parsed as a Long
     */
    public static Long toLong(String value) {
        return Long.valueOf(value);
    }

    /**
     * Converts a String to a Float.
     *
     * @param value the String to be converted
     * @return the Float representation of the String
     * @throws NumberFormatException if the string cannot be parsed as a Float
     */
    public static Float toFloat(String value) {
        return Float.valueOf(value);
    }

}
