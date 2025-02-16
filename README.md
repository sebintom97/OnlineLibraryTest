# Online Library Backend

This is the backend service for the Online Library application, built using **Spring Boot**. It provides RESTful APIs for managing books and authors.

## Features
- CRUD operations for books and authors
- Secure API endpoints using Spring Security

## Tech Stack
- **Java** (Core Java, Spring Boot)
- **Spring Boot** (Spring Data JPA, Spring Security)

## Getting Started

### Prerequisites
- Install [Java 17+](https://adoptopenjdk.net/)
- Install [Maven](https://maven.apache.org/install.html)

### Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/sebintom97/OnlineLibraryTest.git
   cd OnlineLibraryTest
   ```
2. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints
| HTTP Method | Endpoint | Description |
|------------|---------|-------------|
| GET | `/app/library` | Get all books |
| GET | `/app/library/top-authors` | Get all authors |
| GET | `/app/library/{id}` | Get book by ID |
| GET | `/app/library/summary` | Get summary of a book |
| PUT | `/app/library/{id}` | Update book details |
| DELETE | `/app/library/{id}` | Delete a book |

For more endpoints, refer to the **Swagger documentation** at: `http://localhost:8080/swagger-ui.html`


## Contributing
Feel free to open issues or submit pull requests to improve this project.

## License
This project is licensed under the MIT License.
