# Notes API - Project Summary

## Overview

A secure RESTful API for personal note management built with Spring Boot, demonstrating Agile methodology and DevOps practices.

---

## Project Structure

```
Agile-And-Devops/
├── 0-Sprint-Plan.md              # Sprint 0: Planning
├── 1-Sprint-1.md                 # Sprint 1: Execution
├── 1-Sprint-1-Review.md          # Sprint 1: Review & Retrospective
├── 2-Sprint-2.md                 # Sprint 2: Execution
├── 2-Sprint-2-Review.md          # Sprint 2: Review & Retrospective
└── notes-api/                    # Spring Boot Application
    ├── src/
    │   ├── main/java/com/notes/api/
    │   │   ├── controller/       # REST endpoints
    │   │   ├── service/          # Business logic
    │   │   ├── repository/       # Data access
    │   │   ├── model/            # JPA entities
    │   │   ├── dto/              # Request/Response objects
    │   │   ├── security/         # JWT authentication
    │   │   └── config/           # Configuration
    │   └── test/java/            # Unit & integration tests
    ├── .github/workflows/        # CI/CD pipeline
    ├── Dockerfile                # Container configuration
    ├── docker-compose.yml        # Deployment configuration
    └── pom.xml                   # Maven dependencies
```

---

## Features Delivered

### Sprint 1
- \u2705 User Registration (JWT authentication)
- \u2705 User Login (token-based)
- \u2705 Create Note

### Sprint 2
- \u2705 View My Notes
- \u2705 Update Note
- \u2705 Delete Note
- \u2705 Automated Testing (65% coverage)
- \u2705 CI/CD Pipeline (GitHub Actions)
- \u2705 Docker Containerization

---

## Quick Start

### Prerequisites
- Java 17
- Maven 3.6+
- Docker (optional)

### Run Locally

```bash
cd notes-api
mvn clean install
mvn spring-boot:run
```

Application starts on: `http://localhost:8080`

### Run Tests

```bash
mvn test
mvn jacoco:report
```

View coverage: `target/site/jacoco/index.html`

### Run with Docker

```bash
docker build -t notes-api .
docker run -p 8080:8080 notes-api

# Or use docker-compose
docker-compose up
```

---

## API Endpoints

### Authentication

**Register:**
```bash
POST /api/auth/register
Body: {"email":"user@example.com","password":"password123"}
```

**Login:**
```bash
POST /api/auth/login
Body: {"email":"user@example.com","password":"password123"}
Response: {"token":"eyJhbG...","email":"user@example.com"}
```

### Notes (Requires Authentication)

**Create Note:**
```bash
POST /api/notes
Headers: Authorization: Bearer {token}
Body: {"title":"My Note","content":"Content here"}
```

**Get All Notes:**
```bash
GET /api/notes
Headers: Authorization: Bearer {token}
```

**Update Note:**
```bash
PUT /api/notes/{id}
Headers: Authorization: Bearer {token}
Body: {"title":"Updated","content":"New content"}
```

**Delete Note:**
```bash
DELETE /api/notes/{id}
Headers: Authorization: Bearer {token}
```

---

## Testing Guide

### Manual Testing Flow

1. **Register a user:**
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com","password":"test123"}'
```

Save the token from response.

2. **Create a note:**
```bash
curl -X POST http://localhost:8080/api/notes \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -d '{"title":"Test Note","content":"This is a test"}'
```

3. **View all notes:**
```bash
curl -X GET http://localhost:8080/api/notes \
  -H "Authorization: Bearer YOUR_TOKEN"
```

4. **Update note (use ID from previous response):**
```bash
curl -X PUT http://localhost:8080/api/notes/1 \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -d '{"title":"Updated Title","content":"Updated content"}'
```

5. **Delete note:**
```bash
curl -X DELETE http://localhost:8080/api/notes/1 \
  -H "Authorization: Bearer YOUR_TOKEN"
```

### Automated Tests

Run all tests:
```bash
mvn test
```

Run specific test class:
```bash
mvn test -Dtest=AuthServiceTest
```

Generate coverage report:
```bash
mvn jacoco:report
open target/site/jacoco/index.html
```

---

## DevOps Implementation

### CI/CD Pipeline

**GitHub Actions Workflow** (`.github/workflows/ci.yml`):
- Triggers on push to main/develop
- Builds application with Maven
- Runs all tests
- Generates coverage report
- Enforces 50% minimum coverage
- Uploads test results as artifacts

### Code Quality

- **JaCoCo:** Code coverage analysis
- **JUnit 5:** Unit testing framework
- **Mockito:** Mocking framework
- **Spring Test:** Integration testing

### Containerization

- **Multi-stage Dockerfile:** Optimized image size
- **Docker Compose:** Easy local deployment
- **Alpine Linux:** Minimal base image

---

## Technology Stack

**Backend:**
- Spring Boot 3.2.0
- Spring Security (JWT)
- Spring Data JPA
- H2 Database (in-memory)

**Testing:**
- JUnit 5
- Mockito
- Spring MockMvc
- JaCoCo

**DevOps:**
- Maven
- GitHub Actions
- Docker
- Docker Compose

---

## Agile Metrics

### Sprint 1
- Stories: 3/4 completed (75%)
- DoD Compliance: 57%
- Velocity: 9 SP
- Technical Debt: High

### Sprint 2
- Stories: 3/3 completed (100%)
- DoD Compliance: 100%
- Velocity: 7 SP
- Technical Debt: Low
- Test Coverage: 65%

### Overall Project
- Total Stories: 6/7 completed (86%)
- Final DoD Compliance: 100%
- Production Ready: Yes

---

## Key Achievements

\u2705 **Complete CRUD API** - All note operations functional  
\u2705 **Secure Authentication** - JWT-based with password encryption  
\u2705 **Automated Testing** - 65% code coverage  
\u2705 **CI/CD Pipeline** - Automated build and test  
\u2705 **Containerized** - Docker-ready deployment  
\u2705 **Authorization** - Users can only access their own notes  
\u2705 **Error Handling** - Consistent error responses  
\u2705 **Input Validation** - Bean validation on all inputs

---

## Lessons Learned

1. **DevOps from Day 1** - Setting up CI/CD early prevents technical debt
2. **DoD is Non-Negotiable** - 100% compliance ensures quality
3. **Test First** - Automated tests enable confident refactoring
4. **Prioritize Quality** - Better to deliver fewer features with high quality
5. **Continuous Improvement** - Sprint retrospectives drive real change

---

## Future Enhancements

If continuing development:

- [ ] Story 7: Tag Notes
- [ ] Cloud deployment (AWS/Heroku)
- [ ] Swagger/OpenAPI documentation
- [ ] Search functionality
- [ ] Note sharing between users
- [ ] Pagination for large datasets
- [ ] Structured logging (ELK stack)
- [ ] Performance testing
- [ ] Database migrations (Flyway)
- [ ] API versioning

---

## Database Access

H2 Console: `http://localhost:8080/h2-console`

**Connection Settings:**
- JDBC URL: `jdbc:h2:mem:notesdb`
- Username: `sa`
- Password: (leave empty)

---

## Support

For issues or questions:
1. Check API documentation in README
2. Review test cases for examples
3. Check Sprint Review documents for evidence

---

## License

Educational project demonstrating Agile and DevOps practices.
