package de.superduper.test;

import de.superduper.cheese.Cheese;

import java.time.LocalDate;

/**
 * Class to test cheese class
 */
public class CheeseTest {
    private static final LocalDate now = LocalDate.now();
    private static final LocalDate dateInThePast = LocalDate.now().minusDays(3);
    private static final LocalDate dateInTheFuture = LocalDate.now().plusDays(2);

    /**
     * Test calculateDailyPrice: price + 0,1 * quality
     */
    public static boolean testCalculateDailyPrice() {
        Cheese cheese = new Cheese("Emmentaler", 10, dateInTheFuture, 2);
        return cheese.calculateDailyPrice(now) == 3;
    }

    /**
     * Test needsDisposal: quality below minimum
     */
    public static boolean testNeedsDisposal() {
        Cheese cheese = new Cheese("Emmentaler", 2, dateInTheFuture, 2.5);
        return cheese.needsDisposal(now);
    }

    /**
     * Test needsDisposal: quality above minimum, not expired
     */
    public static boolean test2NeedsDisposal() {
        Cheese cheese = new Cheese("Emmentaler", 50, dateInTheFuture, 2.0);
        return !cheese.needsDisposal(now);
    }

    /**
     * Test needsDisposal: expired
     */
    public static boolean test3NeedsDisposal() {
        Cheese cheese = new Cheese("Emmentaler", 50, dateInThePast, 2.0);
        return cheese.needsDisposal(now);
    }

    /**
     * Test updateQuality: decrease quality by 1
     */
    public static boolean testUpdateQuality() {
        Cheese cheese = new Cheese("Emmentaler", 5, LocalDate.of(2024, 3, 15), 2.5);
        cheese.updateQuality();
        return cheese.getQuality() == 4;
    }
}
