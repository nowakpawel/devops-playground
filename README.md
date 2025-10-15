# DevOps Playground

A hands-on project documenting my journey from DevOps beginner to job-ready engineer.

## 🎯 Current Status

**Phase 1:** ✅ 100% Complete  
**Phase 2:** ✅ 90% Complete  
**Phase 3:** 🚧 In Progress

---

## 📦 What's Built

### Application
- **Spring Boot REST API** with PostgreSQL
  - Task management CRUD operations
  - Basic authentication (Spring Security)
  - Health check endpoints (Actuator)
  - Flyway database migrations
  - Seed data for development

### CI/CD Pipeline
- **GitHub Actions** (3 workflows)
  - `ci.yml` - Runs tests on all branches with H2 in-memory database
  - `deploy-dev.yml` - Builds and pushes Docker images to Docker Hub (dev environment)
  - `deploy-prod.yml` - Builds and pushes Docker images to Docker Hub (prod environment)
  
- **Jenkins** (Multibranch Pipeline)
  - Automatic branch discovery
  - Docker-in-Docker build environment
  - Artifact archiving on main branch
  - Maven caching for faster builds

### Docker
- **Multi-stage Dockerfile** (builder + runtime)
  - Stage 1: Maven build (compiles JAR)
  - Stage 2: Minimal JRE runtime (~200MB final image)
  - Non-root user for security
  
- **Docker Compose**
  - Local development: PostgreSQL + Adminer
  - Jenkins infrastructure: Custom Jenkins with Docker access

### Images on Docker Hub
- [`nowakpawel/task-manager:dev-latest`](https://hub.docker.com/r/nowakpawel/task-manager)
- [`nowakpawel/task-manager:prod-latest`](https://hub.docker.com/r/nowakpawel/task-manager)
- Versioned with commit SHAs for traceability

---

## 🔄 Git Workflow
```
feature/xyz
    ↓ push
  CI runs (tests)
    ↓ PR to dev
  CI runs (tests)
    ↓ merge
   dev
    ↓ triggers
  CI + Docker build → Docker Hub (dev-latest)
    ↓ PR to main
  CI runs (tests)
    ↓ merge
   main (protected)
    ↓ triggers
  CI + Docker build → Docker Hub (prod-latest)
```

**Branch Protection:**
- `main` branch requires PR reviews
- All PRs must pass CI checks before merge
- Direct pushes to main blocked

---

## 🚀 Quick Start

### Run Locally
```bash
# Start PostgreSQL
cd backend
docker-compose up -d

# Run application
mvn spring-boot:run

# Access
curl http://localhost:8080/actuator/health
```

### Run with Docker
```bash
# Pull from Docker Hub
docker pull nowakpawel/task-manager:prod-latest

# Run (requires PostgreSQL)
docker run -p 8080:8080 \
  -e DB_URL=jdbc:postgresql://host.docker.internal:5432/taskmanager \
  -e DB_USERNAME=postgres \
  -e DB_PASSWORD=postgres \
  nowakpawel/task-manager:prod-latest
```

### Run Jenkins Locally
```bash
docker-compose -f docker-compose.jenkins.yml up -d
# Access: http://localhost:8080
```

---

## ✅ Completed Roadmap

### Phase 1: Version Control + Basic CI/CD ✅ 100%
- [x] Git basics: init, clone, branches, commits, push/pull
- [x] Conflict resolution (merge vs rebase)
- [x] Commit hygiene (descriptive messages, atomic commits)
- [x] GitHub remote repo usage
- [x] Branch protection + PR workflow
- [x] First GitHub Actions workflow (build + test on merge to main)

### Phase 2: CI/CD Refinement ✅ 90%
- [x] Expand GitHub Actions workflows (multi-environment)
- [x] Build artifacts (JAR files uploaded)
- [x] Run unit tests (Spring Boot with H2)
- [x] Jenkins multibranch pipeline
- [x] CI/CD patterns: pipelines, approvals, environments
- [x] Build Docker image → push to Docker Hub
- [ ] Multi-OS builds (Ubuntu, Mac, Windows) - *not critical*
- [ ] Deploy to actual server - **NEXT MILESTONE**

### Phase 3: Docker & Container Orchestration ⏳ 60%
- [x] Write Dockerfiles (multi-stage builds)
- [x] Run apps locally with Docker
- [x] Docker Compose for multi-service apps
- [ ] Kubernetes basics (pods, deployments, services)
- [ ] Deploy to Kubernetes cluster (Minikube)

---

## 📁 Project Structure
```
devops-playground/
├── .github/
│   └── workflows/          # GitHub Actions CI/CD
│       ├── ci.yml
│       ├── deploy-dev.yml
│       └── deploy-prod.yml
├── backend/
│   ├── src/
│   │   ├── main/java/      # Spring Boot application
│   │   ├── main/resources/ # Config + database migrations
│   │   └── test/           # Unit tests (H2)
│   ├── Dockerfile          # Application image
│   ├── docker-compose.yml  # Local PostgreSQL
│   └── pom.xml
├── legacy-experiments/     # Week 1: C program experiments
├── Dockerfile              # Jenkins custom image
├── docker-compose.jenkins.yml
├── Jenkinsfile             # Jenkins pipeline
└── README.md
```

---

## 🎓 Key Learnings

### Technical Decisions
1. **Separate test configuration** (H2) vs production (PostgreSQL)
   - Why: Tests run in 30 seconds instead of 5 minutes
   - Tradeoff: Not testing against real database

2. **Multi-stage Docker builds**
   - Why: Final image is 70% smaller (no Maven, no source code)
   - Security: Production image doesn't contain build tools

3. **Docker-in-Docker for Jenkins**
   - Why: Build containers inside Jenkins container
   - Challenge: Docker socket permissions required

4. **Branch-specific Maven goals**
   - `mvn verify` on dev (thorough testing)
   - `mvn package` on main (create JAR for deployment)

### Common Issues Solved
- PostgreSQL connection errors → Test profile configuration
- Docker Hub authentication → Token scopes and secret management
- YAML syntax errors → Proper indentation (2 spaces!)
- Git conflicts → Proper branch syncing before PRs

---

## 🔜 What's Next

1. **Complete Phase 2:** Deploy to real server (DigitalOcean/AWS)
2. **Phase 3:** Kubernetes fundamentals with Minikube
3. **Phase 4:** Terraform for infrastructure as code
4. **Phase 5:** Monitoring with Prometheus + Grafana

---

## 📚 Resources Used

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Docker Best Practices](https://docs.docker.com/develop/dev-best-practices/)
- [GitHub Actions Documentation](https://docs.github.com/en/actions)
- [Jenkins Pipeline Syntax](https://www.jenkins.io/doc/book/pipeline/syntax/)

---

## 🤝 Contributing

This is a personal learning project, but feel free to:
- Open issues with suggestions
- Share your own DevOps learning journey
- Fork and adapt for your own learning

---

## 📄 License

MIT License - Feel free to use this for your own learning.

---

**Last Updated:** October 13, 2025  
**Current Focus:** Kubernetes deployment