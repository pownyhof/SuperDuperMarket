package de.superduper.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for handling data operations.
 */
public class DataUtils {

    /**
     * Parses a date string using multiple date patterns.
     *
     * @param dateString The date string to parse.
     * @return The parsed LocalDate or null if parsing fails.
     */
    public static LocalDate parseDate(String dateString) {
        // accept multiple date patterns
        List<String> patterns = new ArrayList<>();
        patterns.add("dd.MM.yyyy");
        patterns.add("MM.dd.yyyy");
        patterns.add("dd/MM/yyyy");
        patterns.add("MM/dd/yyyy");
        patterns.add("yyyy-MM-dd");

        // attempt parsing with each pattern
        for (String pattern : patterns) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                return LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                // continue to the next pattern if parsing fails
            }
        }

        // return null if the date string cannot be parsed with any of the patterns
        return null;
    }

    /**
     * Parses a date to a string
     *
     * @param date The date to parse.
     * @param pattern The string pattern for the formatter
     * @return The parsed string
     */
    public static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * Capitalizes the first letter of a string.
     *
     * @param str The input string.
     * @return The input string with the first letter capitalized.
     */
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
