# EasyLang (management app for scheduling Translation Works)

## Overview

This project is a web application built with a **Java Spring Boot** backend and a **React** frontend using **Vite**. The application includes user authentication with JWT, role-based access control, and supports functionalities such as user profile management and project creation by managers.
## Demonstration
shortdemo.mp4 



## Features

- **User Registration and Login**
  - Secure user authentication using JWT tokens.
- **Profile Management**
  - Users can update their profile picture and bio.
- **Role-Based Access Control**
  - **Managers** can create projects and assign users.
  - **Users** have access to general functionalities.
- **Project Management**
  - Managers can create projects with deadlines, descriptions, and assign users.
- **RESTful API**
  - Clean and well-structured API endpoints.
- **Database Integration**
  - Uses MySQL for data persistence.

## Prerequisites

- **Java Development Kit (JDK) 17** or higher
- **Node.js** and **npm**
- **Maven**
- **MySQL** database
- **IDE** (e.g., IntelliJ IDEA, VS Code)

## Backend Setup Instructions

### 1. Clone the Repository

```sh
git clone <repository-url>
cd <repository-directory>/backend
```

### 2. Configure the Database

Create a MySQL database for the project:

```sql
CREATE DATABASE your_database_name;
```

Update the `application.properties` file with your database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Install Dependencies and Build the Project

```sh
mvn clean install
```

### 4. Run the Backend Application

```sh
mvn spring-boot:run
```

The backend server should now be running at `http://localhost:8080`.

## Frontend Setup Instructions

### 1. Navigate to the Frontend Directory

```sh
cd ../frontend
```

### 2. Install Dependencies

```sh
npm install
```

### 3. Configure API Base URL

If needed, update the API base URL in your frontend application to match the backend URL (`http://localhost:8080`).

### 4. Run the Frontend Application

```sh
npm run dev
```

The frontend application should now be running at `http://localhost:5173`.

## Usage

### User Registration

- Navigate to the registration page.
- Fill in the required details.
- Submit the form to create a new account.

### User Login

- Navigate to the login page.
- Enter your username and password.
- Upon successful login, a JWT token is stored in `localStorage`.

### Profile Management

- After logging in, navigate to your profile page.
- Update your bio and profile picture as desired.

### Project Creation (Manager Only)

- Login with a manager account.
- Navigate to the project creation page.
- Fill in the project details: name, description, deadline.
- Add users to the project by searching for their names.

## API Endpoints

### Authentication

- `POST /api/users/register` - Register a new user.
- `POST /api/users/login` - Login and receive a JWT token.

### Profile Management

- `POST /api/users/updateProfile` - Update user bio and profile picture.

### Project Management

- `POST /api/projects/create` - Create a new project (**Manager only**).
- `POST /api/projects/{projectId}/addUsers` - Add users to a project (**Manager only**).
- `GET /api/projects/searchUsers?query={name}` - Search for users by name.

## Security and Authentication

- Uses **JWT tokens** for authentication.
- Store the JWT token in the frontend (`localStorage`) upon login.
- Include the token in the `Authorization` header (e.g., `Authorization: Bearer <token>`) for protected API requests.

## Database Schema

### Users Table

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    role VARCHAR(50),
    bio TEXT,
    profile_pic_url VARCHAR(255)
);
```

### Projects Table

```sql
CREATE TABLE projects (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    deadline DATE
);
```

### Project_Users Table

```sql
CREATE TABLE project_users (
    project_id INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (project_id, user_id),
    FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
```

## Dependencies

### Backend

- **Spring Boot Starter Web**
- **Spring Boot Starter Data JPA**
- **Spring Boot Starter Security**
- **MySQL Connector**
- **JWT (io.jsonwebtoken:jjwt:0.9.1)**

### Frontend

- **React**
- **Vite**
- **Axios** for API requests

## Maven Commands

### Clean the Project

```sh
mvn clean
```

### Build the Project

```sh
mvn install
```

### Run the Application

```sh
mvn spring-boot:run
```

## NPM Scripts

### Install Dependencies

```sh
npm install
```

### Run the Frontend

```sh
npm run dev
```

## Troubleshooting

- **CORS Issues**
  - Ensure CORS is correctly configured in the backend `SecurityConfig` class.
  - Confirm that the frontend is making requests to the correct backend URL.

- **Database Connection Errors**
  - Verify that MySQL is running and the database credentials in `application.properties` are correct.

- **JWT Authentication Fails**
  - Ensure that the JWT token is properly stored and included in the `Authorization` header.
  - Check that the `SECRET_KEY` in `JwtUtil` is consistent and secured.

## License

This project is licensed under the **MIT License** - see the LICENSE file for details.

---

*Note: Replace placeholders like `<repository-url>`, `your_database_name`, `your_username`, `your.email@example.com`, and `Your Name` with actual values related to your project.*
