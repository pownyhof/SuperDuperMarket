package de.superduper.test;

/**
 * Main Class to run tests, would be better to use a testing framework like JUnit for example
 */
public class Main {
    public static void main(String[] args) {
        runTests();
    }

    /**
     * Main function to run tests
     */
    public static void runTests() {
        int passedTests = 0;
        int totalTests = 0;

        // Test formatDate method
        totalTests++;
        if (DataUtilsTest.testFormatDate()) {
            passedTests++;
        } else {
            System.out.println("DataUtils testFormatDate failed.");
        }

        // Test capitalizeFirstLetter method
        totalTests++;
        if (DataUtilsTest.testCapitalizeFirstLetter()) {
            passedTests++;
        } else {
            System.out.println("DataUtils testCapitalizeFirstLetter failed.");
        }

        // Tests parseDate method
        totalTests++;
        if (DataUtilsTest.testParseDate()) {
            passedTests++;
        } else {
            System.out.println("DataUtils testParseDate failed.");
        }

        totalTests++;
        if (DataUtilsTest.testParseDateInvalidInput()) {
            passedTests++;
        } else {
            System.out.println("DataUtils testParseDateInvalidInput failed.");
        }

        totalTests++;
        if (BreadTest.testCalculateDailyPrice()) {
            passedTests++;
        } else {
            System.out.println("Bread testCalculateDailyPrice failed.");
        }

        totalTests++;
        if (BreadTest.testNeedsDisposal()) {
            passedTests++;
        } else {
            System.out.println("Bread testNeedsDisposal failed.");
        }

        totalTests++;
        if (BreadTest.test2NeedsDisposal()) {
            passedTests++;
        } else {
            System.out.println("Bread test2NeedsDisposal failed.");
        }

        totalTests++;
        if (BreadTest.test3NeedsDisposal()) {
            passedTests++;
        } else {
            System.out.println("Bread test3NeedsDisposal failed.");
        }

        totalTests++;
        if (BreadTest.testUpdateQuality()) {
            passedTests++;
        } else {
            System.out.println("Bread testUpdateQuality failed.");
        }

        totalTests++;
        if (CheeseTest.testCalculateDailyPrice()) {
            passedTests++;
        } else {
            System.out.println("Cheese testCalculateDailyPrice failed.");
        }

        totalTests++;
        if (CheeseTest.testNeedsDisposal()) {
            passedTests++;
        } else {
            System.out.println("Cheese testNeedsDisposal failed.");
        }

        totalTests++;
        if (CheeseTest.test2NeedsDisposal()) {
            passedTests++;
        } else {
            System.out.println("Cheese test2NeedsDisposal failed.");
        }

        totalTests++;
        if (CheeseTest.test3NeedsDisposal()) {
            passedTests++;
        } else {
            System.out.println("Cheese test3NeedsDisposal failed.");
        }

        totalTests++;
        if (CheeseTest.testUpdateQuality()) {
            passedTests++;
        } else {
            System.out.println("Cheese testUpdateQuality failed.");
        }

        totalTests++;
        if (WineTest.testCalculateDailyPrice()) {
            passedTests++;
        } else {
            System.out.println("Wine testCalculateDailyPrice failed.");
        }

        totalTests++;
        if (WineTest.testNeedsDisposal()) {
            passedTests++;
        } else {
            System.out.println("Wine testNeedsDisposal failed.");
        }

        totalTests++;
        if (WineTest.test2NeedsDisposal()) {
            passedTests++;
        } else {
            System.out.println("Wine test2NeedsDisposal failed.");
        }

        totalTests++;
        if (WineTest.testUpdateQuality()) {
            passedTests++;
        } else {
            System.out.println("Wine testUpdateQuality failed.");
        }


        // Print summary
        System.out.println("Passed " + passedTests + " out of " + totalTests + " tests.");
    }
}
