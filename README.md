# Deadline Management API

This Spring Boot project provides a RESTful API for managing deadlines categorized by time. It allows users to create, read, update, and delete deadlines based on their time categories.

## Features

- Create, read, update, and delete deadlines.
- Categorize deadlines by time (e.g., daily, weekly, monthly).
- Retrieve deadlines based on their categories.
- Authentication and authorization mechanisms for secure access.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. **Clone this repository:**
```bash
  git clone https://github.com/your_username/your_project.git
```
2. **Navigate to the project directory:**
```bash
  cd your_project
```
3. **Build the project using Maven:**
```bash
  mvn clean install
```
4. **Setup `application.properties` file:**
```init
spring.application.name= #your application's name
spring.datasource.url= # link to your database
spring.jpa.hibernate.ddl-auto= # strategy for hibernate database initialization
spring.jpa.show-sql= # configure whether you want to see sql queries made in logs (can be useful for debugging)
spring.jpa.properties.hibernate.dialect= # choose dialect for the database you are using
spring.jpa.properties.hibernate.format_sql= # choose whether to format sql
```

5. **Run the application:**
```
  mvn spring-boot:run
```
## Usage

Once the application is up and running, you can interact with the API using any HTTP client. You can also explore the API endpoints using tools like Postman or cURL.

## Endpoints

The API exposes the following endpoints:

- **GET /api/deadline/all**: Get all deadlines
- **POST /api/deadline/create**: Create a new deadline
- **PATCH /api/deadline/update**: Update a deadline
- **DELETE /api/deadline/delete**: Delete a deadline

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
