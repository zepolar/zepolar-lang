package com.linbrox.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void shouldReturnTrueWhenStringIsEmpty() {
        boolean actual = StringUtils.isEmpty("     ");
        assertTrue(actual);
    }

    @Test
    void shouldThrownAnExceptionWhenStringIsNull() {
        assertThrows( Exception.class, ()-> StringUtils.isEmpty(null));
    }

    @Test
    void shouldReturnTrueWhenEmailIIsValid() {
        boolean actual = StringUtils.isEmail( "algo@gmail.com");
        assertTrue(actual);
    }

    @Test
    void shouldReturnFalseWhenEmailIsInvalid() {
        boolean actual = StringUtils.isEmail("isInvalidEmail@");
        assertFalse(actual);
    }

    @Test
    void shouldReturnTrueWhenStringIsNumeric() {
        boolean actual = StringUtils.isNumeric("123");
        assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc1", " abc1", "abc2 ", ""})
    void shouldReturnFalseWhenStringIsNotAlpha(String value) {
        boolean actual = StringUtils.isAlpha(value);
        assertFalse(actual);
    }

    @Test
    void shouldReturnFalseWhenNullIsNotAlpha() {
        String value = null;
        assertThrows(Exception.class, ()-> StringUtils.isAlpha(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", " abc", "abc ", "    abc   "})
    void shouldReturnTrueWhenStringIsAlpha(String value) {
        boolean actual = StringUtils.isAlpha(value);
        assertTrue(actual, "This should be true");
    }
}