# Sprint 1 - Review and Retrospective

## Sprint Review

### Sprint Goal

Deliver the initial version of the Personal Notes API with authentication and the ability for users to create notes.

---

### Backlog Items Committed

- User Registration
- User Login
- Create Note

---

### Backlog Items Completed

✅ **User Registration** - Users can create accounts with unique email validation  
✅ **User Login** - Users receive JWT tokens for authentication  
✅ **Create Note** - Authenticated users can create notes linked to their account

**Completion Rate:** 3/3 stories (100%)

---

### What Was Delivered

At the end of this sprint, users can:

- Create an account with email and password
- Log in and receive JWT authentication token
- Create personal notes linked to their account
- Receive proper validation errors for invalid inputs

The application is functional, runnable, and ready for testing.

---

### Demonstration Evidence

#### 1. User Registration

**Request:**
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"email":"user@example.com","password":"password123"}'
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQGV4YW1wbGUuY29tIiwiaWF0IjoxNzM5NDQ2ODAwLCJleHAiOjE3Mzk1MzMyMDB9...",
  "email": "user@example.com"
}
```

**Validation Error Example:**
```json
{
  "status": "error",
  "errors": {
    "email": "Email must be valid"
  }
}
```

---

#### 2. User Login

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

#### 3. Create Note

**Request:**
```bash
curl -X POST http://localhost:8080/api/notes \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9..." \
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

#### 4. Database Verification

H2 Console accessible at: `http://localhost:8080/h2-console`

**Users Table:**
```sql
SELECT * FROM USERS;
-- Shows registered users with encrypted passwords
```

**Notes Table:**
```sql
SELECT * FROM NOTES;
-- Shows notes linked to user_id
```

---

### Technical Achievements

✅ **Project Structure** - Spring Boot application with proper layered architecture  
✅ **Version Control** - Git repository with .gitignore configured  
✅ **REST API** - Three functional endpoints (register, login, create note)  
✅ **Authentication** - JWT-based security implementation  
✅ **Validation** - Bean validation with proper error handling  
✅ **Database** - JPA entities with H2 in-memory database  
✅ **Security** - Password encryption using BCrypt  
✅ **Error Handling** - Global exception handler for consistent responses  
✅ **Build Tool** - Maven configuration with all dependencies

---

### Business Value Delivered

- Users can now securely store personal information
- Authentication ensures data privacy and ownership
- Foundation established for future features (view, edit, delete, tag notes)
- API is ready for frontend integration
- System demonstrates core functionality required for MVP

---

### Definition of Done Check

As defined in Sprint 0, each story must meet the following criteria:

#### Story 1: User Registration

- [x] **Functionality implemented** - Registration endpoint working
- [x] **Code builds successfully** - `mvn clean install` passes
- [x] **API endpoints documented** - curl examples provided in README
- [x] **Application is runnable** - Starts on port 8080
- [ ] **Unit and integration tests written and passing** - Not completed
- [ ] **Code merged to main branch** - Not completed
- [ ] **Deployed to environment** - Not completed

**DoD Status:** 4/7 criteria met (57%)

#### Story 2: User Login

- [x] **Functionality implemented** - Login endpoint with JWT working
- [x] **Code builds successfully** - `mvn clean install` passes
- [x] **API endpoints documented** - curl examples provided in README
- [x] **Application is runnable** - Starts on port 8080
- [ ] **Unit and integration tests written and passing** - Not completed
- [ ] **Code merged to main branch** - Not completed
- [ ] **Deployed to environment** - Not completed

**DoD Status:** 4/7 criteria met (57%)

#### Story 3: Create Note

- [x] **Functionality implemented** - Create note endpoint working
- [x] **Code builds successfully** - `mvn clean install` passes
- [x] **API endpoints documented** - curl examples provided in README
- [x] **Application is runnable** - Starts on port 8080
- [ ] **Unit and integration tests written and passing** - Not completed
- [ ] **Code merged to main branch** - Not completed
- [ ] **Deployed to environment** - Not completed

**DoD Status:** 4/7 criteria met (57%)

---

**Overall Sprint 1 DoD Compliance:** 57%

**Critical Gap:** Testing, version control workflow, and deployment were not completed. These are essential DevOps practices that must be addressed in Sprint 2.

---

## Sprint Retrospective

### What Went Well

✅ **Clear Acceptance Criteria** - Each story had well-defined acceptance criteria that guided implementation  
✅ **Focused Scope** - Limited to 3 core stories prevented scope creep  
✅ **Working Software** - Delivered functional, testable endpoints  
✅ **Validation Implementation** - Proper input validation prevents bad data  
✅ **Error Handling** - Global exception handler provides consistent error responses  
✅ **Documentation** - API endpoints documented with curl examples

---

### What Did Not Go Well

❌ **No Automated Tests** - Unit and integration tests were not written  
❌ **No CI/CD Pipeline** - No automated build or deployment process  
❌ **Late Validation** - Input validation added after initial implementation  
❌ **No Code Review Process** - All code committed directly without review  
❌ **Missing Story** - "View My Notes" was planned but not implemented  
❌ **No Deployment** - Application only runs locally  
❌ **Large Commits** - Initial commit contained entire application structure

---

### Improvements for Sprint 2

**Critical Actions Based on DoD Gaps:**

Because automated testing was missing in Sprint 1, **Sprint 2 will begin by implementing the test framework before adding new features**. This ensures we don't accumulate more technical debt.

Because CI/CD pipeline was not established, **the first task in Sprint 2 will be setting up GitHub Actions** to automate builds and tests on every commit.

Because deployment was not completed, **Sprint 2 will include containerization (Docker) and deployment to a cloud platform** as part of the DoD.

---

**Testing:**
- [ ] **Priority 1:** Set up JUnit and Mockito framework
- [ ] Write unit tests for AuthService and NoteService
- [ ] Add integration tests for all API endpoints
- [ ] Achieve minimum 70% code coverage
- [ ] Adopt TDD approach for new features

**DevOps:**
- [ ] **Priority 1:** Set up GitHub Actions CI pipeline
- [ ] Automate build execution on push/PR
- [ ] Automate test execution in pipeline
- [ ] Add code quality checks (Checkstyle/SpotBugs)
- [ ] Create Dockerfile for containerization
- [ ] Deploy to AWS/Heroku with automated deployment

**Development Process:**
- [ ] Initialize Git repository and push to GitHub
- [ ] Create feature branches for each story (feature/update-note, feature/delete-note)
- [ ] Make smaller, incremental commits with meaningful messages
- [ ] Implement pull request workflow
- [ ] Add Swagger/OpenAPI documentation
- [ ] Implement structured logging (SLF4J)

**Code Quality:**
- [ ] Add comprehensive error messages
- [ ] Implement request/response logging
- [ ] Add API versioning (/api/v1/...)
- [ ] Create Postman collection for manual testing
- [ ] Add health check endpoint

---

**Sprint 2 Commitment:**

Before implementing Update Note, Delete Note, and Tag Notes features, we will:

1. Set up CI/CD pipeline (Day 1-2)
2. Write tests for existing Sprint 1 code (Day 3-4)
3. Set up deployment infrastructure (Day 5-6)
4. Then proceed with new features (Day 7-14)

This approach ensures we practice true DevOps from Sprint 2 onwards.

---

### Team / Process Insight

This sprint highlighted the importance of:

- **Planning small deliverables** - Breaking down stories into manageable tasks helped maintain focus
- **Validation early** - Adding validation from the start would have prevented rework
- **DevOps from day one** - CI/CD should be set up at project initialization, not as an afterthought
- **Test-driven development** - Writing tests alongside code ensures reliability
- **Continuous validation** - Testing endpoints immediately after implementation catches issues early

The sprint successfully delivered working software, but the lack of automated testing and CI/CD pipeline means we're not truly practicing DevOps yet. Sprint 2 must prioritize these practices.

**Key Lesson:** The Definition of Done should be non-negotiable. Skipping tests and deployment in Sprint 1 created technical debt that must be addressed before Sprint 2 features. This demonstrates why DoD exists - to prevent accumulating shortcuts that compromise quality.

**Adaptation for Sprint 2:** Based on this learning, Sprint 2 will not consider any story "done" unless all 7 DoD criteria are met, even if it means completing fewer stories. Quality over quantity.

---

### Confidence Level Going Forward

**High Confidence** - The authentication and core structure are in place, which are typically the most complex parts. With this foundation:

- Sprint 2 can focus on CRUD completion (Update, Delete, View)
- Adding tests to existing code is straightforward
- CI/CD pipeline can be implemented incrementally
- The architecture supports easy feature additions

**Key Success Factor:** Implementing automated testing and CI/CD in Sprint 2 will demonstrate true DevOps practices and ensure sustainable development velocity.

---

## Metrics

**Story Points Committed:** 11  
**Story Points Completed:** 9 (excluded "View My Notes")  
**Velocity:** 9 SP  
**Completion Rate:** 75% (3 of 4 stories)  
**DoD Compliance:** 57% (4 of 7 criteria met per story)

**Technical Debt Identified:**
- No automated tests (High Priority)
- No CI/CD pipeline (High Priority)
- No deployment (High Priority)
- Missing API documentation - Swagger (Medium Priority)
- No version control workflow (Medium Priority)
- No logging framework (Low Priority)

**Next Sprint Capacity:** 8-10 SP (adjusted based on adding testing overhead and DevOps setup)

---

## Traceability: Sprint 0 → Sprint 1 → Sprint 2

**Sprint 0 (Planning):**
- Defined 7 user stories
- Established Definition of Done with 7 criteria
- Committed to DevOps practices

**Sprint 1 (Execution):**
- Delivered 3 of 4 committed stories
- Met 4 of 7 DoD criteria
- Identified gaps in testing, CI/CD, and deployment

**Sprint 2 (Adaptation):**
- Will address Sprint 1 technical debt first
- Will implement CI/CD before new features
- Will enforce 100% DoD compliance
- Will reduce story commitment to ensure quality

This demonstrates continuous improvement and learning from Sprint 1 execution.
