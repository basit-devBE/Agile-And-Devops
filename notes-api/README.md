# Notes API - Sprint 1

## Features Delivered

✅ User Registration  
✅ User Login  
✅ Create Note

## Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

Application runs on: `http://localhost:8080`

## API Endpoints

### 1. Register User

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

### 2. Login User

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

### 3. Create Note

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

## Testing

Run tests:
```bash
mvn test
```

## Database

H2 in-memory database  
Console: `http://localhost:8080/h2-console`  
JDBC URL: `jdbc:h2:mem:notesdb`

## Definition of Done

- [x] Functionality implemented
- [x] Code builds successfully
- [x] API endpoints documented
- [ ] Unit tests written
- [ ] Deployed
- [ ] Merged to main
