# Git Playground Project for DevOps

## DevOps Roadmap
### Phase 1: Foundation (Collaboration, version control, and simple automation)
- [x] Git basics: init, clone, branches, commits, push/pull
- [x] Conflict resolution (merge vs rebase)
- [x] Commit hygiene (good messages, small changes)
- [x] GitHub remote repo usage
- [x] Branch protection + PR workflow
- [x] First GitHub Actions workflow (build + test on merge to main)

### Phase 2: CI/CD Mastery (Automating builds, tests, deployments)
- [ ] Expand GitHub Actions workflows:
    - [ ] Multi-job (Ubuntu, Mac, Windows)
    - [x] Build artifacts (e.g. compiled app)
    - [x] Run unit tests (C, Python, etc.)
- [x] Learn Jenkins basics.
- [ ] Learn common CI/CD patterns: 
    - [x] pipelines 
    - [ ] approvals
    - [ ] environments.
- [ ] Practice deployment workflow: build Docker image → push to Docker Hub → deploy to server/container.

## Phase 3: Containers & Orchestration (Docker + Kubernetes basics)
- [ ] Write Dockerfiles (package apps).
- [ ] Run apps locally with Docker (docker run, docker ps, docker exec).
- [ ] Use Docker Compose for multi-service apps.
- [ ] Kubernetes basics (pods, deployments, services, kubectl).
- [ ] Mini project: deploy your C program in Docker, then to Kubernetes cluster (e.g. with Minikube).

### Phase 4: Infrastructure as Code (IaC) (Provisioning + config management)
- [ ] Terraform basics.
- [ ] Write Terraform scripts for simple infra (e.g. EC2 + S3 on AWS).
- [ ] Learn Ansible basics (agentless configuration management).
- [ ] Combine Terraform (infra) + Ansible (config).

### Phase 5: Cloud Fundamentals [Cloud platforms (AWS/GCP/Azure)]
- [ ] Learn basic services: compute (EC2/VM), storage (S3/Bucket), networking (VPC).
- [ ] Deploy your Docker app to AWS/GCP/Azure.
- [ ] Try managed Kubernetes (EKS/GKE/AKS).
- [ ] Use IAM (Identity & Access Management) for permissions.

### Phase 6: Monitoring & Observability (Keeping apps healthy)
- [ ] Prometheus basics (metrics scraping).
- [ ] Grafana dashboards (visualization).
- [ ] ELK Stack for logs.
- [ ] Set up alerts (email/Slack on failure).

### Phase 7: Security & DevSecOps (Shift-left security)
- [ ] Secrets management (Kubernetes Secrets, HashiCorp Vault).
- [ ] Add security scans to CI/CD (Snyk, Trivy, Aqua Security).
- [ ] RBAC (Role-Based Access Control) in Kubernetes / cloud.
- [ ] Secure branching (pre-commit hooks, code scanning).

### Phase 8: Deployment Strategies & Advanced Topics (Real-world deployment methods)
- [ ] Blue/Green and Canary deployments.
- [ ] GitOps with ArgoCD or Flux.
- [ ] Immutable infrastructure patterns.
- [ ] Scaling & cost optimization.


## INFO
Folder **legacy-experiments** contains my initial CI/CD experiments with a simple C program I used to cover topic from Phase 1-2 (Git branching, GitHub Actions, Jenkins pipelines). 
