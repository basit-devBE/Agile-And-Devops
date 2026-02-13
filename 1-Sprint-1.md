# Sprint 1 - Core Functionality

**Sprint Goal:** Deliver the first working slice of the system with authentication and note creation.

**Sprint Duration:** 2 weeks  
**Story Points Committed:** 11

---

## Features Delivered

✅ **User Registration** - Users can create accounts with unique emails  
✅ **User Login** - Users receive JWT tokens for authentication  
✅ **Create Note** - Authenticated users can create notes

---

## User Stories

### Story 1 – User Registration

**As a** new user  
**I want to** create an account  
**So that** I can store my notes securely.

**Acceptance Criteria:**
- [x] Email must be unique
- [x] Password required
- [x] User saved in database
- [x] Success response returned

**Priority:** High  
**Estimate:** 3 SP  
**Status:** ✅ DONE

---

### Story 2 – User Login

**As a** user  
**I want to** log in  
**So that** I can access my notes.

**Acceptance Criteria:**
- [x] Credentials validated
- [x] Token/session returned
- [x] Invalid login rejected

**Priority:** High  
**Estimate:** 3 SP  
**Status:** ✅ DONE

---

### Story 3 – Create Note

**As a** logged-in user  
**I want to** create a note  
**So that** I can save information.

**Acceptance Criteria:**
- [x] Authentication required
- [x] Title or content required
- [x] Note linked to owner
- [x] Created note returned

**Priority:** High  
**Estimate:** 3 SP  
**Status:** ✅ DONE

---

## API Evidence

### 1. Register User

**Request:**
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"email":"user@example.com","password":"password123"}'
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "email": "user@example.com"
}
```

---

### 2. Login User

**Request:**
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"user@example.com","password":"password123"}'
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "email": "user@example.com"
}
```

---

### 3. Create Note

**Request:**
```bash
curl -X POST http://localhost:8080/api/notes \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{"title":"My First Note","content":"This is the content"}'
```

**Response:**
```json
{
  "id": 1,
  "title": "My First Note",
  "content": "This is the content",
  "ownerEmail": "user@example.com"
}
```

---

## Technical Implementation

**Technology Stack:**
- Spring Boot 3.2.0
- Spring Security with JWT
- Spring Data JPA
- H2 Database (in-memory)
- Maven

**Project Structure:**
```
notes-api/
├── src/main/java/com/notes/api/
│   ├── controller/     # REST endpoints
│   ├── service/        # Business logic
│   ├── repository/     # Data access
│   ├── model/          # Entities
│   ├── dto/            # Request/Response objects
│   ├── security/       # JWT utilities
│   └── config/         # Security config
├── pom.xml
└── README.md
```

---

## Build & Run

```bash
cd notes-api
mvn clean install
mvn spring-boot:run
```

Application runs on: `http://localhost:8080`

---

## Definition of Done

- [x] Functionality implemented
- [x] Code builds successfully
- [x] API endpoints documented with curl examples
- [x] Application is runnable
- [ ] Unit and integration tests written and passing
- [ ] Code merged to main branch
- [ ] Deployed to environment

---

## DevOps Evidence

✅ **Working Software** - Application builds and runs  
✅ **API Documentation** - curl commands provided  
✅ **Version Control Ready** - .gitignore configured  
⏳ **CI/CD Pipeline** - To be added  
⏳ **Automated Tests** - To be added  
⏳ **Deployment** - To be added
