# Online Bookstore Backend (Spring Boot)

This is the backend REST API for the Online Bookstore project.

## Features
- Spring Boot (Java 17)
- RESTful API for books, cart, orders, and users
- H2 in-memory database for development
- JWT-based authentication
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

For Acceptance, the database will be prepopulated with 100 top fantasy books (including Tolkien and other major fantasy authors), it is needed the profile `acc`.

The API will be available at `http://localhost:8080`.

### OpenAPI/Swagger UI
- Visit [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) to view and test the API documentation.

### Running Tests
```bash
./mvnw test
```

### API Endpoints
- `GET /books` - List all books
- `POST /cart/add` - Add book to cart
- `PUT /cart/update` - Update cart item quantity
- `DELETE /cart/remove` - Remove item from cart
- `GET /cart` - Get cart contents
- `POST /order/checkout` - Checkout order
- `POST /auth/register` - Register user
- `POST /auth/login` - Login user

### Notes
- Uses H2 database for development (see `src/main/resources/application.properties`).
- Update database config for production use.
- OpenAPI config is in `com.soprasteria.bookstore.config.OpenApiConfig`.

### TDD
- Write tests before implementing features.

---
