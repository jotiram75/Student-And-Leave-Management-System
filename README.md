# 🎓 Student & Leave Management System (SLMS)

A **Java Console-Based Student & Leave Management System** developed using **Core Java, JDBC, MySQL, and Layered Architecture** with **Role-Based Access Control (RBAC)**.

The application enables administrators to manage student records and leave requests, while students can securely log in, manage their profiles, and apply for leave.

---

## ✨ Features

### 🔐 Authentication & Role-Based Access Control (RBAC)

- ✅ Secure Login System
- ✅ Username & Password Authentication
- ✅ Role-Based Access
  - 👨‍💼 Admin
  - 👨‍🎓 Student
- ✅ Session-based Dashboard

---

## 👨‍💼 Admin Module

### 📚 Student Management

- View All Students
- Add Student
- View Student by Roll Number
- Update Student Details
- Delete Student
- Search Student by Name

### 📝 Leave Management

- View All Leave Requests
- View Leave Requests by Student ID
- Approve Leave Request
- Reject Leave Request
- Delete Leave Request

### 📊 Reports

- View Topper
- View Average Marks
- View Student Count
- View Merit List

---

## 👨‍🎓 Student Module

### 📋 Student Dashboard

- View My Profile
- View Topper
- Access Leave Management

### 📝 Leave Management

- Apply Leave
- View My Leave Requests
- Cancel Leave Request

---

# 🛠️ Technologies Used

- Java 17
- JDBC
- MySQL
- Eclipse IDE
- Git
- GitHub

---

# 🏗️ Project Architecture

```text
Student & Leave Management System
│
├── Client Layer
│     ├── StudentClient
│     ├── AdminClient
│     ├── StudentDashboard
│     ├── StudentManagement
│     ├── LeaveManagement
│     └── ReportManagement
│
├── Controller Layer
│     ├── StudentController
│     └── StudentLeaveController
│
├── Service Layer
│     ├── StudentService
│     └── StudentLeaveService
│
├── DAO Layer
│     ├── StudentDao
│     └── StudentLeaveDao
│
├── Entity Layer
│     ├── Student
│     ├── StudentLeave
│     └── LoginUser (Optional)
│
├── Utility
│     └── DBUtility
│
└── MySQL Database
```

---

# 📂 Project Structure

```text
src
│
├── com.tka.client
│       AdminClient.java
│       StudentClient.java
│       StudentDashboard.java
│       StudentManagement.java
│       LeaveManagement.java
│       ReportManagement.java
│
├── com.tka.controller
│       StudentController.java
│       StudentLeaveController.java
│
├── com.tka.service
│       StudentService.java
│       StudentLeaveService.java
│
├── com.tka.dao
│       StudentDao.java
│       StudentLeaveDao.java
│
├── com.tka.entity
│       Student.java
│       StudentLeave.java
│
└── com.tka.utility
        DBUtility.java
```

---

# 🗄️ Database Design

## 📌 students

| Column | Type |
|---------|------|
| rollno | INT (PK) |
| name | VARCHAR(100) |
| marks | INT |

---

## 📌 users

| Column | Type |
|---------|------|
| username | VARCHAR(50) |
| password | VARCHAR(50) |
| role | VARCHAR(20) |
| rollno | INT |

---

## 📌 student_leave

| Column | Type |
|---------|------|
| lid | INT (PK, AUTO_INCREMENT) |
| startdate | DATE |
| enddate | DATE |
| reason | VARCHAR(255) |
| status | VARCHAR(20) |
| sid | INT (FK) |

---

# 🔗 Database Relationship

```text
students
---------
rollno (PK)

        │
        │ 1
        │
        ▼
student_leave
--------------
lid
sid (FK)
```

---

# 💻 Console Flow

## 🔐 Login

```text
===============================
Student & Leave Management System
===============================

Username :
Password :

↓

Authentication

↓

Admin Dashboard
OR
Student Dashboard
```

---

## 👨‍💼 Admin Dashboard

```text
1. Student Management
2. Leave Management
3. Reports
0. Logout
```

---

## 👨‍🎓 Student Dashboard

```text
1. My Profile
2. Leave Management
3. View Topper
0. Logout
```

---

# 🏛️ Layered Architecture

```text
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
DAO
   │
   ▼
Database
```

---

# ⚡ JDBC Operations

## Student

- Insert Student
- Update Student
- Delete Student
- Search Student
- View Student
- View All Students

## Leave

- Apply Leave
- View Leave
- Approve Leave
- Reject Leave
- Delete Leave

---

# ✅ Validation

## Student Validation

- Roll Number > 0
- Name Cannot Be Empty
- Marks Between 0–100

## Leave Validation

- Student ID Must Exist
- Reason Cannot Be Empty
- Start Date Required
- End Date Required

---

# 🔒 Security

- ✅ Role-Based Access Control (RBAC)
- ✅ Login Authentication
- ✅ PreparedStatement (Prevents SQL Injection)
- ✅ Students Can Access Only Their Own Leave Requests
- ✅ Admin Has Full Access

---

# 🚀 Future Enhancements

- 🔐 Password Encryption (BCrypt)
- 📧 Email Notifications
- 📜 Leave History
- 📋 Leave Approval Logs
- 📄 Export Reports to PDF
- 📊 Export Reports to Excel
- 📅 Attendance Management
- 📚 Course Management
- 👨‍🏫 Faculty Management
- 🌐 Spring Boot REST API
- ⚛️ React Frontend
- 🔑 JWT Authentication
- 🐳 Docker Deployment

---

# 📸 Screenshots

> Add screenshots of:

- Login Screen
- Admin Dashboard
- Student Dashboard
- Student Management
- Leave Management
- Reports
- Database Tables

---

# ▶️ How to Run

## 1️⃣ Clone Repository

```bash
git clone https://github.com/jotiram75/Student-And-Leave-Management-System.git
```

---

## 2️⃣ Import into Eclipse

- File → Import
- Existing Java Project

---

## 3️⃣ Create MySQL Database

```sql
CREATE DATABASE student_leave_management;
```

Import the SQL tables into MySQL.

---

## 4️⃣ Update Database Credentials

Edit **DBUtility.java**

```java
private static final String URL = "jdbc:mysql://localhost:3306/student_leave_management";
private static final String USERNAME = "root";
private static final String PASSWORD = "your_password";
```

---

## 5️⃣ Run the Project

Run:

```text
StudentClient.java
```

---

# 👨‍💻 Author

## Jotiram Navanath Shinde

🎓 **B.E. Artificial Intelligence & Data Science**

### Connect with Me

- 💼 **LinkedIn:** https://www.linkedin.com/in/jotiram75
- 🌐 **GitHub:** https://github.com/jotiram75

---

# 📜 License

This project is developed for **educational and learning purposes**.

You are free to use, modify, and enhance this project for **personal or academic use**.

---


