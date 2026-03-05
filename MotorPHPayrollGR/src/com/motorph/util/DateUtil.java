package com.motorph.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Date utility helpers using Manila (Asia/Manila) timezone.
 */
public class DateUtil {

    public static final ZoneId MANILA_ZONE = ZoneId.of("Asia/Manila");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

    private DateUtil() {
        // utility class
    }

    /**
     * Returns the current date in Manila timezone.
     */
    public static LocalDate todayManila() {
        return LocalDateTime.now(MANILA_ZONE).toLocalDate();
    }

    /**
     * Formats a LocalDate using the standard MotorPH date pattern (MM/dd/yyyy).
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return "";
        }
        return date.format(DATE_FORMATTER);
    }

    /**
     * Parses a date string in MM/dd/yyyy format.
     */
    public static LocalDate parse(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }
        return LocalDate.parse(dateStr.trim(), DATE_FORMATTER);
    }
}
