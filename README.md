# Task Manager

## Overview
Task Manager is a Spring Boot application designed to manage tasks efficiently.
It is a RESTful with controllers, services, repositories, model and enum classes.
It has 5 endpoints as follows;
1. Create Task
2. Update Task
3. Mark task as complete
4. Delete Task
5. Get all tasks

The application also includes algorithm implementations for string processing.
Algorithms are within the directory Java(package com.example.taskManager.algorithms;)

## Technologies Used
- **Java 17**
- **Spring Boot** (for backend development)
- **Spring Data JPA** (for database interaction)
- **H2 Database** (in-memory database for development)
- **Maven** (for dependency management)

## Project Structure
- **`controller/`**: Handles HTTP requests.
- **`service/`**: Implements business logic.
- **`repository/`**: Manages database interactions using Spring Data JPA.
- **`model/`**: Defines entity classes.
- **`enum/`**: Defines entity category.
- **`algorithms/`**: Contains string processing algorithms.

## Algorithms Implemented
### 1. First Non-Repeating Character
This function finds the first non-repeating character in a string.
```java
public static String nonRepeating(String word){
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    for (Character letter : word.toCharArray()) {
        map.put(letter, map.getOrDefault(letter, 0) + 1);
    }
    for (Map.Entry<Character, Integer> val : map.entrySet()) {
        if (val.getValue() == 1) {
            return val.getKey().toString();
        }
    }
    return "";
}
```

### 2. String Compression
This function compresses consecutive repeating characters.
```java
public static String stringCompression(String word) {
    StringBuilder result = new StringBuilder();
    int count = 1;
    for (int i = 1; i < word.length(); i++) {
        if (word.charAt(i) == word.charAt(i - 1)) {
            count++;
        } else {
            result.append(word.charAt(i - 1)).append(count);
            count = 1;
        }
    }
    result.append(word.charAt(word.length() - 1)).append(count);
    return result.toString();
}
```

## Running the Project Locally
### Prerequisites
Ensure you have the following installed:
- Java 17+
- Maven

### Steps to Run the Application
1. Clone the repository:
   ```sh
   git clone https://github.com/iam-fuja/taskManager.git
   ```
2. Navigate to the project directory:
   ```sh
   cd taskManager-main
   ```
3. Run the application using Maven:
   ```sh
   mvn spring-boot:run
   ```
4. Access the H2 database console at:
   ```
   http://localhost:8080/h2-console
   ```
   Use the following credentials:
    - **JDBC URL**: `jdbc:h2:mem:testdb`
    - **Username**: `sa`
    - **Password**: `password`

## API Endpoints
The application exposes RESTful APIs for task management.
Refer to the controller package for available endpoints.


