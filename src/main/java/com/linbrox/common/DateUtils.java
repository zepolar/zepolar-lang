package com.linbrox.common;

import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public final class DateUtils {

    private DateUtils() {}

    public static boolean isFutureDate(@NonNull Date date) {
        return LocalDate.now().isBefore(date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
    }

    public static boolean isPastDate(@NonNull String date) {
        return LocalDateTime.now().isAfter(LocalDateTime.parse(date));
    }
}
