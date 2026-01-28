# Cloud-Native Microservices E-Commerce System

A production-style **cloud-native microservices-based e-commerce backend system** built using **Spring Boot 3** and **Spring Cloud**, focusing on scalability, service discovery, centralized configuration, and clean architecture.

This project demonstrates real-world backend engineering concepts used in modern distributed systems.

---

## 🚀 Architecture Overview

The system follows a **microservices architecture** with centralized configuration and service discovery.

### Core Components
- **API Gateway** – Single entry point for all client requests
- **Discovery Server (Eureka)** – Service registration and discovery
- **Config Server** – Centralized external configuration management
- **Product Service** – Product catalog management
- **Inventory Service** – Inventory availability and stock validation
- **Order Service** – Order placement (extensible)
- **Payment Service** – Payment handling (extensible)

---

## 🧱 Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Cloud 2023**
  - Eureka Discovery Server
  - Spring Cloud Config
  - API Gateway
- **Spring Data JPA**
- **PostgreSQL**
- **WebClient** (Inter-service communication)
- **Maven**
- **Git & GitHub**

---

## 📦 Services & Ports

| Service            | Port |
|--------------------|------|
| Config Server      | 8888 |
| Discovery Server   | 8761 |
| API Gateway        | 8080 |
| Product Service    | 8081 |
| Inventory Service  | 8082 |
| Order Service      | 8083 |
| Payment Service    | 8084 |

---

## 🔁 Inter-Service Communication

- **Product Service → Inventory Service**
- Implemented using **Spring WebClient**
- Inventory availability is validated before product-related operations
- Fully service-discovery based (no hardcoded URLs)

---

## 🗄 Database Design

- Each microservice uses **its own database schema**
- **PostgreSQL** as the relational database
- JPA + Hibernate for ORM
- Schema auto-managed using `spring.jpa.hibernate.ddl-auto=update`

---

## ⚙️ How to Run the Project (Local)

### Prerequisites
- Java 17
- Maven
- PostgreSQL
- Git

### Step-by-Step Startup Order

1. **Start Config Server**
   ```bash
   cd config-server
   mvn spring-boot:run
Start Discovery Server

cd discovery-server
mvn spring-boot:run


Start API Gateway

cd api-gateway
mvn spring-boot:run


Start Microservices

cd product-service
mvn spring-boot:run

cd inventory-service
mvn spring-boot:run

🔍 Verification

Eureka Dashboard:
👉 http://localhost:8761

Health Check:

GET /actuator/health


Inventory Check API:

GET /api/inventory/{productName}

🧪 Sample API Response
{
  "productName": "MacBook Pro",
  "available": true
}

🧠 Key Engineering Highlights

Centralized configuration using Spring Cloud Config

Service discovery using Eureka

Clean layered architecture (Controller, Service, Repository)

Inter-service communication using WebClient

Database-per-service design

Production-grade project structure

Git best practices followed

📌 Future Enhancements

Docker & Docker Compose

Kafka for event-driven communication

Circuit Breaker (Resilience4j)

Distributed tracing (Zipkin)

JWT-based authentication

Deployment on AWS

👨‍💻 Author

Simhadri Uttareni
Backend Engineer | Java | Spring Boot | Microservices

GitHub:
👉 https://github.com/simhadriuttareni

⭐ If you find this project useful, feel free to star the repository.

