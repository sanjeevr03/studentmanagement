# 🎓 Student Management System

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring_Security-6-green?style=for-the-badge&logo=springsecurity)
![JWT](https://img.shields.io/badge/JWT-Authentication-blue?style=for-the-badge)
![Hibernate](https://img.shields.io/badge/Hibernate-JPA-brown?style=for-the-badge&logo=hibernate)
![MySQL](https://img.shields.io/badge/MySQL-8-blue?style=for-the-badge&logo=mysql)
![Docker](https://img.shields.io/badge/Docker-Container-blue?style=for-the-badge&logo=docker)
![Swagger](https://img.shields.io/badge/Swagger-API-green?style=for-the-badge&logo=swagger)

</p>

---

## 📌 Overview

The **Student Management System** is a secure RESTful backend application developed using **Spring Boot**.

It demonstrates modern backend development practices including:

- JWT Authentication
- Spring Security
- CRUD REST APIs
- File Upload
- Docker
- Swagger Documentation
- MySQL
- H2 Database
- Environment Variables
- Pagination
- Sorting
- Search APIs

This project was built as a portfolio project to demonstrate enterprise-level backend development skills.

---

# 🚀 Features

- ✅ JWT Authentication
- ✅ User Registration & Login
- ✅ BCrypt Password Encryption
- ✅ Student CRUD Operations
- ✅ Search Students
- ✅ Pagination
- ✅ Sorting
- ✅ File Upload
- ✅ MySQL Integration
- ✅ H2 Database Support
- ✅ Swagger Documentation
- ✅ Spring Security
- ✅ Global Exception Handling
- ✅ Input Validation
- ✅ Docker Support
- ✅ Docker Compose
- ✅ Environment Variable Configuration

---

# 🏗️ Architecture

```text
                +----------------------+
                |     Client / UI      |
                +----------+-----------+
                           |
                           | REST API
                           |
                +----------v-----------+
                |   Spring Boot API    |
                +----------+-----------+
                           |
              +------------+------------+
              |                         |
      Spring Security              File Upload
              |                         |
              +------------+------------+
                           |
                     Hibernate / JPA
                           |
                      MySQL Database
```

---

# 🛠️ Tech Stack

### Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT
- Maven

### Database

- MySQL
- H2 Database

### Documentation

- Swagger / OpenAPI

### DevOps

- Docker
- Docker Compose

### Tools

- Git
- GitHub
- VS Code

---

# 📂 Project Structure

```
studentmanagement
│
├── src
│   ├── main
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── model
│   │   ├── security
│   │   ├── exception
│   │   └── resources
│   │
│   └── test
│
├── uploads
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

# 🔐 Authentication APIs

## Register

```
POST /auth/register
```

## Login

```
POST /auth/login
```

After successful login a JWT token is generated.

Use

```
Authorization: Bearer YOUR_TOKEN
```

---

# 📚 Student APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get student by ID |
| POST | `/students` | Create student |
| PUT | `/students/{id}` | Update student |
| DELETE | `/students/{id}` | Delete student |

---

# 📄 Pagination

Example

```
GET /students?page=0&size=5
```

---

# 🔍 Search

Example

```
GET /students/search?keyword=John
```

---

# ↕️ Sorting

Example

```
GET /students/sort?field=name
```

---

# 📤 File Upload

Upload student image

```
POST /students/{id}/upload
```

---

# 📖 Swagger Documentation

After running the application

```
http://localhost:8080/swagger-ui/index.html
```

---

# 🗄️ Database

Supported databases

- MySQL
- H2 Database

Database credentials are managed securely using **Environment Variables**.

---

# ⚙️ Environment Variables

Configure the following variables before running the application:

```
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
MYSQL_ROOT_PASSWORD
```

---

# ▶️ Running Locally

Clone repository

```bash
git clone https://github.com/sanjeevr03/studentmanagement.git
```

Navigate into project

```bash
cd studentmanagement
```

Run application

```bash
mvn spring-boot:run
```

Application

```
http://localhost:8080
```

Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

# 🐳 Running with Docker

Build

```bash
docker compose up --build
```

Stop

```bash
docker compose down
```

---

# 📸 Screenshots

> Add screenshots after deployment.

Example:

```
docs/
├── login.png
├── swagger.png
├── students.png
```

Then display them like:

```markdown
## Swagger UI

![Swagger](docs/swagger.png)

## Login

![Login](docs/login.png)

## Student APIs

![Students](docs/students.png)
```

---

# 📌 Future Improvements

- Role Based Authorization
- Serve Uploaded Images
- Unit Testing
- Integration Testing
- CI/CD Pipeline
- Cloud Deployment
- React Frontend

---

# 👨‍💻 Author

## Sanjeev R

**GitHub**

https://github.com/sanjeevr03

**LinkedIn**

https://www.linkedin.com/in/sanjeev010

---

# ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.
