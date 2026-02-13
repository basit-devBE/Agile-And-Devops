# Sprint 0 - Project Plan

## Product Vision

Build a secure API that allows users to create, manage, and organize personal notes so they can store information reliably and access it anytime.

---

## Product Backlog

**Total Story Points:** 19

---

### Story 1 – User Registration

**As a** new user  
**I want to** create an account  
**So that** I can store my notes securely.

**Acceptance Criteria:**
- Email must be unique
- Password required
- User saved in database
- Success response returned

**Priority:** High  
**Estimate:** 3 SP  
**Sprint:** 1

---

### Story 2 – User Login

**As a** user  
**I want to** log in  
**So that** I can access my notes.

**Acceptance Criteria:**
- Credentials validated
- Token/session returned
- Invalid login rejected

**Priority:** High  
**Estimate:** 3 SP  
**Sprint:** 1

---

### Story 3 – Create Note

**As a** logged-in user  
**I want to** create a note  
**So that** I can save information.

**Acceptance Criteria:**
- Authentication required
- Title or content required
- Note linked to owner
- Created note returned

**Priority:** High  
**Estimate:** 3 SP  
**Sprint:** 1

---

### Story 4 – View My Notes

**As a** logged-in user  
**I want to** fetch my notes  
**So that** I can read them.

**Acceptance Criteria:**
- Authentication required
- Only owner notes returned
- JSON response

**Priority:** High  
**Estimate:** 2 SP  
**Sprint:** 1

---

### Story 5 – Update Note

**As a** logged-in user  
**I want to** edit a note  
**So that** I can correct or improve it.

**Acceptance Criteria:**
- Authentication required
- Must own note
- Updated data saved

**Priority:** Medium  
**Estimate:** 3 SP  
**Sprint:** 2

---

### Story 6 – Delete Note

**As a** logged-in user  
**I want to** remove a note  
**So that** I can discard it.

**Acceptance Criteria:**
- Authentication required
- Must own note
- Deletion confirmed

**Priority:** Medium  
**Estimate:** 2 SP  
**Sprint:** 2

---

### Story 7 – Tag Notes

**As a** user  
**I want to** categorize notes  
**So that** I can find them easily.

**Acceptance Criteria:**
- Tags can be added
- Appear when fetching

**Priority:** Low  
**Estimate:** 3 SP  
**Sprint:** 2

---

## Definition of Done

A story is considered complete when:

- [ ] Functionality implemented
- [ ] Code builds successfully
- [ ] Unit and integration tests written and passing
- [ ] Code merged to main branch
- [ ] Application is runnable/deployed
- [ ] API endpoints documented

---

## Team Capacity & Velocity

**Team Size:** TBD  
**Estimated Velocity:** 10-12 SP per sprint  
**Sprint 1 Commitment:** 11 SP  
**Sprint 2 Commitment:** 8 SP

---

## Release Plan

**Release 1.0** - End of Sprint 2
- Complete user authentication
- Full CRUD operations for notes
- Basic tagging functionality
- API documentation