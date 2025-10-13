 NopCommerce Automation Testing Framework

## Overview
This project focuses on automating the core functionalities of the [NopCommerce](https://demo.nopcommerce.com/) web application using Selenium WebDriver, Java, and TestNG.  
The main goal was to create a data-driven, reusable, and maintainable automation framework following the Page Object Model (POM) design pattern.

---

## Features

### Automated Test Scenarios
- User Registration and Login  
- Product Search and Add to Cart  
- Checkout Process (Shipping and Payment)  
- Add Products to Wishlist and Compare List  
- Newsletter Subscription  

### Data-Driven Testing (DDT)
Implemented five different data sources for flexibility and scalability:
1. Excel File (`Products.xlsx`)
2. CSV File (`Products.csv`)
3. JSON File (`Products.json`)

---

## Framework Highlights
- Page Object Model (POM): Improves reusability and reduces code duplication  
- Centralized Test Data: All data handled from external files for dynamic testing  
- Utility Classes: Handle browser setup, waits, reporting, and validation  
- Maven Integration: Simplifies dependency and build management  
- TestNG: Provides parallel execution, grouping, and reporting features  

---

## Tech Stack
| Category | Tools |
|-----------|-------|
| Language | Java |
| Automation Tool | Selenium WebDriver |
| Test Framework | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model (POM) |
| Data Sources | Excel, CSV, JSON, Properties |

---

## Project Structure
NopCommerce/
│
├── src/
│ ├── main/java/org/example/pages/ # Page classes (POM)
│ ├── test/java/org/example/tests/ # Test classes
│ ├── utils/ # Utility and helper classes
│
├── testdata/ # Data files (Excel, CSV, JSON, etc.)
│
├── pom.xml # Maven dependencies
├── README.md # Project documentation


---

## Learning Outcomes
During this project, I improved my skills in:
- Building scalable automation frameworks  
- Handling dynamic elements and multiple data sources  
- Using TestNG annotations and parallel testing  
- Implementing reusable code design with POM  

---

## Repository
You can check the complete project here:  
[NopCommerce Automation Testing Project](https://github.com/EsraaElsofy1/NopCommerce)

---

## Demo
A short video demo will be shared soon, showing the automated test execution and framework workflow in action.

---

## Author
**Esraa Elsofy**  
Automation Tester | Quality Assurance Enthusiast  
[LinkedIn Profile](https://www.linkedin.com/in/esraaelsofy/)  
[GitHub](https://github.com/EsraaElsofy1)

---

## License
This project is licensed under the MIT License.  
Feel free to use, modify, and contribute.

---

## Acknowledgment
Special thanks to the NopCommerce demo platform for providing a great environment for automation testing practice.

