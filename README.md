# 🎓 Student Management System

A secure **Student Management REST API** built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **BCrypt Password Encryption**, and **MySQL**.

This project demonstrates a complete backend application with secure authentication, authorization-ready architecture, and CRUD operations for managing students.

---

## 🚀 Features

### Student Management
- ✅ Add Student
- ✅ View All Students
- ✅ View Student by ID
- ✅ Update Student
- ✅ Delete Student

### Authentication & Security
- ✅ User Registration
- ✅ User Login
- ✅ JWT Token Authentication
- ✅ BCrypt Password Encryption
- ✅ Protected REST APIs
- ✅ Spring Security Integration

### Database
- ✅ MySQL Integration
- ✅ Spring Data JPA
- ✅ Hibernate ORM

---

## 🛠 Tech Stack

| Technology | Used |
|------------|------|
| Java | 21 |
| Spring Boot | 4 |
| Spring Security | ✔ |
| Spring Data JPA | ✔ |
| Hibernate | ✔ |
| JWT | ✔ |
| BCrypt | ✔ |
| MySQL | ✔ |
| Maven | ✔ |
| REST API | ✔ |

---

## 📂 Project Structure

```
src
 ├── config
 ├── controller
 ├── dto
 ├── exception
 ├── model
 ├── repository
 ├── security
 ├── service
 └── resources
```

---

## 🔑 API Endpoints

### Authentication

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/register` | Register a new user |
| POST | `/login` | Login and receive JWT |

---

### Students

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get student by ID |
| POST | `/students` | Add student |
| PUT | `/students/{id}` | Update student |
| DELETE | `/students/{id}` | Delete student |

---

## 🔐 Authentication

After successful login, the API returns a JWT token.

Example:

```
Authorization: Bearer YOUR_JWT_TOKEN
```

All protected endpoints require this header.

---

## 🗄 Database

MySQL is used as the backend database.

Tables:

- Users
- Students

Passwords are securely stored using **BCrypt hashing**.

---

## ▶️ Running the Project

Clone the repository

```bash
git clone https://github.com/sanjeevr03/studentmanagement.git
```

Navigate into the project

```bash
cd studentmanagement
```

Configure your MySQL database in:

```
src/main/resources/application.properties
```

Run the project

```bash
mvn spring-boot:run
```

---

## 📌 Future Improvements

- Role-Based Authorization (ADMIN / USER)
- React Frontend
- Swagger/OpenAPI Documentation
- Docker Support
- Deployment to Cloud
- Unit Testing
- Refresh Tokens
- Pagination & Sorting

---

## 👨‍💻 Author

**Sanjeev R**

GitHub:

https://github.com/sanjeevr03

---

## ⭐ If you like this project

Please consider giving this repository a ⭐ on GitHub.
