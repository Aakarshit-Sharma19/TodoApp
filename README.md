# TodoApp

A simple Todo application built to understand and explore Java Persistence API (JPA).

## 📚 Project Purpose

This project was primarily created as a learning exercise to get hands-on experience with JPA and its related concepts. It demonstrates how to perform CRUD (Create, Read, Update, Delete) operations in a Java application using JPA for ORM (Object-Relational Mapping).

## 🛠️ Tech Stack

- **Java**
- **JPA** (Java Persistence API)
- **Spring Boot** (if used)
- **H2/MySQL** (or your choice of database)
- **Maven/Gradle** (for build management)

## 🚀 Features

- Add, update, view, and delete todo tasks
- Simple data model for practice and experimentation
- Demonstrates mapping between Java classes and database tables

## 🏗️ How to Run

1. **Clone the repository:**
   ```sh
   git clone https://github.com/Aakarshit-Sharma19/TodoApp.git
   cd TodoApp
   ```

2. **Edit Database Configuration (if required):**
    - Check the `application.properties` or `application.yml` file for DB settings.

3. **Build & Run:**
    - If using Maven:
      ```sh
      mvn spring-boot:run
      ```
    - If using Gradle:
      ```sh
      ./gradlew bootRun
      ```

4. **Access the app:**
    - Usually runs at `http://localhost:8080/` (verify in your configuration).

## 📦 Folder Structure

```
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ... (Java source files)
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml or build.gradle
└── README.md
```

## ✍️ Learning Outcomes

- Basic JPA entity mapping
- Repository pattern in JPA
- Persisting, querying, updating, and deleting data
- Integrating JPA with a Java (or Spring Boot) application

## 📝 License

This project is for learning purposes and does not use any specific license.

---

Feel free to fork the repo and experiment with JPA! If you have suggestions or questions, open an issue or pull request.