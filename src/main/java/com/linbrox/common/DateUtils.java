package com.linbrox.common;

import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Date;

public final class DateUtils {

    private DateUtils() {}

    /**
     * Checks if the given date is in the future.
     *
     * @param date the date to be checked
     * @return {@code true} if the given date is in the future, {@code false} otherwise
     * @throws NullPointerException if the date is null
     *                              <p>
     *                              Example usage:
     *                              <pre>
     *                                Date futureDate = new Date(System.currentTimeMillis() + 10000); // 10 sec in the future
     *                                boolean isFuture = DateUtils.isFutureDate(futureDate);
     *                                System.out.println(isFuture); // Should print true if executed immediately
     *                              </pre>
     */
    public static boolean isFutureDate(@NonNull Date date) {
        return LocalDate.now().isBefore(date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
    }

    /**
     * Checks if the given date string is in the past.
     *
     * @param date the date string to be checked in ISO_LOCAL_DATE_TIME format (e.g., "2023-10-12T07:20:50")
     * @return {@code true} if the given date string is in the past, {@code false} otherwise
     * @throws NullPointerException   if the date string is null
     * @throws DateTimeParseException if the date string cannot be parsed
     *                                <p>
     *                                Example usage:
     *                                <pre>
     *                                  String pastDate = "2023-01-01T00:00:00";
     *                                  boolean isPast = DateUtils.isPastDate(pastDate);
     *                                  System.out.println(isPast); // Should print true if the current date is after 2023-01-01
     *                                </pre>
     */
    public static boolean isPastDate(@NonNull String date) {
        return LocalDateTime.now().isAfter(LocalDateTime.parse(date));
    }

}
