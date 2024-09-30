# Student Management System - Technology Assessment

## Overview
This project is a **Student Management System** designed to allow users to log in, view courses, manage course registration, and view course schedules. The system is implemented as a REST API application, deployed on a WebLogic server, and utilizes modern technologies such as JWT for authentication and Redis for caching. All API interactions are stateless.

## Technologies Used
- **Java**: Version 8 or higher
- **Spring Boot**: For creating RESTful APIs
- **Oracle Database**: For storing course and user information
- **WebLogic Server**: Application deployed on the latest version of WebLogic
- **JWT (JSON Web Token)**: For secure, stateless authentication
- **Redis**: Used for caching data to improve performance after retrieving data from the database
- **Lombok**: For reducing boilerplate code
- **MapStruct**: For simplifying object mapping between request/response DTOs and entities
- **Postman**: For API testing and automation of test cases

## Key Features
1. **User Authentication**:
   - Stateless authentication using **JWT**.
   - JWT expires in **5 minutes** and user session is valid for **10 minutes**.
   
2. **Course Management**:
   - Users can **view available courses**.
   - Users can **register for courses**.
   - Users can **cancel course registration**.
   - Users can **get course schedules as PDF**.

3. **Caching**:
   - **Redis** is used to cache data after it is retrieved from the database to optimize performance.
   
4. **Stateless API Design**:
   - All APIs are stateless to improve scalability and maintain session independence.

## API Endpoints
1. **Login**:
   - **Endpoint**: `/api/login`
   - **Method**: `POST`
   - **Description**: Authenticates the user by `username` and `password` and returns a JWT token.
   
2. **View Courses**:
   - **Endpoint**: `/api/courses`
   - **Method**: `GET`
   - **Description**: Fetches the list of available courses.

3. **Register for a Course**:
   - **Endpoint**: `/api/courses/register`
   - **Method**: `POST`
   - **Description**: Allows users to register for a specific course by course ID.
   
4. **Cancel Course Registration**:
   - **Endpoint**: `/api/courses/cancel`
   - **Method**: `DELETE`
   - **Description**: Cancels a user's course registration by course ID.
   
5. **Get Course Schedule as PDF**:
   - **Endpoint**: `/api/courses/schedule/pdf`
   - **Method**: `GET`
   - **Description**: Generates and returns the course schedule as a PDF.

## Project Structure
- **Controller**: Handles HTTP requests and responses.
- **Service**: Contains business logic for interacting with the database and caching.
- **Repository**: Manages data access to the Oracle database.
- **Security**: JWT implementation for secure access.
- **Configuration**: Redis and WebLogic configurations.

## Caching Framework
- **Redis** is used as the caching framework to store data retrieved from the Oracle database. This reduces the number of database calls and improves the performance of frequently accessed endpoints.

## Authentication & Security
- **JWT (JSON Web Tokens)** is used for stateless authentication. Once a user logs in, a JWT token is generated, which must be included in the header of all subsequent API calls. The JWT expires after **5 minutes**, and the user session is valid for **10 minutes**.

## Testing
- Postman test cases are provided for all the endpoints. The test cases include authentication, viewing courses, registering/canceling courses, and fetching course schedules as PDF.

## How to Run the Project

1. **Prerequisites**:
   - JDK 8 or higher
   - WebLogic server (latest version)
   - Oracle Database
   - Redis server

2. **Setup Instructions**:
   - Clone the project repository.
   - Configure the Oracle database connection in `application.properties`.
   - Set up Redis connection in `application.properties`.
   - Deploy the project to WebLogic server.
   - Use Postman to test the APIs.

3. **Postman Collection**:
   - A Postman collection containing all the API test cases is provided. Import the collection into Postman and run the tests against your local or deployed environment.

## Conclusion
This project provides a scalable and efficient student management system with modern authentication using JWT and caching with Redis for optimal performance. All APIs are stateless, making them ideal for horizontal scaling in cloud environments.
