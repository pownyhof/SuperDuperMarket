package de.superduper.productmanager;

import de.superduper.constants.Constants;
import de.superduper.product.Product;
import de.superduper.utils.DataUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Used design pattern:

Single Responsibility Principle:
fundamental concept in writing clean, maintainable, and scalable code.
This leads to improved re-usability, and testability.
 */

/**
 * Class to manage all products, f.e. add, update or print products
 */
public class ProductManager {

    /**
     * List of all products
     */
    private final List<Product> products = new ArrayList<>();


    /**
     * Adds a product to the product list
     *
     * @param product the product to add
     */
    public void addProduct(Product product) {
        products.add(product);
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
