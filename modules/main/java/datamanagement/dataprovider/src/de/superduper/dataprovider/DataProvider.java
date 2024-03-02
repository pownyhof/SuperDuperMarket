package de.superduper.dataprovider;

import de.superduper.constants.Constants;
import de.superduper.csvreader.CSVReader;
import de.superduper.product.Product;
import de.superduper.productmanager.ProductManager;

import java.io.IOException;
import java.util.List;

/*
Used design pattern:

Single Responsibility Principle:
fundamental concept in writing clean, maintainable, and scalable code.
This leads to improved re-usability, and testability.
 */

/**
 * Class to handle different sources for the product data
 */
public class DataProvider {

    /**
     * Populates the product list in the provided ProductManager with product data from a data source, in this case a csv file.
     *
     * @param productManager The ProductManager instance to populate with product data.
     * @throws IOException If an I/O exception occurs while reading the CSV file.
     */
    public static void populateProductList(ProductManager productManager) throws IOException {
        List<Product> products;

        // add products from the csv file from the resources folder
        products = CSVReader.getProductsFromCSV(Constants.CSV_PRODUCTS_FILE_PATH);

        for (Product product : products) {
            productManager.addProduct(product);
        }

        /*
         could also add more products here with a working MySQL database, for example:
         Connection connection = MySQLConnection.getConnection(Constants.SQL_CONFIG_PROPERTIES_FILE_PATH);
         ProductDAO.getProductsFromDataBase(connection);
        */
    }

}
