# REST API for User Management

This project is a Spring Boot-based REST API application for managing user data. It provides endpoints for creating, reading, updating, and deleting user information. The application uses ModelMapper for object mapping, JPA for database interactions, and includes robust exception handling mechanisms.

---

## Features

- **User Management**:
    - Create a new user with validation for required fields.
    - Retrieve a list of all users.
    - Fetch user details by ID.
    - Update existing user information.
    - Delete a user by ID.

- **Validation**:
    - Input validation for user fields like `firstName`, `lastName`, and `email`.
    - Custom error messages for invalid input.

- **Exception Handling**:
    - Global exception handling using `@ControllerAdvice`.
    - Specific error responses for resource not found, duplicate email, and other issues.

- **Clean Code**:
    - Separation of concerns with layers for controller, service, repository, and DTOs.
    - Reusable components with ModelMapper and custom mappers.

---

## Technologies Used

- **Backend**:
    - Spring Boot
    - Spring Data JPA
    - ModelMapper
    - Hibernate

- **Database**:
    - MySQL

- **Validation**:
    - Jakarta Validation API

- **Build Tool**:
    - Maven

---

## Endpoints

| HTTP Method | Endpoint           | Description                  |
|-------------|--------------------|------------------------------|
| `POST`      | `/user/create`     | Create a new user            |
| `GET`       | `/user/all`        | Retrieve all users           |
| `GET`       | `/user/get/{id}`   | Get user details by ID       |
| `PUT`       | `/user/update/{id}`| Update user details          |
| `DELETE`    | `/user/delete/{id}`| Delete a user by ID          |
