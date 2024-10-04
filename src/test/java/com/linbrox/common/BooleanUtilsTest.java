package com.linbrox.common;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class BooleanUtilsTest {


    @Test
    public void shouldReturnTrueWithValueOne() {
        // Arrange
        Integer value = 1;

        // Act
        Boolean result = BooleanUtils.toBoolean(value);

        // Assert
        assertTrue(result, "Expected true when input is 1");
    }

    @Test
    public void shouldReturnFalseWithValueZero() {
        // Arrange
        Integer value = 0;

        // Act
        Boolean result = BooleanUtils.toBoolean(value);

        // Assert
        assertFalse(result, "Expected false when input is 0");
    }

    @Test
    public void shouldReturnThrowsWithNullValue() {
        // Arrange
        Integer value = null;

        // Act & Assert
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            BooleanUtils.toBoolean(value);
        });

        assertEquals("Integer cannot be null", exception.getMessage());
    }


    @ParameterizedTest
    @ValueSource(ints = {2, 3, -1, 4, 5})
    public void shouldReturnThrowsWithInvalidValue(int value) {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            BooleanUtils.toBoolean(value);
        });

        assertEquals("Integer value must be either 0 or 1", exception.getMessage());
    }
}