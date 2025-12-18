# The Internet V2 – QA Automation Project

## Overview

This project is a QA Automation showcase built on top of **The Internet** demo application ([https://the-internet.herokuapp.com/](https://the-internet.herokuapp.com/)).

The goal of the project is **not** to demonstrate a complex automation framework, but to validate **core user behaviours and application state** using clean, maintainable Selenium tests.

The focus is on:

* user journeys
* smoke testing
* state validation
* clarity and explainability

---

## What This Project Tests

### Automated Scope (Smoke + Behaviour)

The following critical user behaviours are automated:

1. **User Authentication**

    * User can log in with valid credentials
    * Invalid credentials are correctly rejected

2. **Checkbox State Management**

    * User can select and unselect checkboxes
    * Application reflects the correct state

3. **Dropdown Selection**

    * User can select an option from a dropdown
    * Selected value is correctly displayed

4. **File Upload**

    * User can upload a file
    * Application confirms the uploaded file name

5. **JavaScript Alerts Handling**

    * User can interact with JavaScript alerts
    * Application displays correct feedback after alert interaction

All of the above are also covered by a **Smoke User Flows Suite**, which provides a fast health check of the application.

---

## What This Project Does NOT Test

Intentionally excluded from automation:

* Visual/UI styling
* Layout and responsiveness
* Performance testing
* Security testing
* Edge cases with low business value

These areas are better suited for **manual testing** or specialized tools and are outside the scope of this project.

---

## Project Structure

```
src
 ├── main/java
 │    └── com.mihai.theinternet
 │         ├── base
 │         └── pages
 ├── test/java
 │    ├── com.mihai.theinternet.tests
 │    └── smoke
 └── test/resources
      └── test.txt
```

* **base** – shared WebDriver setup and common actions
* **pages** – Page Object Model classes
* **tests** – behaviour-focused test classes
* **smoke** – end-to-end smoke user flows
* **resources** – test files used during execution

---

## Technology Stack

* Java
* Selenium WebDriver
* TestNG
* Maven

---

## How to Run the Tests

### Prerequisites

* Java 17+
* Maven installed
* Chrome browser

### Run all tests

```bash
mvn test
```

### Run only Smoke Suite

You can run the `SmokeUserFlowsTest` class directly from your IDE or configure it as a TestNG suite.

---

## Design Decisions

* **Page Object Model** is used to separate behaviour from UI structure
* Test classes describe **user behaviour**, not technical implementation
* Minimal framework setup to avoid overengineering
* Tests are designed to be:

    * readable
    * maintainable
    * easy to explain in interviews or client discussions

---

## Purpose

This project is intended as:

* a portfolio-ready QA Automation example
* a demonstration of QA thinking and test design
* a base for further end-to-end automation work

It prioritizes **clarity and business value** over exhaustive coverage.
