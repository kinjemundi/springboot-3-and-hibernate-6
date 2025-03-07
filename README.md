# Spring Boot 3.4 and Hibernate 6: Exploring New Features

This project demonstrates the new features and improvements introduced in **Spring Boot 3.4** and **Hibernate 6**. It serves as a guide to help developers explore and understand the latest capabilities of these frameworks.

---

## Table of Contents

1. [Introduction](#introduction)
2. [Spring Boot 3.4 Features](#spring-boot-34-features)
    - [Native Image Support](#native-image-support)
    - [Improved Observability](#improved-observability)
    - [Enhanced Docker Support](#enhanced-docker-support)
    - [New Configuration Properties](#new-configuration-properties)
3. [Hibernate 6 Features](#hibernate-6-features)
    - [Jakarta Persistence 3.1 Support](#jakarta-persistence-31-support)
    - [Enhanced SQL Query Handling](#enhanced-sql-query-handling)
    - [New Annotation Support](#new-annotation-support)
    - [Performance Improvements](#performance-improvements)
4. [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Running the Application](#running-the-application)
5. [Contributing](#contributing)
6. [License](#license)

---

## Introduction

Spring Boot 3.4 and Hibernate 6 bring a host of new features, improvements, and optimizations to the Java ecosystem. This project provides a hands-on exploration of these features, with examples and explanations to help you get started quickly.

---

## Spring Boot 3.4 Features

### Native Image Support
Spring Boot 3.4 enhances support for **GraalVM Native Images**, making it easier to compile your applications into native executables. This results in faster startup times and reduced memory usage.

**Example:**
```bash
./mvnw -Pnative native:compile
```

### Improved Observability
Spring Boot 3.4 introduces better integration with **Micrometer 2.0** and **OpenTelemetry**, providing enhanced metrics, tracing, and logging capabilities.

**Example:**
```yaml
management:
  tracing:
    enabled: true
    sampling:
      probability: 1.0
```

### Enhanced Docker Support
The new version includes improved Docker image building with **Buildpacks** and **Docker Compose** integration, simplifying containerization and deployment.

**Example:**
```bash
./mvnw spring-boot:build-image
```

### New Configuration Properties
Spring Boot 3.4 adds several new configuration properties for better customization and control over your application.

**Example:**
```yaml
spring:
  application:
    name: boot ecommerce
  datasource:
    url: jdbc:postgresql://localhost:5432/boot_db
    username: boot_user
    password: boot_secret
    driver-class-name: org.postgresql.Driver
    # Optional: Connection pool configuration (if you're using HikariCP)
    hikari:
      maximum-pool-size: 100
      minimum-idle: 5
      idle-timeout: 30000
      pool-name: HikariCP
      connection-timeout: 20000
      max-lifetime: 1800000
  jpa:
    hibernate:
      ddl-auto: update       # options: validate | update | create | create-drop
    properties:
      hibernate:
        format_sql: true
    show-sql: true            # logs SQL queries for debugging
    open-in-view: false
```

---

## Hibernate 6 Features

### Jakarta Persistence 3.1 Support
Hibernate 6 now fully supports **Jakarta Persistence 3.1**, replacing the older `javax.persistence` namespace. This aligns with the latest Jakarta EE standards.

**Example:**
```java
package com.kinjemundi.boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "tx_product")
@RequiredArgsConstructor
public class Product extends BaseEntity{
    String name;
    String description;

    @JdbcTypeCode(SqlTypes.JSON)
    Set<ProductVariation> variation;
}
```

### Enhanced SQL Query Handling
Hibernate 6 introduces improved SQL query handling, including better support for **CTEs (Common Table Expressions)** and **window functions**.

**Example:**
```java
String sql = "WITH ranked_products AS (" +
             "SELECT id, name, RANK() OVER (ORDER BY price) as rank " +
             "FROM tx_product) " +
             "SELECT * FROM ranked_products WHERE rank <= 10";
List<Product> products = session.createNativeQuery(sql, Product.class).getResultList();
```

### New Annotation Support
Hibernate 6 adds support for new annotations like `@Where`, `@Filter`, and `@FilterDef`, enabling more dynamic and flexible querying.

**Example:**
```java
@Entity
@Where(clause = "active = true")
public class User {
    @Id
    private Long id;
    private boolean active;
}
```

### Performance Improvements
Hibernate 6 includes significant performance optimizations, such as reduced memory consumption and faster query execution.

---

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.8 or higher
- Docker (optional, for containerization)

### Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/kinjemundi/springboot-3-and-hibernate-6.git
   cd springboot-3-and-hibernate-6
   ```

2. Build the project:
   ```bash
   ./mvnw clean install
   ```

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Access the application at `http://localhost:8085`.

---

## Contributing
Contributions are welcome! If you'd like to contribute, please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Submit a pull request with a detailed description of your changes.

---

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Happy coding! 🚀