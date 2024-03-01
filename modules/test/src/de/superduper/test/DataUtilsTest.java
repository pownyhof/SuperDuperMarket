package de.superduper.test;

import de.superduper.utils.DataUtils;

import java.time.LocalDate;

/**
 * Class to test data utils
 */
public class DataUtilsTest {

    public static boolean testFormatDate() {
        LocalDate date = LocalDate.of(2020, 1, 8);
        String result = DataUtils.formatDate(date, "dd.MM.yyyy");
        return result.equals("08.01.2020");
    }

    public static boolean testCapitalizeFirstLetter() {
        String result = DataUtils.capitalizeFirstLetter("test");
        return result.equals("Test");
    }

    public static boolean testParseDate() {
        LocalDate date = LocalDate.of(2020, 1, 8);
        LocalDate result = DataUtils.parseDate("08.01.2020");
        assert result != null;
        return result.equals(date);
    }

    public static boolean testParseDateInvalidInput() {
        LocalDate result = DataUtils.parseDate("invalid_date");
        return result == null;
    }
}
