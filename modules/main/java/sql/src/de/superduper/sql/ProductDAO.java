package de.superduper.sql;

import de.superduper.utils.DataUtils;
import de.superduper.constants.Constants;
import de.superduper.productmanagement.ProductManager;

import java.sql.*;
import java.time.LocalDate;

/*
Used design pattern:

Single Responsibility Principle:
fundamental concept in writing clean, maintainable, and scalable code.
This leads to improved re-usability, and testability.
 */


/**
 * Data Access Object (DAO) class for retrieving products from a database.
 */
public class ProductDAO {

    /**
     * Retrieves all products from the database.
     *
     * @param connection the connection to the database
     * @throws SQLException if an SQL exception occurs while accessing the database
     */
    public void addProductsFromDataBase(Connection connection) throws SQLException {
        ProductManager productManager = ProductManager.getInstance();

        try (
                // Create a statement for executing SQL queries
                Statement statement = connection.createStatement();
                // Execute the SQL query to select all products from the database and get the result set
                ResultSet resultSet = statement.executeQuery(Constants.SELECT_ALL_PRODUCTS)
        ) {
            // Iterate over the result set to retrieve product information
            while (resultSet.next()) {
                String type = resultSet.getString("type").toLowerCase();
                String name = DataUtils.capitalizeFirstLetter(resultSet.getString("name"));
                int quality = resultSet.getInt("quality");
                LocalDate expiryDate = resultSet.getDate("expiry_date").toLocalDate();
                double basePrice = resultSet.getDouble("base_price");

                productManager.addProduct(type, name, quality, expiryDate, basePrice);
            }
        }
    }
}
