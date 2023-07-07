# TDDMini

# Order Management System

The Order Management System is a simple web application that allows users to handle order-related functionalities. It is built using Spring Boot and follows the principles of Test-Driven Development (TDD).

## Prerequisites
Before running the project, make sure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- Maven or Gradle (depending on your preference)

## Getting Started
Follow the steps below to run and test the Order Management System project:

1. Clone the repository to your local machine:
   ```
   git clone <repository_url>
   ```

2. Navigate to the project directory:
   ```
   cd order-management-system
   ```

3. Build the project using Maven or Gradle:
   - Using Maven:
     ```
     mvn clean package
     ```
   - Using Gradle:
     ```
     ./gradlew clean build
     ```

4. Run the application:
   - Using Maven:
     ```
     mvn spring-boot:run
     ```
   - Using Gradle:
     ```
     ./gradlew bootRun
     ```

5. The application will start and listen on `http://localhost:8080`.

## Testing
The project includes unit tests for the repository and controller classes. To run the tests, use the following command:

- Using Maven:
  ```
  mvn test
  ```

- Using Gradle:
  ```
  ./gradlew test
  ```

The tests will execute and display the results in the console.

## API Endpoints
The following API endpoints are available:

- `GET /orders/`: Retrieves a list of all orders.
- `GET /orders/{id}`: Retrieves a specific order by ID.
- `POST /orders/`: Creates a new order.
- `PUT /orders/{id}`: Updates an existing order.
- `DELETE /orders/{id}`: Deletes an existing order.

Make sure to include the necessary request payload or parameters when making requests to these endpoints.

## Error Handling
The application handles validation errors and order not found exceptions. If any of these occur, appropriate error responses will be returned with details.

## Technologies Used
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven or Gradle
