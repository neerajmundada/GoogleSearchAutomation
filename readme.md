# Google Search Automation Framework

## Overview

This framework is designed for automating functional, performance, and security tests for the Google search functionality. It is based on Selenium WebDriver for browser automation, TestNG for test execution and reporting, and Maven for project management. The tests cover common scenarios like searching a keyword, checking performance load times, and preventing security vulnerabilities such as XSS attacks.

### Key Features:
- **Test Types:** Functional, Performance, and Security Tests.
- **Parallel Execution:** The framework runs multiple tests concurrently, improving the test execution time.
- **Listeners:** Custom listeners capture test events, such as failures, and generate reports with screenshots.
- **TestNG XML Configuration:** Configured through `testng.xml` for test suite management and parallel execution.

## How to Set Up

### 1. Install JDK 11
Ensure you have JDK 11 installed on your machine.

### 2. Install Maven
Make sure you have Maven installed.

### 3. Open Project in IDE
You can open the project in your preferred IDE (e.g., IntelliJ IDEA).

### 4. Build the Project with Maven:
Once the project is set up, run the following Maven command to build the project:

```bash
mvn clean install
```
### 5. Run Tests with TestNG:
You can run the tests by executing the following command:

```bash
mvn test
mvn test -Dtest=FunctionalTests
mvn test -Dtest=PerformanceTests
mvn test -Dtest=SecurityTests
```

### 6. The tests are defined in testng.xml, where you can configure the test suite and specify test execution parameters such as parallel execution.

### 7. Html report will be generated post execution under 

```bash
target/surefire-reports/index.html
```

This is a very basic reporting I used, for better reporting we can use third party libraries like Allure, Extent reports etc
