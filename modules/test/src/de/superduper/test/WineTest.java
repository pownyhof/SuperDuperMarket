package de.superduper.test;

import de.superduper.wine.Wine;

import java.time.LocalDate;

/**
 * Class to test wine class
 */
public class WineTest {
    private static final LocalDate now = LocalDate.now();
    private static final LocalDate dateInTheFuture = LocalDate.now().plusDays(2);

    /**
     * Test calculateDailyPrice: price always stays the same
     */
    public static boolean testCalculateDailyPrice() {
        Wine wine = new Wine("Riesling", 5, dateInTheFuture, 2);
        return wine.calculateDailyPrice(now) == 2;
    }

    /**
     * Test needsDisposal: quality below minimum
     */
    public static boolean testNeedsDisposal() {
        Wine wine = new Wine("Riesling", -2, dateInTheFuture, 2);
        return wine.needsDisposal(now);
    }

    /**
     * Test needsDisposal: quality above minimum, can't expire
     */
    public static boolean test2NeedsDisposal() {
        Wine wine = new Wine("Riesling", 20, dateInTheFuture, 2);
        return !wine.needsDisposal(now);
    }

    /**
     * Test updateQuality: quality remains unchanged
     */
    public static boolean testUpdateQuality() {
        Wine wine = new Wine("Riesling", 4, now, 2);
        wine.updateQuality();
        return wine.getQuality() == 4;
    }
}
