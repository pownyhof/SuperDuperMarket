package de.superduper.csvreader;

import de.superduper.constants.Constants;
import de.superduper.productmanagement.ProductManager;
import de.superduper.utils.DataUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/*
Used design pattern:

Single Responsibility Principle:
fundamental concept in writing clean, maintainable, and scalable code.
This leads to improved re-usability, and testability.
 */

/**
 * Class to load product data from a given csv fle
 */
public class CSVReader {

    /**
     * Reads product data from a csv file and adds the products to the productManager instance.
     *
     * @param filename The path to the CSV file containing the product data.
     * @throws IOException If an I/O exception occurs while reading the CSV file.
     */
    public static void addProductsFromCSV(String filename) throws IOException {
        ProductManager productManager = ProductManager.getInstance();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // skip the header line
            br.readLine();

            String line;
            // go through all lines
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                try {
                    String type = data[0].trim().toLowerCase();
                    String name = DataUtils.capitalizeFirstLetter(data[1].trim());
                    int quality = Integer.parseInt(data[2].trim());
                    LocalDate expiryDate = DataUtils.parseDate(data[3].trim());
                    double basePrice = Double.parseDouble(data[4].trim());

                    productManager.addProduct(type, name, quality, expiryDate, basePrice);
                } catch (NumberFormatException | DateTimeParseException e) {
                    // Log error for invalid data format
                    System.err.println(Constants.ERROR_PARSING_LINE + line);
                }
            }
        }
    }
}
