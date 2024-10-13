# 🏠 viaCep - REST API

REST API built with Java using [Spring Boot](https://start.spring.io/), the [Via Cep](https://viacep.com.br/) API and design patterns.

## Description

The viaCep REST API allows users to manage client information, automatically fetching address details based on the provided postal code (CEP, or Brazilian Postal Code) using the ViaCEP API.


## 🧩 Design Patterns Used

- **Singleton:** Ensures a class has only one instance and provides a global point of access.
- **Strategy:** Allows selecting an algorithm's behavior at runtime.
- **Facade:** Provides a simplified interface to a complex subsystem.

## 🛠️ CRUD Operations

| Operation | HTTP Method | Endpoint             | Description                   |
|-----------|-------------|----------------------|-------------------------------|
| Create    | POST        | `/client`           | Creates a new client.         |
| Read      | GET         | `/client`           | Retrieves a list of clients.  |
| Read      | GET         | `/client/{id}`      | Retrieves a client by ID.     |
| Update    | PUT         | `/client/{id}`      | Updates an existing client.   |
| Delete    | DELETE      | `/client/{id}`      | Deletes a client by ID.       |

### POST 📤

- **Endpoint:** `/client`
- **Description:** Creates a new client by providing a name and address (CEP). The application will fetch additional address details based on the provided CEP.

- **Request Body:**
```json
{
  "name": "Name of the Person",
  "address": {
    "cep": "12345678"  // CEP in numeric format 
  }
}
```
## 📦 Dependencies

Dependencies generated by [Spring Initializr](https://start.spring.io/):

- **Spring Boot Starter Data JPA**: For data access and JPA support.
- **Spring Boot Starter Web**: To build web applications, including RESTful services.
- **Spring Cloud Starter OpenFeign**: For declarative REST client.
- **H2 Database**: In-memory database for testing and development.
- **Lombok**: To reduce boilerplate code (optional).

[Maven Repository](https://mvnrepository.com/) dependencies:

- **[Springdoc OpenAPI Starter](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui)**: For API documentation using Swagger. 

## 📚 API Documentation

The API documentation is available at `/swagger-ui.html` once the application is running. You can access it by navigating to the following URL: http://localhost:8080/swagger-ui.html


## 💻 Technologies 

[![Techs Used](https://skillicons.dev/icons?i=java,spring,swagger&theme=dark)](https://skillicons.dev)