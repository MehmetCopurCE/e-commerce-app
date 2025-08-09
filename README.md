# 🛒 E-Commerce Microservices Project

This is a full-stack microservices-based e-commerce backend system built with Spring Boot and Spring Cloud. The project is inspired by [Ali Bouali's tutorial](https://www.youtube.com/watch?v=jdeSV0GRvwI) and has been fully developed from scratch.

## 🚀 Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Cloud (Gateway, Eureka)**
- **Spring Web**
- **Spring Data JPA & MongoDB**
- **Spring Security & Keycloak**
- **Kafka (Apache Kafka + Spring Kafka)**
- **Zipkin for Distributed Tracing**
- **Docker & Docker Compose**
- **PostgreSQL / MongoDB**
- **Lombok, MapStruct**

---

## 🧩 Microservices Overview

| Service Name         | Description |
|----------------------|-------------|
| **Product Service**  | Manages product catalog (CRUD operations) |
| **Inventory Service**| Keeps track of product stock levels |
| **Order Service**    | Handles order creation, validation, and stock checks |
| **Notification Service** | Sends email/notification on events (via Kafka) |
| **API Gateway**      | Routes requests to appropriate services |
| **Discovery Server** | Eureka server for service registration/discovery |

---

## 📦 Architecture

```text
Client -> API Gateway -> [Product, Order, Inventory Services]
                         -> Kafka -> Notification Service
                         -> Eureka -> All Services Register
                         -> Zipkin -> Tracing Logs
```
## ⚙️ How to Run
Make sure you have Docker and Java installed.
```
git clone https://github.com/your-username/ecommerce-microservices.git
cd ecommerce-microservices
docker-compose up --build

```
Make sure the following ports are available:

- Eureka: 8761
- Gateway: 8080
- Zipkin: 9411
- Keycloak: 8081 (if configured)

## 📚 API Endpoints
## 🔄 Event-Driven Flow
- Order Service publishes an event to Kafka
- Notification Service consumes it and sends email/log
- Inventory Service verifies stock before order creation

## 🛠️ Future Improvements
Implement distributed caching with Redis
Add UI for admin panel
Rate limiting / resilience with Resilience4J
Unit and integration tests

