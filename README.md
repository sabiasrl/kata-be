# Online Bookstore Backend (Spring Boot)

This is the backend REST API for the Online Bookstore project.

## Features
- Spring Boot (Java 17)
- RESTful API for books, cart, orders, and users
- H2 in-memory database for development
- JWT-based authentication
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

### Notes
- Uses H2 database for development (see `src/main/resources/application.properties`).
- Update database config for production use.

### TDD
- Write tests before implementing features.

---

See the frontend/README.md for running the React app.
