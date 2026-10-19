# Student Management System

A web-based Student Management System built using **Java 21, Spring Boot, Spring Data JPA, MySQL, Maven, and HTML**. This project demonstrates student record management through a browser-based interface and a database-backed backend.

## 🎥 Project Demo

**[▶ Watch the Student Management System Demo](./Screen%20Recording%202026-10-19%20163145.mp4)**

The demo video shows the application running locally.

## 📌 Project Overview

The Student Management System helps manage student records through a web interface connected to a MySQL database. The Spring Boot backend handles application requests and database operations.

## ✨ Features

- Add student records
- View student records
- Update existing student information
- Delete student records
- Store student information in MySQL
- Browser-based user interface
- Spring Boot backend with database persistence

*The listed CRUD features should match the operations implemented in the current version of the application.*

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Backend programming |
| Spring Boot | Web application framework |
| Spring Data JPA | Database access |
| Hibernate | ORM and persistence |
| MySQL 8 | Relational database |
| Maven | Build and dependency management |
| HTML | User interface |
| Apache Tomcat | Embedded web server |

## 📋 Prerequisites

Install the following software:

- JDK 21
- MySQL Server 8.0 or compatible
- Git
- A web browser such as Chrome or Edge
- Maven, or a working Maven Wrapper

## 🚀 Installation and Setup

### 1. Clone the repository

Open PowerShell and run:

```powershell
git clone https://github.com/Coderera13/student-management-system.git
cd student-management-system
```

If you already have the project, open PowerShell in its existing directory instead.

### 2. Create the database

Log in to MySQL and execute:

```sql
CREATE DATABASE college_db;
```

If `college_db` already exists, you can continue without recreating it.

### 3. Configure database credentials

Open `src/main/resources/application.properties` and check that the datasource configuration uses your local database credentials.

The project configuration uses these settings:

```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/college_db
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
```

Set your credentials in PowerShell before starting the application:

```powershell
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = Read-Host "Enter your MySQL password"
```

Enter your own MySQL password when prompted. Use your configured MySQL username if it is not `root`.

**Security:** Never commit your actual database password to GitHub. Keep credentials in environment variables or an appropriate secrets manager.

### 4. Run the application

From the directory containing `pom.xml`, run:

```powershell
mvn spring-boot:run
```

If Maven is not recognized, install/configure Maven or use the Maven executable available on your computer. The current repository does not contain `mvnw.cmd`.

Wait for a successful startup message similar to:

```text
Tomcat started on port 8080 (http)
Started StudentManagementApplication
```

### 5. Open the application

Open your browser and visit:

**http://localhost:8080**

The application serves its homepage from `src/main/resources/static/index.html`.

Keep the terminal running while using the application.

## ⚙️ How It Works

1. The user opens the application in a browser.
2. The interface allows the user to manage student information.
3. Spring Boot processes application requests.
4. The persistence layer communicates with MySQL.
5. The application returns the result to the interface.

### CRUD Operations

| Operation | Description |
|---|---|
| Create | Add a student |
| Read | View student records |
| Update | Edit student information |
| Delete | Remove a student record |

## 🗂️ Project Structure

```text
student-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │           └── index.html
│   └── test/
├── .env.example
├── .gitignore
├── pom.xml
├── README.md
└── Screen Recording 2026-10-19 163145.mp4
```

## 🧪 Testing and Build

Run tests:

```powershell
mvn test
```

Build the project:

```powershell
mvn clean package
```

Run these commands from the directory containing `pom.xml`.

## 🔒 Security Considerations

- Do not publish database credentials.
- Avoid using real student information in demo recordings.
- Use appropriate database permissions.
- Add authentication and authorization before deploying sensitive student data.

## 🔮 Future Improvements

- Student search and filtering
- Pagination and sorting
- Input validation and error handling
- User authentication and role-based access control
- API documentation
- Automated tests
- Cloud deployment

## 👨‍💻 Author

**GitHub:** [Coderera13](https://github.com/Coderera13)

## 📄 License

Add a license file if you intend to distribute this project under specific reuse terms.
