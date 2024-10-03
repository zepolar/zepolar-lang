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

}
