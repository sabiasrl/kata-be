# KATA - Online Bookstore - Backend (Spring Boot)

This is the backend REST API for the Online Bookstore project.

## Features
- Spring Boot (Java 17)
- RESTful API for books, cart, orders, and users
- H2 in-memory database for development
- OpenAPI/Swagger documentation (configurable description via `openapi.description` in `application.properties`)
- TDD with JUnit and Mockito

## Getting Started

### Prerequisites
- Java 17+
- Maven

### Running the Application - Acceptance profile
```bash
./mvnw clean install && ./mvnw spring-boot:run -Dspring-boot.run.profiles=acc
```

For Acceptance profile, the database will be prepopulated with 100 top fantasy books (including Tolkien and other major fantasy authors). The profile needed is `acc`.

The API will be available at `http://localhost:8080`.

### OpenAPI/Swagger UI
- Visit [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) to view and test the API documentation.

### API Endpoints
- `POST /auth/register` - Register user
- `POST /auth/login` - Login user
- `GET /books` - List all books
- `POST /cart` - Add book to cart
- `GET /cart` - Get cart contents
- `PUT /cart` - Update cart item quantity
- `DELETE /cart` - Remove item from cart
- `POST /order/checkout` - Checkout order

### Notes
- Uses H2 database for development (see `src/main/resources/application.properties`).

---

## License

Proprietary. Copyright © 2025 Sabia Srl. All rights reserved.
Unauthorized use is prohibited.
