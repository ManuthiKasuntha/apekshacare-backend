

```markdown
# ApekshaCare Backend

Spring Boot backend for **ApekshaCare**, a smart cancer care navigation and patient support system.

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Hibernate
- Jakarta Validation
- Lombok
- Maven

## Architecture

The application follows a layered architecture:

```text
Controller
   ↓
Service
   ↓
Repository
   ↓
PostgreSQL
```

Supporting layers include DTOs, mappers, centralized exception handling, and scheduled tasks.

## Features

- Appointment CRUD operations
- Request validation
- DTO-based API responses
- Centralized exception handling
- PostgreSQL persistence
- Appointment reminder scheduling

## API

Base URL:

```text
http://localhost:8081/api/v1/appointments
```

Endpoints:

```text
POST   /api/v1/appointments
GET    /api/v1/appointments
GET    /api/v1/appointments/{id}
PUT    /api/v1/appointments/{id}
DELETE /api/v1/appointments/{id}
```

## Configuration

Set the following environment variable before running:

```text
DB_PASSWORD=your_postgresql_password
```

Example datasource configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/apekshacare_db
spring.datasource.username=apekshacare_user
spring.datasource.password=${DB_PASSWORD}
```

## Run Locally

```bash
git clone https://github.com/ManuthiKasuntha/apekshacare-backend.git
cd apekshacare-backend
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

## Development Workflow

Development is organized using feature branches such as:

```text
feature/appointment-model
feature/appointment-repository
feature/appointment-service
feature/appointment-dto
feature/appointment-mapper
feature/appointment-controller
feature/appointment-exception
feature/appointment-scheduler
```

Each branch is developed, tested, reviewed, and merged into `main`.

## License

Developed as part of the ApekshaCare academic project.
```
