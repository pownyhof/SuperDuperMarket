package de.superduper.products;

import de.superduper.constants.Constants;
import de.superduper.productmanagement.Product;

import java.time.LocalDate;

/**
 * A class representing Bread product.
 * Extends the Product class and provides specific implementations for Bread products.
 */
public class Bread extends Product {

    /**
     * Constructor for creating a Bread product.
     */
    public Bread(String name, int quality, LocalDate expiryDate, double basePrice) {
        super(name, quality, expiryDate, basePrice);
    }

    /**
     * Calculates the daily price of the Bread.
     * The price of Bread gets halved if it is about to expire in the next 3 days.
     */
    @Override
    public double calculateDailyPrice(LocalDate currentDate) {
        return currentDate.plusDays(3).isAfter(getExpiryDate()) ? getBasePrice() * 0.5 : getBasePrice();
    }

    /**
     * Checks if the Bread needs disposal based on the current date.
     * Bread needs disposal if its quality is below the minimum level or if it has expired.
     */
    @Override
    public boolean needsDisposal(LocalDate currentDate) {
        return getQuality() < Constants.BREAD_MIN_QUALITY || currentDate.isAfter(getExpiryDate());
    }

    /**
     * Reduces the quality of the Bread by 1.
     */
    @Override
    public void updateQuality() {
        quality--;
    }
}

