# 🛒 eCommerce Backend Application

A RESTful eCommerce backend application built using **Java, Spring Boot, Spring Data JPA, and Hibernate**.

The project aims to develop a scalable and maintainable backend system for an eCommerce platform, following a layered architecture and REST API design principles.

> 🚧 **Project Status: Under Development**
>
> This project is currently in its early development stage. Features and APIs are being implemented incrementally.

## 🛠️ Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Database:** H2 (Development)
- **ORM:** Hibernate / Spring Data JPA
- **Build Tool:** Maven
- **Architecture:** Layered Architecture
- **API:** RESTful Web Services
- **Development IDE:** IntelliJ IDEA
- **Version Control:** Git & GitHub

## ✅ Current Implementation

### Category Management Module

- Create categories
- Retrieve categories
- Update existing categories
- Delete categories
- Category DTO and response handling
- Repository integration using Spring Data JPA
- Custom exceptions and global exception handling

### Application Architecture

The project follows a layered architecture:

- **Controller Layer:** Handles incoming HTTP requests.
- **Service Layer:** Contains business logic.
- **Repository Layer:** Handles database operations.
- **Model Layer:** Defines database entities.
- **DTO Layer:** Transfers data between application layers.
- **Exception Layer:** Handles application-specific exceptions.

## 📁 Project Structure

```text
src/main/java/com/SBecommerce/eCommerce/
│
├── config/
├── controller/
├── exception/
├── model/
├── payload/
├── Repository/
├── service/
└── ECommerceApplication.java
```

## 🔗 Category API Endpoints

Current category API routes:

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/public/categories` | Retrieve categories |
| POST | `/api/public/categories` | Create a category |
| PUT | `/api/admin/categories/{categoryId}` | Update a category |
| DELETE | `/api/admin/categories/{categoryId}` | Delete a category |

**Note:** API implementations, validation, and response structures may change as development progresses.

## ⚙️ Running the Project Locally

### Prerequisites

- Compatible Java JDK
- Maven or Maven Wrapper
- IntelliJ IDEA or another Java IDE

### Steps

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Allow Maven to download the required dependencies.
4. Run `ECommerceApplication.java`.
5. Access the application at `http://localhost:8080` using the configured API endpoints.

The application currently uses an H2 in-memory database for development.

## 🚀 Planned Features

- [x] Initial Spring Boot project setup
- [x] Category management module
- [x] DTO-based response handling
- [x] Global exception handling
- [ ] Product management
- [ ] User registration and authentication
- [ ] Spring Security and JWT authentication
- [ ] Role-based authorization
- [ ] Shopping cart management
- [ ] Order management
- [ ] PostgreSQL database integration
- [ ] API documentation using Swagger/OpenAPI
- [ ] Unit and integration testing

*The roadmap is tentative and may evolve during development.*

## 👨‍💻 Developer 

**Anurodh Kanojiya**


[LinkedIn](https://www.linkedin.com/in/anurodh-kanojiya-04721b287)

---

**Note:** This is an ongoing learning and development project. The codebase will be updated as new features are implemented.
