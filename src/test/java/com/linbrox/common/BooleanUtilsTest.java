package com.linbrox.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BooleanUtilsTest {

    private static final Integer ONE = 1;
    private static final Integer ZERO = 0;
    private static final Integer NULL_VALUE = null;

    @Test
    void shouldReturnTrueForValueOne() {
        assertBooleanConversion(ONE, true, "Expected true when input is 1");
    }

    @Test
    void shouldReturnFalseForValueZero() {
        assertBooleanConversion(ZERO, false, "Expected false when input is 0");
    }

    // Métodos auxiliar para evitar repetición
    private void assertBooleanConversion(Integer input, boolean expected, String message) {
        // Act
        Boolean result = BooleanUtils.toBoolean(input);
        // Assert
        assertEquals(expected, result, message);
    }

    @Test
    void shouldThrowExceptionForNullValue() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> BooleanUtils.toBoolean(NULL_VALUE));
        assertEquals("Integer cannot be null", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, -1, 4, 5})
    void shouldThrowExceptionForInvalidValues(int value) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> BooleanUtils.toBoolean(value));
        assertEquals("Integer value must be either 0 or 1", exception.getMessage());
    }
}
