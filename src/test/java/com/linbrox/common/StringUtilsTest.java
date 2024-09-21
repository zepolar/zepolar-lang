package com.linbrox.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void shouldReturnTrueWhenStringIsEmpty() {
        boolean actual = StringUtils.isEmpty("");
        assertTrue(actual);
    }

    @Test
    void shouldThrownAnExceptionWhenStringIsNull() {
        assertThrows( Exception.class, ()-> StringUtils.isEmpty(null));
    }

    @Test
    void shouldReturnTrueWhenEmailIIsValid() {
        boolean actual = StringUtils.isEmail("algo@gmail.com");
        assertTrue(actual);
    }

    @Test
    void shouldReturnFalseWhenEmailIsInvalid() {
        boolean actual = StringUtils.isEmail("isInvalidEmail");
        assertFalse(actual);
    }

    @Test
    void shouldReturnTrueWhenStringIsNumeric() {
        boolean actual = StringUtils.isNumeric("123");
        assertTrue(actual);
    }
}