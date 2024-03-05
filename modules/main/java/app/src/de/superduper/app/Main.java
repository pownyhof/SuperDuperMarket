package de.superduper.app;

import de.superduper.constants.Constants;
import de.superduper.dataprovider.DataProvider;
import de.superduper.productmanager.ProductManager;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Main application class for managing products in SuperDuperMarket.
 */
public class Main {

    /**
     * Reads product data and prints the product information for a specified number of days.
     */
    public static void main(String[] args) throws IOException {
        ProductManager productManager = new ProductManager();

        DataProvider.populateProductList(productManager);

        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(Constants.NUMBER_OF_DAYS_TO_PRINT_PRODUCT_INFO);

        // print all products once with their starting values
        productManager.printProducts();

        while (!currentDate.isAfter(endDate)) {
            // print all products depending on given date
            productManager.printProductInfoForADate(currentDate);
            // update all products for example the quality for the next day
            productManager.updateProducts(currentDate);
            // increment the days by 1
            currentDate = currentDate.plusDays(1);
        }
    }
}
