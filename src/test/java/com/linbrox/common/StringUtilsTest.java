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

}