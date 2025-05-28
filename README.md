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

### Running the Application
```bash
./mvnw spring-boot:run
```
The API will be available at `http://localhost:8080`.

### OpenAPI/Swagger UI
- Visit [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) or [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) to view and test the API documentation.
- The API description is set via the `openapi.description` property in `src/main/resources/application.properties`.

### Running Tests
```bash
./mvnw test
```

### API Endpoints (to be implemented)
- `GET /books` - List all books
- `POST /cart/add` - Add book to cart
- `PUT /cart/update` - Update cart item quantity
- `DELETE /cart/remove` - Remove item from cart
- `GET /cart` - Get cart contents
- `POST /order/checkout` - Checkout order
- `POST /auth/register` - Register user
- `POST /auth/login` - Login user

### Database Initialization with Sample Fantasy Books
To prepopulate the database with 100 top fantasy books (including Tolkien and other major fantasy authors), run the backend with the `acc` Spring profile enabled:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=acc
```

This will insert the sample data only if the database is empty. The data initializer will not run unless the `acc` profile is active.

### Notes
- Uses H2 database for development (see `src/main/resources/application.properties`).
- Update database config for production use.
- OpenAPI config is in `com.soprasteria.bookstore.config.OpenApiConfig`.

### TDD
- Write tests before implementing features.

---

See the frontend/README.md for running the React app.
