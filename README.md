Here is a simplified version of the CRM system documentation for setting up and using it, converted into an easy-to-follow Word document format:

---

**CRM System Setup and API Documentation**

---

### **Introduction**

This CRM system allows admin users to manage:

- **User Registration and Authentication**: Admin can register new users, log in, reset passwords, etc.
- **Task Management**: Perform CRUD (Create, Read, Update, Delete) operations on tasks.
- **Activity Logging**: Track and log user activities.
- **Report Generation**: Generate task-related summary reports.

---

### **Features**

1. **User Management**: Register, login, and password reset functionality.
2. **Task Management**: Create, update, delete, and view tasks.
3. **Activity Log**: Track all activities like task creation, updates, etc.
4. **Report Generation**: Retrieve task summary reports showing total, completed, and pending tasks.

---

### **Project Setup**

**Prerequisites**:
- JDK 11 or higher
- Spring Boot 2.x
- MySQL (for production) or H2 (for development)
- Maven or Gradle (for dependency management)

**Steps to Set Up**:

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/your-repository/crm-system.git
    cd crm-system
    ```

2. **Database Setup**:
    - Create a MySQL database.
    - Configure `application.properties` to connect to the database.
    - Set up database authentication (your MySQL userid and password).

---

### **API Endpoints**

#### **User Endpoints**

1. **Register User**:
   - **POST**: `http://localhost:8080/crm.technothinksup.in/admin/register`
   - **Request Body (JSON)**:
     ```json
     {
       "email": "sonalimane.technothinksup@gmail.com",
       "password": "Sonali@123",
       "role": "Back End Developer"
     }
     ```
   - **Response**: `200 OK`
     ```json
     {
       "message": "Registration Successful..."
     }
     ```

2. **Login User**:
   - **POST**: `http://localhost:8080/crm.technothinksup.in/admin/login`
   - **Request Body (JSON)**:
     ```json
     {
       "email": "sonalimane.technothinksup@gmail.com",
       "password": "Sonali@123"
     }
     ```
   - **Response**: `200 OK`
     ```json
     {
       "message": "Login Successful...",
       "role": "Back End Developer"
     }
     ```

3. **Forgot Password**:
   - **POST**: `http://localhost:8080/crm.technothinksup.in/admin/forgot-password`
   - **Request Body (JSON)**:
     ```json
     {
       "email": "sonalimane.technothinksup@gmail.com"
     }
     ```
   - **Response**: 
     ```json
     {
       "message": "Reset token generated. Use this token to reset your password: fee783dd-cdd4-4b09-b669-ee51c8a96396"
     }
     ```

4. **Reset Password**:
   - **POST**: `http://localhost:8080/crm.technothinksup.in/admin/reset-password?resetToken=fee783dd-cdd4-4b09-b669-ee51c8a96396&newPassword=sonali123@`
   - **Response**: `200 OK`
     ```json
     {
       "message": "Password Reset Successful!"
     }
     ```

---

#### **Task Endpoints**

1. **Get All Tasks**:
   - **GET**: `http://localhost:8080/crm.technothinksup.in/admin/task`
   - **Response**: List of all tasks in JSON format.

2. **Create Task**:
   - **POST**: `http://localhost:8080/crm.technothinksup.in/admin/task`
   - **Request Body (JSON)**:
     ```json
     {
       "title": "Backend Development Task Assignment – CRM Application",
       "description": "Develop and implement backend functionalities for the CRM Application.",
       "deadline": "2024-12-20",
       "priority": "High",
       "status": "Pending"
     }
     ```
   - **Response**: The newly created task in JSON format.

3. **Update Task**:
   - **PUT**: `http://localhost:8080/crm.technothinksup.in/admin/task/1`
   - **Request Body (JSON)**:
     ```json
     {
       "title": "Backend Development Task Assignment – CRM Application",
       "description": "Updated task details.",
       "deadline": "2024-12-24",
       "priority": "Medium",
       "status": "Pending"
     }
     ```
   - **Response**: The updated task in JSON format.

4. **Delete Task**:
   - **DELETE**: `http://localhost:8080/crm.technothinksup.in/admin/task/1`
   - **Response**: `Task deleted successfully.`

5. **Get Task by ID**:
   - **GET**: `http://localhost:8080/crm.technothinksup.in/admin/task/1`
   - **Response**: The task with the specified ID in JSON format.

---

#### **Activity Log Endpoints**

1. **Get All Activity Logs**:
   - **GET**: `http://localhost:8080/crm.technothinksup.in/admin/activity-logs`
   - **Response**: List of all activity logs in JSON format.

2. **Create Activity Log**:
   - **POST**: `http://localhost:8080/crm.technothinksup.in/admin/activity-logs`
   - **Request Body (JSON)**:
     ```json
     {
       "action": "Task Is Created",
       "userId": 1,
       "timestamp": "2024-12-19T14:30:00"
     }
     ```
   - **Response**: The created activity log in JSON format.

3. **Get Activity Log by ID**:
   - **GET**: `http://localhost:8080/crm.technothinksup.in/admin/activity-logs/1`
   - **Response**: The activity log with the specified ID in JSON format.


