# Microservices-Order-Management-System

## Architecture

Client
  |
API Gateway
  |
-------------------------
|                       |
User Service       Order Service
                        |
                     Kafka
                        |
               Notification Service

Eureka Server handles service discovery.

## Tech Stack

- Java 21
- Spring Boot
- Spring Cloud Gateway
- Eureka Server
- OpenFeign
- Kafka
- Resilience4j
- Docker
- Docker Compose

## Features

- Service Discovery using Eureka
- API Gateway Routing
- Inter-service communication using OpenFeign
- Circuit Breaker using Resilience4j
- Event-driven architecture using Kafka
- Notification service consuming Kafka events
- Dockerized microservices

## Services

### User Service
Provides user information.

### Order Service
Creates orders and publishes Kafka events.

### Notification Service
Consumes Kafka events and generates notifications.

### API Gateway
Single entry point for all APIs.

### Eureka Server
Service registry.
