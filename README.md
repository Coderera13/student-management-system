# Student Management System

A Java-based web application for managing student records, built using Spring Boot, Spring Data JPA, MySQL, and a responsive Bootstrap interface.

The application supports student record creation, listing, filtering, updating through the REST API, and deletion.

## 🎥 Project Demo

**[▶ Watch the Student Management System Demo](./Screen%20Recording%202026-10-19%20163145.mp4)**

## ✨ Features

- Create and manage student records
- View and filter students by department
- Update student information through the REST API
- Delete student records
- REST API built with Spring Boot
- MySQL persistence for local development
- H2 in-memory database for automated tests
- Responsive Bootstrap interface
- Server-side validation and centralized API error handling

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Application development |
| Spring Boot 4.1.1 | Backend framework |
| Spring MVC | REST API |
| Spring Data JPA | Data persistence |
| Hibernate | Object-relational mapping |
| MySQL | Application database |
| H2 | Automated test database |
| HTML, Bootstrap, JavaScript | Frontend |
| Maven | Build and dependency management |

## 📋 Prerequisites

Install the following:

- JDK 21 or a compatible JDK supported by the project
- MySQL Server
- Apache Maven
- Git
- A modern web browser

See the [Spring Boot System Requirements](https://docs.spring.io/spring-boot/system-requirements.html) for Java and build-tool compatibility.

## 🚀 Installation and Setup — Windows

### 1. Clone the repository

Open PowerShell:

```powershell
git clone https://github.com/Coderera13/student-management-system.git
cd student-management-system
```

### 2. Create the database

Start MySQL and execute:

```sql
CREATE DATABASE college_db;
```

If the database already exists, you can skip this step.

### 3. Configure database credentials

Set the credentials for your current PowerShell session:

```powershell
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = Read-Host "Enter your MySQL password"
```

Use the username configured on your MySQL installation if it is not `root`.

The application reads the database configuration from `src/main/resources/application.properties`.

**Security:** Never commit your real database password to GitHub. The `.env.example` file is a template; Spring Boot does not automatically load it as environment variables.

### 4. Start the application

Run this command from the project root, where `pom.xml` is located:

```powershell
mvn spring-boot:run
```

If PowerShell reports that `mvn` is not recognized, install Maven or use the Maven executable installed on your computer.

Wait for a successful startup message similar to:

```text
Tomcat started on port 8080 (http)
Started StudentManagementApplication
```

### 5. Open the application

Visit:

**http://localhost:8080**

Keep the PowerShell window running while using the application.

## 🐧 Installation and Setup — macOS/Linux

Create the MySQL database first, then configure your environment variables:

```bash
export DB_USERNAME=root
read -s DB_PASSWORD
export DB_PASSWORD
```

Enter your MySQL password when prompted.

From the project root, start the application:

```bash
mvn spring-boot:run
```

Open **http://localhost:8080** in your browser.

## ⚙️ How the Application Works

1. The user opens the web interface in a browser.
2. The interface sends requests to the Spring Boot backend.
3. The backend validates requests and processes student operations.
4. Spring Data JPA and Hibernate interact with the configured database.
5. The application returns the result to the client.

## 🔌 REST API

| Method | Endpoint | Purpose | Success response |
|---|---|---|---|
| GET | `/api/students` | List students | `200 OK` |
| GET | `/api/students?department=CSE` | Filter by department | `200 OK` |
| GET | `/api/students/{id}` | Retrieve one student | `200 OK` |
| POST | `/api/students` | Create a student | `201 Created` |
| PUT | `/api/students/{id}` | Update a student | `200 OK` |
| DELETE | `/api/students/{id}` | Delete a student | `204 No Content` |

### Example request body

Use this JSON body when creating or updating a student, assuming the endpoint uses these fields:

```json
{
  "name": "Divya Menon",
  "email": "divya.menon@example.com",
  "department": "CSE"
}
```

### Error responses

The application is designed to return:

- `400 Bad Request` — invalid input
- `404 Not Found` — student record not found
- `409 Conflict` — duplicate email address

These response codes should be verified against the controller and exception-handler implementation.

## 🧪 Run Automated Tests

From the project root:

```powershell
mvn test
```

To run the tests and package the application:

```powershell
mvn clean verify
```

The test configuration uses an H2 in-memory database, keeping automated tests separate from the normal MySQL database.

The documented test scenarios include application startup, student creation and retrieval, duplicate-email validation, department filtering, updating, and deletion.

## 🗂️ Project Structure

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
    │   │   ├── controller/
    │   │   │   └── StudentController.java
    │   │   ├── entity/
    │   │   │   └── Student.java
    │   │   ├── exception/
    │   │   ├── repository/
    │   │   │   └── StudentRepository.java
    │   │   └── service/
    │   │       └── StudentService.java
    │   └── resources/
    │       ├── application.properties
    │       └── static/
    │           └── index.html
    └── test/
        ├── java/com/example/sms/
        └── resources/
            └── application-test.properties
```

## 🔒 Security and Limitations

- The application is intended for educational and local development use.
- No login or authorization is currently documented.
- Do not expose real student information or database credentials in screenshots, videos, or public deployments.
- Add authentication, authorization, and production database security before using the application with sensitive information.

## 🔮 Future Improvements

- Authentication and role-based authorization
- Student search, pagination, and sorting
- Improved frontend editing and validation
- API documentation with OpenAPI/Swagger
- Expanded automated test coverage
- Deployment to a cloud platform

## 👨‍💻 Author

GitHub: [@Coderera13](https://github.com/Coderera13)

## 📄 License

Add a license file if you intend to distribute this project under specific reuse terms.
