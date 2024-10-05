package com.linbrox.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"     ", ""})
    void shouldReturnTrueWhenStringIsEmpty(String value) {
        boolean actual = StringUtils.isEmpty(value);
        assertTrue(actual);
    }

    @ParameterizedTest  
    @ValueSource(strings = {"abc123", "test", "helloWorld", "myVariable", "Python3"})  
    void shouldReturnTrueWhenStringIsAlphanumericWithoutSpaces(String value) {  
        boolean actual = StringUtils.isAlphanumericWithoutSpaces(value);  
        Assertions.assertTrue(actual, "This should be true for alphanumeric strings without spaces");  
    }

    @Test
    void shouldThrownAnExceptionWhenStringIsNull() {
        assertThrows( Exception.class, ()-> StringUtils.isEmpty(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "algo@gmail.com",              // Valid email
            "test.user@example.com",       // Dot in local part
            "user+mailbox@domain.com",     // Plus sign in local part
            "user.name@sub.domain.com",    // Subdomain in domain part
            "name.surname@domain.co",      // Different domain
            "customer/department@domain.org", // Slash in local part
            "disposable.style.email.with+symbol@example.com", // Multiple dots and plus sign
            "user.name+tag+sorting@example.com", // Complex local part
            "x@example.com",               // One-letter local part
            "example-indeed@strange-example.com", // Hyphen in domain part
            "example@s.solutions",         // Single letter TLD
            "plainaddress@example.com"     // Plain email
    })
    void shouldReturnTrueWhenEmailIIsValid(String value) {
        boolean actual = StringUtils.isEmail(value);
        assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "isInvalidEmail@",         // Missing domain
            "invalid.email@domain",    // Missing top-level domain
            "invalid@.com",            // Missing local part
            "invalid@domain..com",     // Double dot in domain
            "invalid@domain,com",      // Comma instead of dot
            "@domain.com",             // Missing local part
            "invalidemail.com",        // Missing '@' symbol
            "invalid@domain.com.",     // Trailing dot
            "invalid@-domain.com",      // Domain starts with hyphen
            "customer/department@example" // Valid without TLD
    })
    void shouldReturnFalseWhenEmailIsInvalid(String value) {
        boolean actual = StringUtils.isEmail(value);
        assertFalse(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123",        // Numeric
            " 123",       // Leading space
            "123 ",       // Trailing space
            "+123",       // Positive sign
            " +123",      // Leading space and positive sign
            "+123 ",      // Positive sign and trailing space
            "-123",       // Negative sign
            " -123",      // Leading space and negative sign
            "-123 ",      // Negative sign and trailing space
            "0",          // Zero
            "    123   ", // Leading and trailing spaces
            "007"         // Leading zeroes
    })
    void shouldReturnTrueWhenStringIsNumeric(String value) {
        boolean actual = StringUtils.isNumeric(value);
        assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc1",      // Contains a digit
            " abc1",     // Leading space and digit
            "abc2 ",     // Trailing space and digit
            "",          // Empty string
            "abc def",   // Contains a space
            "123",       // Only digits
            "abc!",      // Contains special character
            "foo@bar",   // Contains special character
            "baz_qux",   // Contains underscore
            "hello123",  // Alphabets followed by numbers
            "123world",  // Numbers followed by alphabets
            "!@#$%^",    // Only special characters
            "mixedCase1", // Mixed case with digit
    })
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
    @ValueSource(strings = {
            "abc",         // Alphabetic lowercase
            " abc",        // Leading space
            "abc ",        // Trailing space
            "    abc   ",  // Leading and trailing spaces
            "ABC",         // Alphabetic uppercase
            " xyz ",       // Another set with spaces
            "helloWorld "  // Mixed case with trailing space
    })
    void shouldReturnTrueWhenStringIsAlpha(String value) {
        boolean actual = StringUtils.isAlpha(value);
        assertTrue(actual, "This should be true");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ab1c",         // Alphanumeric
            "ACB",          // Alphabetic uppercase
            "123",          // Numeric
            "aB3",          // Mixed case and numeric
            "A1c",          // Alphanumeric with a mix of cases and numbers
            "foo123",       // Alphanumeric word and numbers
            "BAR456",       // Uppercase letters and numbers
            "789xyz"       // Numbers followed by lowercase letters
    })
    void shouldReturnTrueWhenStringIsAlphaNumeric(String value) {
        boolean actual = StringUtils.isAlphaNumeric(value);
        assertTrue(actual, "This should be true");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc!123",   // Special character "!"
            "",          // Empty string
            "abc def",   // Space
            "123@",      // Special character "@"
            "hello#world", // Special character "#"
            "!@#$%^&*()",  // Only special characters
            "foo.bar",   // Special character "."
            "baz-qux",   // Special character "-"
            "alpha_beta", // Special character "_"
            "1234 5678", // Space in between numbers
            " ",         // Single space
            "\n",        // Newline character
            "tab\tcharacter", // Tab character
            "😊",        // Emoji
            "你好",       // Non-Latin characters
            "1234abc!",  // Valid alphanumeric with special character
            "abc\n123",  // Newline within the string
    })
    void shouldReturnFalseWhenStringIsNotAlphaNumeric(String value) {
        boolean actual = StringUtils.isAlphaNumeric(value);
        assertFalse(actual, "This should be false");
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "12.3",    // Positive decimal number
            "-12.3",   // Negative decimal number
            "0.123",   // Decimal number starting with zero
    })
    void shouldReturnTrueWhenStringIsNumericWithDecimals(String value){
        boolean actual = StringUtils.isNumericWithDecimal(value);
        assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc",      // Non-numeric string
            "123abc",   // Alphanumeric string
            "12.3.4",   // Multiple decimal points
            "",         // Empty string
            " ",        // Space
            "--123",    // Double negative sign
            "+-123",    // Conflicting signs
            "12.3e4"    // Scientific notation (optional to include based on requirements)
    })
    void shouldReturnFalseWhenStringIsNotNumericWithDecimals(String value) {
        boolean actual = StringUtils.isNumericWithDecimal(value);
        assertFalse(actual, "This should be false");
    }

}