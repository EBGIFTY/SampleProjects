# NHSBSA Job Search Automation Suite

## Overview
This project automates testing of the NHS Jobs search functionality, specifically for the **NHS Business Services Authority (NHSBSA)** portal. The primary goal is to ensure the reliability and accuracy of the job search features, providing quick feedback on new deployments and changes.

This project automated testing using:
- Java 17 for robust test logic.
- Selenium WebDriver for browser automation.
- Cucumber (BDD) for defining test scenarios in a human-readable format.
- ExtentReports and Cucumber reports for comprehensive and visual test reporting.

The test validates key user flows, ensuring users can:
- Enter search preferences (keywords, location) correctly.
- Receive accurate matching job results.
- See results consistently sorted by the newest Date Posted.

## How to Run Tests

### 🔧 Prerequisites

- Java JDK 17 or 21

- Maven installed and added to PATH

- Chrome or Firefox browser installed



### 🚀 Run From Command Line

Open terminal in the root directory and run:

```bash

mvn clean test



