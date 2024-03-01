package de.superduper.products;

import de.superduper.constants.Constants;
import de.superduper.productmanagement.Product;

import java.time.LocalDate;

/**
 * A class representing Wine product.
 * Extends the Product class and provides specific implementations for Wine products.
 */
public class Wine extends Product {

    /**
     * The number of days passed.
     */
    private int daysPassed = 0;

    /**
     * Constructor for creating a Wine object.
     */
    public Wine(String name, int quality, LocalDate expiryDate, double basePrice) {
        super(name, quality, expiryDate, basePrice);
    }

    /**
     * Returns the basePrice because wine does not change its price
     */
    @Override
    public double calculateDailyPrice(LocalDate currentDate) {
        return getBasePrice();
    }

    /**
     * Checks if the wine needs disposal, only needs disposal if the quality is below 0
     */
    @Override
    public boolean needsDisposal(LocalDate currentDate) {
        return getQuality() < Constants.WINE_MIN_QUALITY;
    }

    /**
     * Updates the quality by 1 after 10 days have passed and the quality is below the maximum.
     */
    @Override
    public void updateQuality() {
        daysPassed++;
        if (daysPassed % Constants.WINE_QUALITY_INCREMENT_PERIOD == 0 && getQuality() < Constants.WINE_MAX_QUALITY) {
            quality++;
        }
    }
}

