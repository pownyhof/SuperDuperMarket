package de.superduper.productmanagement;

import de.superduper.products.Bread;
import de.superduper.products.Cheese;
import de.superduper.products.Wine;
import de.superduper.constants.Constants;
import de.superduper.utils.DataUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Used design patterns:

Factory Method Pattern:
The addProduct method acts as a factory method,
creating different types of products based on the provided type parameter.
It encapsulates the object creation logic and
decouples the client code from the specific product implementations (Cheese, Wine, Bread).

Singleton Pattern:
ensures only a single instance of a class exists throughout an application and
provides access to that instance from anywhere in the codebase.
 */

/**
 * Class to manage all products, f.e. add, update or print products
 */
public class ProductManager {

    /**
     * Product manager instance
     */
    private static ProductManager instance;

    /**
     * List of all products
     */
    private final List<Product> products = new ArrayList<>();

    /**
     * Private constructor to prevent instantiation from outside
     */
    private ProductManager() { }

    /**
     * Get product manager instance
     */
    public static ProductManager getInstance() {
        if (instance == null) {
            synchronized (ProductManager.class) {
                if (instance == null) {
                    instance = new ProductManager();
                }
            }
        }
        return instance;
    }

    /**
     * Adds a product to the product list based on the provided type, name, quality, expiry date and base price.
     *
     * @param type           The type of the product.
     * @param name           The name of the product.
     * @param quality        The quality of the product.
     * @param expiryDate     The expiry date of the product.
     * @param basePrice      The base price of the product.
     */
    public void addProduct(String type, String name, int quality, LocalDate expiryDate, double basePrice) {
        switch (type.toLowerCase()) {
            case Constants.PRODUCT_TYPE_CHEESE:
                products.add(new Cheese(name, quality, expiryDate, basePrice));
                break;
            case Constants.PRODUCT_TYPE_WINE:
                products.add(new Wine(name, quality, expiryDate, basePrice));
                break;
            case Constants.PRODUCT_TYPE_BREAD:
                products.add(new Bread(name, quality, expiryDate, basePrice));
                break;
            default:
                // Handle unknown product types
                break;
        }
    }

    /**
     * Updates all products for a give date, updates quality and daily price
     *
     * @param currentDate the given date for which the price should be calculated
     */
    public void updateProducts(LocalDate currentDate) {
        for (Product product : products) {
            product.updateQuality();
            product.calculateDailyPrice(currentDate);
        }
    }


    /**
     * Prints an overview of all products with their starting values
     */
    public void printProducts() {
        System.out.println("Übersicht aller Produkte: ");

        for (Product product : products) {
            String expiryDate = product.getExpiryDate() != null ? DataUtils.formatDate(product.getExpiryDate(), Constants.DESIRED_DATE_FORMAT_PATTERN) : null;

            System.out.println(
                    "Produkt: " + DataUtils.capitalizeFirstLetter(product.getName()) +
                    " | Preis: " + String.format("%.2f", product.getBasePrice()) +
                    " | Qualität: " + product.getQuality() +
                    " | Ablaufdatum: " + expiryDate
            );
        }
    }

    /**
     * Prints an overview of all products for a given day
     *
     * @param currentDate the given date for which overview should be displayed
     */
    public void printProductInfoForADate(LocalDate currentDate) {
        System.out.println("--------------------------------------------------------");
        System.out.println("Übersicht für den " + DataUtils.formatDate(currentDate, Constants.DESIRED_DATE_FORMAT_PATTERN) + ":");
        for (Product product : products) {
            System.out.println(
                    "Produkt: " + DataUtils.capitalizeFirstLetter(product.getName()) +
                    " | Preis: " + String.format("%.2f", Math.round(product.calculateDailyPrice(currentDate) * 100.0) / 100.0) +
                    " | Qualität: " + product.getQuality() +
                    " | Entsorgung erforderlich: " + (product.needsDisposal(currentDate) ? "Ja" : "Nein")
            );
        }
    }
}
