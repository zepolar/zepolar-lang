package com.linbrox.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void shouldReturnTomorrowDate(){
        var expected = LocalDate.now().plusDays(1);
        var actual = DateUtils.tomorrow();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnYesterdayDate(){
        var expected = LocalDate.now().minusDays(1);
        var actual = DateUtils.yesterday();
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "2023-01-01T00:00:00",
            "2022-12-31T23:59:59",
            "2000-06-15T12:34:56",
            "2019-07-20T10:15:30",
            "1999-12-31T23:59:59"
            // You can add more past dates here
    })
    void shouldReturnTrueWhenDateTimeStringIsPast(String dateTimeStr){
        var actual = DateUtils.isPastDate(dateTimeStr);
        assertTrue(actual);
    }

    @Test
    void shouldThrownAnErrorWhenDateTimeStringIsNull(){
        String dateTimeStr = null;
        assertThrows(Exception.class, ()-> DateUtils.isPastDate(dateTimeStr));

    }
}