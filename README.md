# E-Commerce CI/CD Sample Project (Spring Boot)

This repository is a minimal, presentable end-to-end project that demonstrates:
- Spring Boot backend (Maven)
- Unit tests (JUnit)
- Postman collection for API tests
- Cypress skeleton for UI tests
- Dockerfile and docker-compose
- GitHub Actions CI workflow

## Quick start (locally)
Requirements: JDK 17, Maven, Docker (optional)

1. Build & test:
```bash
cd backend
mvn clean verify
```

2. Run application:
```bash
cd backend
mvn spring-boot:run
# app on http://localhost:8080
```

3. Build docker:
```bash
docker build -t ecommerce-local .
docker run -p 8080:8080 ecommerce-local
```

## Tests
- Unit tests are in `backend/src/test`.
- API tests: `tests/api-tests.postman_collection.json` (use Postman or Newman).
- Cypress UI tests: skeleton in `tests/cypress`.

## CI
The GitHub Actions workflow is at `.github/workflows/ci-cd.yml`.

