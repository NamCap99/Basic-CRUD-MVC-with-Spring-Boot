# Employee Management CRUD Application

This is a Spring Boot application for managing employees using CRUD (Create, Read, Update, Delete) operations. The application provides a REST API as well as a web-based interface to perform these operations.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features

- RESTful API for CRUD operations on employees.
- Web-based UI for listing, adding, updating, and deleting employees using Thymeleaf.
- Integration with a MySQL database for persistent storage.
- Exception handling for API endpoints.

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA (with Hibernate)
- Thymeleaf for server-side rendering
- MySQL for database storage
- Maven for dependency management

## Getting Started

These instructions will help you set up the project on your local machine.

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL database
- IDE (e.g., IntelliJ IDEA, Eclipse)
- Git (for version control)

### Setup and Installation

1. **Clone the Repository**

    ```bash
    git clone https://github.com/your-username/employee-crud-application.git
    cd employee-crud-application
    ```

2. **Set Up the Database**

    - Create a MySQL database. You can name it as you like (e.g., `employee_db`).
    - Update the `application.properties` file in `src/main/resources` to match your MySQL configuration:

    ```properties
    # src/main/resources/application.properties
    spring.datasource.url=jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. **Build the Project**

   Navigate to the project's root directory and build the application using Maven:

    ```bash
    mvn clean install
    ```

4. **Run the Application**

    ```bash
    mvn spring-boot:run
    ```

   The application will start running on [http://localhost:8080](http://localhost:8080).

## Usage

### Web Interface

- Visit `http://localhost:8080/employees/showList` to access the web-based employee management interface.
- You can add, update, and delete employee records from the UI.

### API Endpoints

- **GET** `/api/employees` - Retrieve all employees.
- **GET** `/api/employees/{employeeId}` - Retrieve an employee by ID.
- **POST** `/api/employees` - Add a new employee. Pass employee details as JSON in the request body.
- **PUT** `/api/employees` - Update an existing employee. Pass employee details as JSON in the request body.
- **DELETE** `/api/employees/{employeeId}` - Delete an employee by ID.

#### Sample JSON for Creating/Updating an Employee

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}
