package com.linbrox.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class NumericUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "10.0",         // Simple decimal
            "0.0",          // Zero
            "1234567890.123456789", // Large number
            "0.0000001",    // Small decimal
            "-42.42",       // Negative number
            "3.1415926535", // Pi approximation
            "2.7182818284", // Euler's number approximation
            "1E5",          // Exponential notation
            "-1E-5",        // Negative exponential notation
            "1000",         // Integer string
            ".5",           // Missing leading zero
            "100.",         // Trailing dot
            "+123.45"       // Positive number with leading sign
    })
    void shouldReturnBigDecimalWhenInputStringIsValid(String value) {
        BigDecimal actual = NumericUtils.toBigDecimal(value);
        assertEquals(new BigDecimal(value), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1.1.1",        // Multiple dots
            "abc",          // Alphabetic characters
            "123abc",       // Alphanumeric characters
            "",             // Empty string
            " ",            // Space
            "1.2.3",        // Multiple dots again, variation
            "-.1.2",        // Negative sign and multiple dots
            "1..0",         // Double dot
            ".1.",          // Dot at start and end
            "- 10",         // Invalid minus spacing
            "+123.45.67",   // Plus sign with multiple dots
            "1E10.5",       // Invalid scientific notation
            "NaN",          // Not a number
            "Infinity"     // Infinity string
    })
    void shouldThrownAnExceptionWhenInputStringIsInvalid(String value) {
        assertThrows(Exception.class, () -> NumericUtils.toBigDecimal(value));
    }

    @Test
    void shouldThrownAnExceptionWhenInputStringIsNull(){
        String value = null;
        assertThrows(Exception.class, () -> NumericUtils.toBigDecimal(value));
    }
    // Prueba que verifica que se lanza una excepción cuando la cadena es nula.
    @Test
    public void testToDouble_nullString() {
        assertThrows(NullPointerException.class, () -> {
            NumericUtils.toDouble(null);
        });
    }

    // Prueba que verifica la conversión de una cadena válida a un valor BigDecimal.
    @Test
    public void testToBigDecimal_validString() {
        String validBigDecimalStr = "123456.789";
        BigDecimal result = NumericUtils.toBigDecimal(validBigDecimalStr);
        assertEquals(new BigDecimal("123456.789"), result);
    }

    // Prueba que verifica que se lanza una excepción cuando la cadena no es válida para un BigDecimal.
    @Test
    public void testToBigDecimal_invalidString() {
        String invalidBigDecimalStr = "invalid";
        assertThrows(NumberFormatException.class, () -> {
            NumericUtils.toBigDecimal(invalidBigDecimalStr);
        });
    }

    // Prueba que verifica que se lanza una excepción cuando la cadena es nula.
    @Test
    public void testToBigDecimal_nullString() {
        assertThrows(NullPointerException.class, () -> {
            NumericUtils.toBigDecimal(null);
        });
    }

}