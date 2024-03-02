package de.superduper.productutils;

import de.superduper.bread.Bread;
import de.superduper.cheese.Cheese;
import de.superduper.constants.Constants;
import de.superduper.product.Product;
import de.superduper.wine.Wine;

import java.time.LocalDate;

/**
 * Utility class for handling project related operations.
 */
public class ProductUtils {

    /**
     * Creates a product instance based on the provided type, name, quality, expiry date, and base price.
     *
     * @param type       The type of the product.
     * @param name       The name of the product.
     * @param quality    The quality of the product.
     * @param expiryDate The expiry date of the product.
     * @param basePrice  The base price of the product.
     * @return The created Product instance, or null if the type is unknown.
     */
    public static Product createProductBasedOnType(String type, String name, int quality, LocalDate expiryDate, double basePrice) {
        Product product = null;

        switch (type.toLowerCase()) {
            case Constants.PRODUCT_TYPE_CHEESE:
                product = new Cheese(name, quality, expiryDate, basePrice);
                break;
            case Constants.PRODUCT_TYPE_WINE:
                product = new Wine(name, quality, expiryDate, basePrice);
                break;
            case Constants.PRODUCT_TYPE_BREAD:
                product = new Bread(name, quality, expiryDate, basePrice);
                break;
            default:
                // Handle unknown product types
                break;
        }

        return product;
    }
}
