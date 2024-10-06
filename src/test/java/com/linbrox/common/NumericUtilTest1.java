package com.linbrox.common;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class NumericUtilTest1 {

    // Prueba que verifica la conversión de una cadena válida a un valor Integer.
    @Test
    public void testToInteger_validString() {
        String validIntStr = "100";
        Integer result = NumericUtils.toInteger(validIntStr);
        assertEquals(100, result);
    }

    // Prueba que verifica que se lanza una excepción cuando la cadena no es válida para un Integer.
    @Test
    public void testToInteger_invalidString() {
        String invalidIntStr = "abc";
        assertThrows(NumberFormatException.class, () -> {
            NumericUtils.toInteger(invalidIntStr);
        });
    }

    // Prueba que verifica que se lanza una excepción cuando la cadena es nula.
    @Test
    public void testToInteger_nullString() {
        assertThrows(NumberFormatException.class, () -> {
            NumericUtils.toInteger(null);
        });
    }

    // Prueba que verifica la conversión de una cadena válida a un valor Double.
    @Test
    public void testToDouble_validString() {
        String validDoubleStr = "123.45";
        Double result = NumericUtils.toDouble(validDoubleStr);
        assertEquals(123.45, result);
    }

    // Prueba que verifica que se lanza una excepción cuando la cadena no es válida para un Double.
    @Test
    public void testToDouble_invalidString() {
        String invalidDoubleStr = "xyz";
        assertThrows(NumberFormatException.class, () -> {
            NumericUtils.toDouble(invalidDoubleStr);
        });
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
