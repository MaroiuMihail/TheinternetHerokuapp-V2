# Test Plan – The Internet V2 (QA Automation)

## 1. Purpose

The purpose of this project is to validate **core user behaviours** and **application state** for the demo application (The Internet), using a lean Selenium + TestNG automation approach.

This is a portfolio-focused test plan designed to demonstrate:

* behaviour-driven test design (Given / When / Then thinking)
* smoke coverage for critical flows
* clear automation scope decisions

---

## 2. In Scope (Automated)

Automation focuses on stable, high-value behaviours that provide fast feedback.

### 2.1 Smoke User Flows Suite

A dedicated smoke suite exists to quickly validate overall application health:

* Authentication success flow
* Checkboxes state interaction
* Dropdown selection
* File upload confirmation
* JavaScript alert handling

### 2.2 Feature-Level Behaviour Tests

Behaviour tests validate user actions and observable state:

1. **Authentication**

    * Valid credentials allow access (positive flow)
    * Invalid credentials are rejected (negative coverage)

2. **Checkboxes State Validation**

    * User can check/uncheck
    * Correct selection state is reflected

3. **Dropdown Selection**

    * User selects a specific option
    * Selected option is correctly displayed

4. **File Upload**

    * User uploads a file from test resources
    * UI confirms uploaded file name

5. **JavaScript Alerts**

    * User interacts with confirm alert (dismiss)
    * UI displays correct result message

---

## 3. Out of Scope (Not Automated)

The following are intentionally excluded to avoid overengineering and scope creep:

* Visual styling / layout verification
* Responsive design validation
* Performance testing
* Security testing
* Extensive boundary/edge-case testing
* Cross-browser matrix execution

---

## 4. Manual Testing Strategy

Manual testing is appropriate for areas with low ROI for automation or high flakiness risk:

* UI/UX visual checks (layout, fonts, spacing)
* Exploratory testing for unexpected behaviour
* Edge cases not critical to smoke coverage
* Browser-specific rendering differences

---

## 5. Risks and Mitigations

### Risk: Flaky tests due to timing issues

* Mitigation: explicit waits in BasePage; avoid Thread.sleep

### Risk: Environment / local path dependency (file upload)

* Mitigation: use `src/test/resources` files and build file paths at runtime

### Risk: Over-expanding scope

* Mitigation: fixed automated scope (5 features) + smoke suite only

---

## 6. Entry / Exit Criteria

### Entry

* Application is reachable
* Chrome browser available
* Test file exists in `src/test/resources/test.txt`

### Exit

* Smoke suite runs green
* Behaviour tests run green
* README and TestPlan present in repository

---

## 7. Test Execution

### Run all tests

```bash
mvn test
```

### Run smoke suite

Run `SmokeUserFlowsTest` from IDE (or configure as a TestNG suite if needed).
