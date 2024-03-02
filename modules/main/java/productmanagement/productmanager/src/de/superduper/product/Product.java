package de.superduper.product;

import java.time.LocalDate;

/*
Used design pattern:

Template Method Pattern:
Code reuse happens with the Template Method pattern as it uses inheritance and not composition. Only a few methods need to be overridden.
Flexibility lets subclasses decide how to implement steps in an algorithm.
 */

/**
 * Abstract class representing a product.
 * Provides common properties and behaviors for different types of products.
 */
public abstract class Product {

    /**
     * Name of the product
     */
    private final String name;

    /**
     * Quality of the product
     */
    protected int quality;

    /**
     * Expiry date of the product
     */
    private final LocalDate expiryDate;

    /**
     * Base price of the product
     */
    private final double basePrice;

    /**
     * Constructor for creating a product instance.
     */
    public Product(String name, int quality, LocalDate expiryDate, double basePrice) {
        this.name = name;
        this.quality = quality;
        this.expiryDate = expiryDate;
        this.basePrice = basePrice;
    }

    /**
     * Calculates the daily price of the product based on current date.
     */
    public abstract double calculateDailyPrice(LocalDate currentDate);

    /**
     * Checks if the product needs disposal based on current date.
     */
    public abstract boolean needsDisposal(LocalDate currentDate);

    /**
     * Abstract method to update the quality of the product.
     */
    public abstract void updateQuality();

    /**
     * Gets the name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the quality of the product.
     */
    public int getQuality() {
        return quality;
    }

    /**
     * Gets the expiry date of the product.
     */
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    /**
     * Gets the base price of the product.
     */
    public double getBasePrice() {
        return basePrice;
    }
}

