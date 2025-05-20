# e24-auto-tests

This project contains automated UI tests for the **EM24** platform, written in **Java**, using **Playwright** and **JUnit 5**. The project is built and run using **Maven**.

## 🔧 Tech Stack

- Java 23
- Playwright for Java (v1.52.0)
- JUnit 5 (v5.9.2)
- Maven
- Apache Maven Surefire Plugin


## 🚀 Quick Start

### Prerequisites

- Java 23+
- Maven 3.8+

### Environment Variables

Before running the tests, set the following environment variables:

```bash
export BASE_URL=https://emanagement24.com
export TEST_USER_NAME=user_name
export TEST_USER_PASSWORD=add_you_password
```

### Run Tests

Clone the repo and run tests with Maven:

```bash
git clone https://github.com/engmanager/e24-auto-tests.git
cd e24-auto-tests
mvn test
```
