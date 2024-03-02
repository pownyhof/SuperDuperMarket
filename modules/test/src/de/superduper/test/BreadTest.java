package de.superduper.test;

import de.superduper.bread.Bread;

import java.time.LocalDate;

/**
 * Class to test bread class
 */
public class BreadTest {
    private static final LocalDate now = LocalDate.now();
    private static final LocalDate dateInThePast = LocalDate.now().minusDays(3);
    private static final LocalDate dateInTheFuture = LocalDate.now().plusDays(2);

    /**
     * Test calculateDailyPrice: about to expire so price is halved
     */
    public static boolean testCalculateDailyPrice() {
        Bread bread = new Bread("Roggenmischbrot", 5, dateInTheFuture, 2);
        return bread.calculateDailyPrice(now) == 1;
    }

    /**
     * Test needsDisposal: quality below minimum
     */
    public static boolean testNeedsDisposal() {
        Bread bread = new Bread("Roggenmischbrot", 2, dateInTheFuture, 2.5);
        return bread.needsDisposal(now);
    }

    /**
     * Test needsDisposal: quality above minimum, not expired
     */
    public static boolean test2NeedsDisposal() {
        Bread bread = new Bread("Roggenmischbrot", 20, dateInTheFuture, 2.0);
        return !bread.needsDisposal(now);
    }

    /**
     * Test needsDisposal: expired
     */
    public static boolean test3NeedsDisposal() {
        Bread bread = new Bread("Roggenmischbrot", 20, dateInThePast, 2.0);
        return bread.needsDisposal(now);
    }

    /**
     * Test updateQuality: decrease quality by 1
     */
    public static boolean testUpdateQuality() {
        Bread bread = new Bread("Roggenmischbrot", 4, now, 2.5);
        bread.updateQuality();
        return bread.getQuality() == 3;
    }
}
