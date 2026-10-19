# Student Management System

A local Java full-stack mini project based on the Student Management System described in the uploaded internship report. This archive is organized for local use. **It has not been published or pushed to GitHub.**

## Project structure

```text
student-management-system/
├── pom.xml
├── .env.example
├── README.md
├── VALIDATION_REPORT.md
└── src/
    ├── main/
    │   ├── java/com/example/sms/
    │   │   ├── StudentManagementApplication.java
    │   │   ├── controller/StudentController.java
    │   │   ├── entity/Student.java
    │   │   ├── exception/
    │   │   │   ├── DuplicateEmailException.java
    │   │   │   ├── GlobalExceptionHandler.java
    │   │   │   └── ResourceNotFoundException.java
    │   │   ├── repository/StudentRepository.java
    │   │   └── service/StudentService.java
    │   └── resources/
    │       ├── application.properties
    │       └── static/index.html
    └── test/
        ├── java/com/example/sms/StudentManagementApplicationTests.java
        └── resources/application-test.properties
```

## Technology stack

- Java 17 or newer
- Spring Boot 4.1.1, Spring MVC REST, Spring Data JPA/Hibernate
- MySQL for normal application runs
- H2 in-memory database for automated tests
- HTML, Bootstrap, JavaScript Fetch API
- Maven for dependency management and build

## Requirements

Install a JDK (17+), Maven 3.6.3+ and MySQL Server. Spring Boot's requirements are documented in the official [system requirements](https://docs.spring.io/spring-boot/system-requirements.html).

## Run locally on Windows PowerShell

1. Create the database in MySQL:

   ```sql
   CREATE DATABASE college_db;
   ```

2. In the project root, set your local database credentials. Replace the example password with your actual MySQL password:

   ```powershell
   $env:DB_USERNAME = "root"
   $env:DB_PASSWORD = "your_mysql_password"
   ```

3. Start the application:

   ```powershell
   mvn spring-boot:run
   ```

4. Open **http://localhost:8080** in your browser.

## Run locally on macOS/Linux

```bash
export DB_USERNAME=root
export DB_PASSWORD='your_mysql_password'
mvn spring-boot:run
```

Then open **http://localhost:8080**.

Do not paste actual passwords into source code or share them in screenshots. The sample `.env.example` is a template only; Spring does not automatically load it.

## Run automated tests

From the project root:

```bash
mvn test
```

The tests use an isolated H2 in-memory database and do not require MySQL credentials. The test profile checks application-context startup, creating and reading records, duplicate-email rejection, department filtering, updating, and deleting.

## REST API

| Method | Endpoint | Purpose | Expected success |
|---|---|---|---|
| GET | `/api/students` | List students | `200 OK` |
| GET | `/api/students?department=CSE` | Filter by department | `200 OK` |
| GET | `/api/students/{id}` | Get one student | `200 OK` |
| POST | `/api/students` | Create a student | `201 Created` |
| PUT | `/api/students/{id}` | Update a student | `200 OK` |
| DELETE | `/api/students/{id}` | Delete a student | `204 No Content` |

Example JSON body for POST and PUT:

```json
{
  "name": "Divya Menon",
  "email": "divya.menon@example.com",
  "department": "CSE"
}
```

Validation errors return `400 Bad Request`, unknown IDs return `404 Not Found`, and duplicate email addresses return `409 Conflict`.

## Scope and limitations

The web page supports adding, listing, filtering and deleting. The REST API also supports retrieving and updating an individual student. There is no login or authorization, so this educational project should not be exposed publicly without adding security controls.

## Features

- Create, list, filter, edit, and delete student records
- REST API with Spring Boot and Spring Data JPA
- MySQL persistence for local development
- H2-backed automated tests
- Responsive Bootstrap interface
- Server-side validation and API error responses

## REST endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/students` | List students; optional `?department=CSE` filter |
| GET | `/api/students/{id}` | Get one student |
| POST | `/api/students` | Create a student |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student |

## Before publishing to GitHub

- Confirm `.env` files and real passwords are not committed.
- Run the test suite and build: `mvn clean verify`.
- Replace this README's title/description if you customize the project.
- Add screenshots of the running app to a `docs/screenshots/` folder.
- Create a new GitHub repository, then from the project root run:

  ```powershell
  git init
  git add .
  git commit -m "Add Student Management System"
  git branch -M main
  git remote add origin https://github.com/YOUR-USERNAME/student-management-system.git
  git push -u origin main
  ```

Replace `YOUR-USERNAME` with your GitHub username and use the repository URL GitHub gives you. Do not publish database credentials.
