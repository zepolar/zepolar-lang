package com.linbrox.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public final class DateUtils {

    private static final Random random = new Random();

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
    public static boolean isFutureDate(Date date) {
        Objects.requireNonNull(date, "Date cannot be null");
        return LocalDate.now().isBefore(date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
    }

    /**
     * Checks if the given LocalDateTime is in the future.
     *
     * @param date the LocalDateTime to be checked
     * @return {@code true} if the given LocalDateTime is in the future, {@code false} otherwise
     * @throws NullPointerException if the date is null
     *                              <p>
     *                              Example usage:
     *                              <pre>
     *                                                             LocalDateTime futureDateTime = LocalDateTime.now().plusDays(1); // 1 day in the future
     *                                                             boolean isFuture = DateUtils.isFutureDate(futureDateTime);
     *                                                             System.out.println(isFuture); // Should print true if executed immediately
     *                                                           </pre>
     */
    public static boolean isFutureDate(LocalDateTime date) {
        Objects.requireNonNull(date, "Date cannot be null");
        return LocalDate.now().isBefore(date.toLocalDate());
    }

    /**
     * Checks if the given date string is in the future.
     *
     * @param date the date string to be checked in ISO_LOCAL_DATE_TIME format (e.g., "2023-10-12T07:20:50")
     * @return {@code true} if the given date string is in the future, {@code false} otherwise
     * @throws NullPointerException   if the date string is null
     * @throws DateTimeParseException if the date string cannot be parsed
     *                                <p>
     *                                Example usage:
     *                                <pre>
     *                                                                 String futureDate = "2025-01-01T00:00:00";
     *                                                                 boolean isFuture = DateUtils.isFutureDate(futureDate);
     *                                                                 System.out.println(isFuture); // Should print true if the current date is before 2025-01-01
     *                                                               </pre>
     */
    public static boolean isFutureDate(String date) {
        Objects.requireNonNull(date, "Date cannot be null");
        return LocalDate.now().isBefore(LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME).toLocalDate());
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
    public static boolean isPastDate(String date) {
        Objects.requireNonNull(date, "Date cannot be null");
        LocalDateTime dated = LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return LocalDateTime.now().isAfter(dated);
    }

    /**
     * Checks if the given LocalDateTime is in the past.
     *
     * @param date the LocalDateTime to be checked
     * @return {@code true} if the given LocalDateTime is in the past, {@code false} otherwise
     * @throws NullPointerException if the date is null
     *
     *                              <p>
     *                              Example usage:
     *                              <pre>
     *                                  LocalDateTime pastDateTime = LocalDateTime.now().minusDays(1); // 1 day in the past
     *                                  boolean isPast = DateUtils.isPastDate(pastDateTime);
     *                                  System.out.println(isPast); // Should print true if executed immediately
     *                              </pre>
     */
    public static boolean isPastDate(LocalDateTime date) {
        Objects.requireNonNull(date, "Date cannot be null");
        return LocalDateTime.now().isAfter(date);
    }

    /**
     * Checks if the given date is in the past.
     *
     * @param date the date to be checked
     * @return {@code true} if the given date is in the past, {@code false} otherwise
     * @throws NullPointerException if the date is null
     *
     *                              <p>
     *                              Example usage:
     *                              <pre>
     *                                Date pastDate = new Date(System.currentTimeMillis() - 10000); // 10 sec in the past
     *                                boolean isPast = DateUtils.isPastDate(pastDate);
     *                                System.out.println(isPast); // Should print true if executed immediately
     *                              </pre>
     */
    public static boolean isPastDate(Date date) {
        Objects.requireNonNull(date, "Date cannot be null");
        return LocalDateTime.now().isAfter(date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
    }


    /**
     * Checks if the given date is today.
     *
     * @param date the date to be checked
     * @return {@code true} if the given date is today, {@code false} otherwise
     * @throws NullPointerException if the date is null
     *                              <p>
     *                              Example usage:
     *                              <pre>
     *                                                             Date todayDate = new Date();
     *                                                             boolean isToday = DateUtils.isToday(todayDate);
     *                                                             System.out.println(isToday); // Should print true if the date is today
     *                                                           </pre>
     */
    public static boolean isToday(Date date) {
        return LocalDate.now().equals(date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
    }

    /**
     * Returns the date of tomorrow.
     *
     * @return the LocalDate representing tomorrow
     * <p>
     * Example usage:
     * <pre>
     *     LocalDate tomorrowDate = DateUtils.tomorrow();
     *     System.out.println(tomorrowDate); // Should print tomorrow's date
     * </pre>
     */
    public static LocalDate tomorrow() {
        return LocalDate.now().plusDays(1);
    }

    /**
     * Returns the date of yesterday.
     *
     * @return the LocalDate representing yesterday
     * <p>
     * Example usage:
     * <pre>
     *     LocalDate yesterdayDate = DateUtils.yesterday();
     *     System.out.println(yesterdayDate); // Should print yesterday's date
     * </pre>
     */
    public static LocalDate yesterday() {
        return LocalDate.now().minusDays(1);
    }


    public static LocalDateTime randomDate() {
        long minDay = LocalDate.of(1900, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2100, 12, 31).toEpochDay();
        long randomDay = minDay + (random.nextLong() * (maxDay - minDay));
        return LocalDate.ofEpochDay(randomDay).atStartOfDay().plusSeconds(random.nextLong() * 86400);
    }

    public static LocalDateTime randomFutureDate() {
        long minDay = LocalDate.now().toEpochDay();
        long maxDay = LocalDate.now().plusYears(100).toEpochDay();
        long randomDay = minDay + (random.nextLong() * (maxDay - minDay));
        return LocalDate.ofEpochDay(randomDay).atStartOfDay().plusSeconds(random.nextLong() * 86400);
    }

    public static LocalDateTime randomPastDate() {
        long minDay = LocalDate.of(1900, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = minDay + (random.nextLong() * (maxDay - minDay));
        return LocalDate.ofEpochDay(randomDay).atStartOfDay().plusSeconds(random.nextLong() * 86400);
    }

    public static boolean isDateBetween(Date date, Date startDate, Date endDate) {
        Objects.requireNonNull(date, "Date cannot be null");
        Objects.requireNonNull(startDate, "Start date cannot be null");
        Objects.requireNonNull(endDate, "End date cannot be null");
        return date.after(startDate) && date.before(endDate);
    }

    public static Date addWeeks(Date date, int weeks) {
        Objects.requireNonNull(date, "Date cannot be null");
        return new Date(date.getTime() + (long) weeks * 7 * 24 * 60 * 60 * 1000);
    }

    public static Date addDays(Date date, int days) {
        Objects.requireNonNull(date, "Date cannot be null");
        return new Date(date.getTime() + (long) days * 24 * 60 * 60 * 1000);
    }
}
