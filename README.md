# API Module

This module contains the API tests for the Swagger application.

Running Tests with Gradle, JUnit 5, Java 17, and Generating Allure Report

Requirements

- Java 17
- Gradle (recommended version 6.8 or higher)
- Allure (recommended version 2.13.8 or higher)
- JUnit 5
 
## Steps to Run Tests and Generate Report

### 1 Running Tests

To run the tests, execute the following command:
    
```bash
./gradlew test
```

### 2 Generating Allure Report

After successfully running the tests, generate the Allure report with the following command:

```bash
./gradlew allureReport
```
The report will be generated in the build/reports/allure-report directory.

### 3 Viewing Allure Report

To open the report in a browser, run the command:

```bash
./gradlew allureServe
```
The report will then be available at http://localhost:[port].

Useful Commands

```bash
# Clean previous results and run tests.
./gradlew clean test

# Generate the Allure report.
./gradlew allureReport

# Open the Allure report in a browser.
./gradlew allureServe
```

### Additional Information

For more detailed configuration and usage of Allure, refer to the official Allure documentation.