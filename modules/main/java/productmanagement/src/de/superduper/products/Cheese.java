package de.superduper.products;

import de.superduper.constants.Constants;
import de.superduper.productmanagement.Product;

import java.time.LocalDate;

/**
 * A class representing Cheese product.
 * Extends the Product class and provides specific implementations for Cheese products.
 */
public class Cheese extends Product {

    /**
     * Constructor for creating a Cheese product.
     */
    public Cheese(String name, int quality, LocalDate expiryDate, double basePrice) {
        super(name, quality, expiryDate, basePrice);
    }

    /**
     * Calculates the daily price of the Cheese.
     */
    @Override
    public double calculateDailyPrice(LocalDate currentDate) {
        return getBasePrice() + 0.10 * getQuality();
    }

    /**
     * Checks if the Cheese needs disposal based on the current date.
     * Cheese needs disposal if its quality is below the minimum level or if it has expired.
     */
    @Override
    public boolean needsDisposal(LocalDate currentDate) {
        return getQuality() < Constants.CHEESE_MIN_QUALITY || currentDate.isAfter(getExpiryDate());
    }

    /**
     * Reduces the quality by 1.
     */
    @Override
    public void updateQuality() {
        quality--;
    }
}

