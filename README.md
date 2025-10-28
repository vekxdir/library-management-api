# 📚 Book Management API (Spring Boot)

A simple CRUD REST API for managing books — built with Spring Boot

## 🚀 Features
- Create, Read, Update, Delete Books
- Validation (e.g., Published date cannot be in the future)
- Exception Handling
- DTO 

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Maven

## ⚙️ Setup
1. Clone the repo  
   ```bash
   git clone https://github.com/vek/book-api.git
   cd book-api
2. Configure your database in application.properties
3. Run the app:
     mvn spring-boot:run

## 📬 Example JSON (POST /books)

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "publishedDate": "2008-08-01",
  "availableCopies": 5
}

