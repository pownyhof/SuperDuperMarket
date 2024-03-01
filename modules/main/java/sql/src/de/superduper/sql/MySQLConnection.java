package de.superduper.sql;

import de.superduper.constants.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
Used design pattern:

Single Responsibility Principle:
fundamental concept in writing clean, maintainable, and scalable code.
This leads to improved re-usability, and testability.
 */

/**
 * Utility class for establishing a connection to a MySQL database using DriverManager.
 */
public class MySQLConnection {

    /**
     * Establishes a connection to a MySQL database using DriverManager.
     *
     * @param configFilePath The path to the configuration properties file.
     * @return A Connection object representing the database connection.
     * @throws SQLException If an SQL exception occurs while connecting to the database.
     */
    public static Connection getConnection(String configFilePath) throws SQLException {
        Properties properties = new Properties();

        try (FileInputStream inputStream = new FileInputStream(configFilePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            // should be replaced with a logger
            e.printStackTrace();
            throw new SQLException(Constants.ERROR_LOAD_SQL_CONFIG_FILE);
        }

        // gets properties from config.properties
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}

