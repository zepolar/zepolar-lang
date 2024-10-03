package com.linbrox.common;

import org.junit.jupiter.api.Test;

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


    @Test
    void shouldReturnTrueWhenDateIsPast(){
        LocalDate localDate = LocalDate.now().minusDays(1);
        var actual = DateUtils.isPastDate(localDate.atStartOfDay());
        assertTrue(actual);
    }


}