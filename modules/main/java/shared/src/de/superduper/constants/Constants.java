package de.superduper.constants;

public class Constants {

    /**
     * File path to the csv file containing product data.
     */
    public static final String CSV_PRODUCTS_FILE_PATH = "modules/main/resources/products.csv";

    /**
     * File path to the config properties containing sql data.
     */
    public static final String SQL_CONFIG_PROPERTIES_FILE_PATH = "modules/main/resources/config.properties";

    /**
     * Number of how many days in the future for which the product information should be displayed
     */
    public static final int NUMBER_OF_DAYS_TO_PRINT_PRODUCT_INFO = 21;

    /**
     * Product type cheese
     */
    public static final String PRODUCT_TYPE_CHEESE = "käse";

    /**
     * Product type wine
     */
    public static final String PRODUCT_TYPE_WINE = "wein";

    /**
     * Product type bread
     */
    public static final String PRODUCT_TYPE_BREAD = "brot";

    /**
     * Pattern to format dates to strings
     */
    public static final String DESIRED_DATE_FORMAT_PATTERN = "dd.MM.yyyy";

    /**
     * The minimum quality level for bread products.
     */
    public static final int BREAD_MIN_QUALITY = 10;

    /**
     * The minimum quality level for cheese products.
     */
    public static final int CHEESE_MIN_QUALITY = 30;

    /**
     * The minimum quality value for wine.
     */
    public static final int WINE_MIN_QUALITY = 0;

    /**
     * The maximum quality value for wine.
     */
    public static final int WINE_MAX_QUALITY = 50;

    /**
     * The period after which the quality of wine increments.
     */
    public static final int WINE_QUALITY_INCREMENT_PERIOD = 10;

    /**
     * Query to select all products
     */
    public static final String SELECT_ALL_PRODUCTS = "SELECT * FROM products";

    /**
     * Error loading sql config file
     */
    public static final String ERROR_LOAD_SQL_CONFIG_FILE = "Failed to load database configuration file.";

    /**
     * Error parsing line
     */
    public static final String ERROR_PARSING_LINE = "Error parsing line: ";
}
