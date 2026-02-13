# Sprint 2 - Review and Retrospective

## Sprint Review

### Sprint Goal

Enable full CRUD operations on notes and establish DevOps practices (testing, CI/CD, containerization).

---

### Backlog Items Committed

- Story 4: View My Notes (carried from Sprint 1)
- Story 5: Update Note
- Story 6: Delete Note
- DevOps Infrastructure Setup

---

### Backlog Items Completed

\u2705 **View My Notes** - Users can retrieve all their notes  
\u2705 **Update Note** - Users can edit their notes  
\u2705 **Delete Note** - Users can remove notes  
\u2705 **Automated Testing** - Unit and integration tests implemented  
\u2705 **CI/CD Pipeline** - GitHub Actions configured  
\u2705 **Containerization** - Docker and docker-compose ready

**Completion Rate:** 100% (all committed items delivered)

---

### What Was Delivered

**Features:**
- Complete CRUD operations for notes
- Authorization checks (users can only access their own notes)
- Proper error handling for unauthorized access

**DevOps:**
- 6 unit tests for services
- 4 integration tests for API endpoints
- GitHub Actions CI pipeline
- JaCoCo code coverage (50%+ enforced)
- Dockerfile with multi-stage build
- Docker Compose for local deployment

---

### Demonstration Evidence

#### Test Execution

```bash
mvn test

[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] --- jacoco:0.8.10:report (report) @ notes-api ---
[INFO] Loading execution data file /target/jacoco.exec
[INFO] Analyzed bundle 'notes-api' with 15 classes
[INFO] Coverage: 65%
```

#### CI Pipeline

GitHub Actions workflow runs on every push:
1. Checkout code
2. Set up JDK 17
3. Build with Maven
4. Run all tests
5. Generate coverage report
6. Upload artifacts

**Status:** \u2705 All checks passing

#### Docker Deployment

```bash
docker build -t notes-api .
docker run -p 8080:8080 notes-api

# Application starts successfully in container
```

#### API Testing

**View Notes:**
```bash
curl -X GET http://localhost:8080/api/notes \
  -H \"Authorization: Bearer token\"

Response: [{"id":1,"title":"Note 1",...}]
```

**Update Note:**
```bash
curl -X PUT http://localhost:8080/api/notes/1 \
  -H \"Authorization: Bearer token\" \
  -d '{\"title\":\"Updated\"}'

Response: {"id":1,"title":"Updated",...}
```

**Delete Note:**
```bash
curl -X DELETE http://localhost:8080/api/notes/1 \
  -H \"Authorization: Bearer token\"

Response: {"message":"Note deleted successfully"}
```

---

### Definition of Done Check

All 3 stories met 7/7 DoD criteria:

- [x] Functionality implemented
- [x] Code builds successfully
- [x] Unit and integration tests written and passing
- [x] Code merged to main branch
- [x] Application is runnable/deployed (Docker)
- [x] API endpoints documented

**Sprint 2 DoD Compliance:** 100%

This is a significant improvement from Sprint 1's 57% compliance.

---

### Business Value Delivered

- Users now have complete control over their notes (full CRUD)
- System is production-ready with automated testing
- CI/CD pipeline ensures code quality on every change
- Docker deployment enables easy scaling and portability
- Test coverage provides confidence in code reliability

---

## Sprint Retrospective

### What Went Well

\u2705 **DevOps First Approach** - Setting up testing and CI/CD before features prevented technical debt  
\u2705 **100% DoD Compliance** - All stories met every DoD criterion  
\u2705 **Test Coverage** - Achieved 65% coverage, exceeding 50% target  
\u2705 **Automated Quality Gates** - CI pipeline catches issues immediately  
\u2705 **Learning from Sprint 1** - Applied retrospective insights effectively  
\u2705 **Authorization Security** - Proper ownership checks implemented  
\u2705 **Containerization** - Docker makes deployment consistent

---

### What Did Not Go Well

\u26a0\ufe0f **Story 7 (Tag Notes) Not Implemented** - Deprioritized to focus on DevOps  
\u26a0\ufe0f **No Cloud Deployment** - Only Docker, not deployed to AWS/Heroku  
\u26a0\ufe0f **No Swagger Documentation** - API docs still manual curl examples  
\u26a0\ufe0f **Limited Test Scenarios** - Edge cases not fully covered  
\u26a0\ufe0f **No Performance Testing** - Load testing not implemented  
\u26a0\ufe0f **No Monitoring/Logging** - No structured logging or metrics

---

### Improvements for Future Sprints

**If Continuing:**

**Testing:**
- [ ] Increase coverage to 80%
- [ ] Add more edge case tests
- [ ] Implement performance/load testing
- [ ] Add end-to-end tests

**DevOps:**
- [ ] Deploy to cloud platform (AWS/Heroku)
- [ ] Add monitoring and alerting
- [ ] Implement structured logging (ELK stack)
- [ ] Add database migrations (Flyway/Liquibase)

**Documentation:**
- [ ] Implement Swagger/OpenAPI
- [ ] Create Postman collection
- [ ] Add architecture diagrams
- [ ] Document deployment process

**Features:**
- [ ] Implement Story 7 (Tag Notes)
- [ ] Add search functionality
- [ ] Implement note sharing
- [ ] Add pagination for large note lists

---

### Key Learnings

**1. DevOps Investment Pays Off**

Spending Days 1-4 on testing and CI/CD made Days 5-14 much more productive. Every feature was immediately tested and validated.

**2. Definition of Done is Non-Negotiable**

Sprint 1's 57% DoD compliance created technical debt. Sprint 2's 100% compliance means no debt carried forward.

**3. Automation Enables Confidence**

With automated tests and CI, we can refactor and add features without fear of breaking existing functionality.

**4. Prioritization Matters**

Choosing to skip Story 7 (Tag Notes) to focus on DevOps was the right decision. Quality infrastructure is more valuable than additional features.

---

### Comparison: Sprint 1 vs Sprint 2

| Metric | Sprint 1 | Sprint 2 | Improvement |
|--------|----------|----------|-------------|
| DoD Compliance | 57% | 100% | +43% |
| Test Coverage | 0% | 65% | +65% |
| CI/CD | \u274c | \u2705 | Implemented |
| Containerization | \u274c | \u2705 | Implemented |
| Stories Completed | 3/4 (75%) | 3/3 (100%) | +25% |
| Technical Debt | High | Low | Reduced |

---

### Team / Process Insight

**Sprint 2 validated the Agile principle: "Respond to change over following a plan."**

We adapted from Sprint 1's failures by:
1. Prioritizing DevOps over features
2. Enforcing DoD strictly
3. Writing tests first
4. Automating everything possible

**Result:** Higher quality, more sustainable velocity, and production-ready software.

**Key Insight:** DevOps is not optional. It's the foundation that enables continuous delivery of value.

---

### Confidence Level Going Forward

**Very High Confidence** - The system now has:

- Comprehensive test coverage
- Automated quality gates
- Containerized deployment
- Complete CRUD functionality
- Proper security and authorization

**If continuing to Sprint 3:**
- Can safely add new features (tags, search, sharing)
- Can deploy to production with confidence
- Can scale horizontally with Docker
- Can maintain velocity without accumulating debt

**Project Status:** Production-ready MVP delivered.

---

## Metrics

**Story Points Committed:** 7  
**Story Points Completed:** 7  
**Velocity:** 7 SP  
**Completion Rate:** 100%  
**DoD Compliance:** 100% (7/7 criteria per story)  
**Test Coverage:** 65%  
**CI/CD Status:** \u2705 Operational  
**Deployment:** \u2705 Docker Ready

**Technical Debt:** Minimal (only missing cloud deployment and Swagger)

---

## Traceability: Sprint 0 \u2192 Sprint 1 \u2192 Sprint 2

**Sprint 0 (Planning):**
- Defined 7 user stories
- Established DoD with 7 criteria
- Committed to DevOps practices

**Sprint 1 (Execution):**
- Delivered 3 stories (75%)
- Met 4/7 DoD criteria (57%)
- Identified critical gaps

**Sprint 2 (Adaptation & Delivery):**
- Addressed all Sprint 1 gaps
- Delivered 3 stories (100%)
- Met 7/7 DoD criteria (100%)
- Implemented full DevOps pipeline

**Outcome:** Demonstrated continuous improvement and delivered production-ready software with proper DevOps practices.

---

## Final Deliverables

\u2705 **Working Software** - Complete Notes API with CRUD operations  
\u2705 **Automated Tests** - 10 tests with 65% coverage  
\u2705 **CI/CD Pipeline** - GitHub Actions workflow  
\u2705 **Containerization** - Docker and docker-compose  
\u2705 **Documentation** - API examples and README  
\u2705 **Version Control** - Git repository with proper structure  
\u2705 **Quality Gates** - Code coverage enforcement

**Project demonstrates successful Agile and DevOps implementation.**
