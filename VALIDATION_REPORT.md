# Validation Report

## Checks included in this archive

- Source files are placed in the package paths matching their Java `package` declarations.
- The Maven POM declares Spring Boot Web MVC, Spring Data JPA, validation, MySQL, JUnit/Spring test support, and H2 for isolated tests.
- The test profile uses an in-memory H2 database, so automated tests do not require a running MySQL server or a database password.
- Automated integration-style service tests cover context startup, create/read, duplicate email, case-insensitive department filtering, update and delete.
- The frontend uses `textContent` when displaying user-provided text and handles failed API responses.

## Execution result in the preparation environment

A full Maven build/test was **not executed** in this environment: a JDK is present, but the `mvn` executable is not installed, and outbound DNS/network access to download Maven dependencies is unavailable. Therefore this report does not claim that `mvn test` passed. Run `mvn test` on a machine with Maven and internet/dependency access, then run the application against a configured local MySQL server using the commands in `README.md`.

## Important runtime prerequisites

A normal application run requires MySQL to be running, the `college_db` database to exist, and `DB_PASSWORD` to be set in the same terminal before `mvn spring-boot:run`. Without those settings, an application startup failure is expected; that is an environment configuration issue, not evidence of a successful application run.
