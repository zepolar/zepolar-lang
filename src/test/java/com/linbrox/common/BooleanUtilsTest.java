


package com.linbrox.common;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BooleanUtilsTest {

    @Test
    public void testToBooleanTrueString() {
        // Prueba con el valor "true"
        assertTrue(BooleanUtils.toBoolean("true"));
    }

    @Test
    public void testToBooleanFalseString() {
        // Prueba con el valor "false"
        assertFalse(BooleanUtils.toBoolean("false"));
    }

    @Test
    public void testToBooleanCaseInsensitive() {
        // Prueba si es sensible a mayúsculas y minúsculas
        assertTrue(BooleanUtils.toBoolean("TRUE"));
        assertFalse(BooleanUtils.toBoolean("FALSE"));
    }

    @Test
    public void testToBooleanInvalidString() {
        // Prueba con un string que no sea "true" o "false"
        assertFalse(BooleanUtils.toBoolean("notABoolean"));
    }

    @Test
    public void testToBooleanNull() {
        // Prueba con valor nulo (debe lanzar una excepción)
        String booleanStr = null;
        assertThrows(Exception.class, ()-> BooleanUtils.toBoolean(booleanStr));

    }



}
