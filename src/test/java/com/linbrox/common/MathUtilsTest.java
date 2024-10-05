package com.linbrox.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    @Test
    void shouldReturnFactorialOfNumber() {
        assertEquals(120, MathUtils.factorial(5));
        assertEquals(1, MathUtils.factorial(0)); // Caso base
    }

    @Test
    void shouldThrowExceptionForNegativeFactorial() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.factorial(-1));
    }

    @Test
    void shouldReturnAverageOfArray() {
        int[] numbers = {1, 2, 3, 4, 5};
        assertEquals(3.0, MathUtils.average(numbers), 0.01);
    }

    @Test
    void shouldThrowExceptionForEmptyArray() {
        int[] emptyArray = {};
        assertThrows(IllegalArgumentException.class, () -> MathUtils.average(emptyArray));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11})
    void shouldReturnTrueForPrimeNumbers(int number) {
        assertTrue(MathUtils.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 9, 10})
    void shouldReturnFalseForNonPrimeNumbers(int number) {
        assertFalse(MathUtils.isPrime(number));
    }
}
