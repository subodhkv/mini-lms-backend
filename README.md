# Mini LMS Backend

A backend service for managing Courses, Modules, Lessons, and tracking user Lesson Progress in a simple Learning Management System.

## 🔧 Tech Stack

- Java 17
- Spring Boot 3+
- Spring Data JPA (with MySQL)
- Swagger (OpenAPI) for API documentation
- Maven
- Lombok
- In-memory auth (Optional)
- File upload support (Optional)

---

## 🧱 Project Structure

```text
src/main/java/com/mini/lms_backend
├── config                 # OpenAPI, Security, and MVC configuration
├── controller             # REST Controllers for Course, Module, Lesson, Progress
├── dto                   # Data Transfer Objects (DTOs)
├── entity                 # JPA Entities (Course, Module, Lesson, etc.)
├── exception              # Global Exception Handling
├── repository             # JPA Repositories
├── service                # Business Logic Services
├── LmsBackendApplication # Spring Boot main application class

```
## ▶️ Getting Started
🛠️ Setup Instructions 
1) Clone the repository:
 
 ```text
 git clone https://github.com/subodhkv/mini-lms-backend.git
 cd mini-lms-backend

 ```
 2) Configure your database in application.properties:
 
 ```text
spring.datasource.url=jdbc:mysql://localhost:3306/lms
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

 ```
3) Run the application:

```text
./mvnw spring-boot:run
```
4) Access Swagger API docs at:

```text
http://localhost:8080/swagger-ui/index.html
```

## 📌 Key Features
CRUD operations for Course, Module, and Lesson

Lesson Progress tracking per user

Course & Module level progress calculation

Swagger API documentation

File upload support

Global exception handling

## 📬 API Usage (cURL + Response)

```text
curl -X 'POST' \
  'http://localhost:8080/modules/course/1' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "title": "Spring Boot Basics",
  "summary": "Introduction to Spring Boot",
  "thumbnailUrl": "https://example.com/module-thumb.jpg",
  "coverImageUrl": "https://example.com/module-cover.jpg",
  "lessons": [
    {
      "title": "Introduction to Spring",
      "type": "TEXT",
      "content": "Spring is a Java framework."
    },
    {
      "title": "Spring Boot Setup",
      "type": "VIDEO",
      "content": "https://youtube.com/spring-boot-setup"
    }
  ]
}
```
```text
200 Ok
{
  "id": 3,
  "title": "Spring Boot Basics",
  "summary": "Introduction to Spring Boot",
  "thumbnailUrl": "https://example.com/module-thumb.jpg",
  "coverImageUrl": "https://example.com/module-cover.jpg",
  "lessons": [
    {
      "id": 7,
      "title": "Introduction to Spring",
      "type": "TEXT",
      "content": "Spring is a Java framework."
    },
    {
      "id": 8,
      "title": "Spring Boot Setup",
      "type": "VIDEO",
      "content": "https://youtube.com/spring-boot-setup"
    }
  ]
}
```
```text
curl -X 'GET' \
  'http://localhost:8080/modules/1?userId=student' \
  -H 'accept: application/json'
```
```text
200 Ok
{
  "id": 1,
  "title": "Spring Boot Basics",
  "summary": "Introduction to Spring Boot",
  "progress": 0
}
```
```text
curl -X 'POST' \
  'http://localhost:8080/lessons/1/progress?userId=admin' \
  -H 'accept: application/json' \
  -d ''
```
```text
200 Ok
{
  "id": 2,
  "userId": "admin",
  "completed": true,
  "lesson": {
    "id": 1,
    "title": "Introduction to Spring",
    "type": "TEXT",
    "content": "Spring is a framework for building Java applications."
  }
}
```
```text
curl -X 'POST' \
  'http://localhost:8080/lessons/module/1' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "title": "Lesson Title",
  "type": "TEXT",
  "content": "This is the lesson content"
}
```
```text
200 Ok
{
  "id": 9,
  "title": "Lesson Title",
  "type": "TEXT",
  "content": "This is the lesson content"
}
```
```text
curl -X 'GET' \
  'http://localhost:8080/lessons/1' \
  -H 'accept: application/json'
```
```text
200 Ok
{
  "id": 1,
  "title": "Introduction to Spring",
  "type": "TEXT",
  "content": "Spring is a framework for building Java applications."
}
```
```text
curl -X 'GET' \
  'http://localhost:8080/courses' \
  -H 'accept: application/json'
```
```text
200 Ok
[
  {
    "id": 1,
    "title": "Spring Boot Masterclass",
    "description": "Learn Spring Boot from scratch",
    "thumbnailUrl": "/uploads/thumbnails/spring.jpg",
    "coverImageUrl": "/uploads/covers/spring-cover.jpg",
    "modules": [
      {
        "id": 2,
        "title": "Spring Boot Basics",
        "summary": "Introduction to Spring Boot",
        "thumbnailUrl": "https://example.com/module-thumb.jpg",
        "coverImageUrl": "https://example.com/module-cover.jpg",
        "lessons": []
      },
      {
        "id": 3,
        "title": "Spring Boot Basics",
        "summary": "Introduction to Spring Boot",
        "thumbnailUrl": "https://example.com/module-thumb.jpg",
        "coverImageUrl": "https://example.com/module-cover.jpg",
        "lessons": [
          {
            "id": 7,
            "title": "Introduction to Spring",
            "type": "TEXT",
            "content": "Spring is a Java framework."
          },
          {
            "id": 8,
            "title": "Spring Boot Setup",
            "type": "VIDEO",
            "content": "https://youtube.com/spring-boot-setup"
          }
        ]
      }
    ]
  },
  {
    "id": 2,
    "title": "Spring Boot Masterclass",
    "description": "Learn Spring Boot from scratch",
    "thumbnailUrl": "/uploads/thumbnails/spring.jpg",
    "coverImageUrl": "/uploads/covers/spring-cover.jpg",
    "modules": []
  },
  {
    "id": 3,
    "title": "Spring Boot Masterclass",
    "description": "Learn Spring Boot from scratch",
    "thumbnailUrl": "/uploads/thumbnails/spring.jpg",
    "coverImageUrl": "/uploads/covers/spring-cover.jpg",
    "modules": []
  },
  {
    "id": 4,
    "title": "Spring Boot Masterclass",
    "description": "Learn Spring Boot from scratch",
    "thumbnailUrl": "/uploads/thumbnails/spring.jpg",
    "coverImageUrl": "/uploads/covers/spring-cover.jpg",
    "modules": []
  },
  {
    "id": 5,
    "title": "Spring Boot Masterclass",
    "description": "Learn Spring Boot from scratch",
    "thumbnailUrl": "/uploads/thumbnails/spring.jpg",
    "coverImageUrl": "/uploads/covers/spring-cover.jpg",
    "modules": []
  },
  {
    "id": 6,
    "title": "Spring Boot",
    "description": "Learn backend development",
    "thumbnailUrl": "/uploads/thumb1.png",
    "coverImageUrl": "/uploads/cover1.png",
    "modules": []
  },
  {
    "id": 7,
    "title": "Java Backend Course",
    "description": "Learn Spring Boot and Microservices",
    "thumbnailUrl": "https://example.com/thumbnail.jpg",
    "coverImageUrl": "https://example.com/cover.jpg",
    "modules": []
  }
]
```
```text
curl -X 'POST' \
  'http://localhost:8080/courses' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "title": "Java Backend Course",
  "description": "Learn Spring Boot and Microservices",
  "thumbnailUrl": "https://example.com/thumbnail.jpg",
  "coverImageUrl": "https://example.com/cover.jpg",
  "modules": [
    {
      "title": "Spring Boot Basics",
      "summary": "Introduction to Spring Boot",
      "thumbnailUrl": "https://example.com/module-thumb.jpg",
      "coverImageUrl": "https://example.com/module-cover.jpg",
      "lessons": [
        {
          "title": "Introduction to Spring",
          "type": "TEXT", 
          "content": "Spring is a framework for building Java applications."
        },
        {
          "title": "Setting up Spring Boot",
          "type": "VIDEO",
          "content": "https://youtube.com/spring-boot-setup"
        }
      ]
    }
  ]
}

```
```text
200 Ok
{
  "id": 8,
  "title": "Java Backend Course",
  "description": "Learn Spring Boot and Microservices",
  "thumbnailUrl": "https://example.com/thumbnail.jpg",
  "coverImageUrl": "https://example.com/cover.jpg",
  "modules": [
    {
      "id": 4,
      "title": "Spring Boot Basics",
      "summary": "Introduction to Spring Boot",
      "thumbnailUrl": "https://example.com/module-thumb.jpg",
      "coverImageUrl": "https://example.com/module-cover.jpg",
      "lessons": [
        {
          "id": 10,
          "title": "Introduction to Spring",
          "type": "TEXT",
          "content": "Spring is a framework for building Java applications."
        },
        {
          "id": 11,
          "title": "Setting up Spring Boot",
          "type": "VIDEO",
          "content": "https://youtube.com/spring-boot-setup"
        }
      ]
    }
  ]
}
```

```text
curl -X 'POST' \
  'http://localhost:8080/courses/upload-thumbnail' \
  -H 'accept: application/json' \
  -H 'Content-Type: multipart/form-data' \
  -F 'file=@WhatsApp Image 2025-07-13 at 15.11.01.jpeg;type=image/jpeg'
```
```text
200 Ok
Raw result:
/uploads/thumbnails/62d29d81-6b33-4b33-9df9-65ed15d880dc_WhatsApp Image 2025-07-13 at 15.11.01.jpeg

```
```text
curl -X 'GET' \
  'http://localhost:8080/courses/6?userId=student' \
  -H 'accept: application/json'
```

```text
200 Ok
{
  "id": 6,
  "title": "Spring Boot",
  "description": "Learn backend development",
  "progress": 0
}
```

## 🧠 Assumptions Made
userId is a simple string and not linked to an actual User table (used as request param for progress tracking)

No authentication or role enforcement is required unless explicitly enabled via in-memory security

File uploads store files in a local directory (/uploads) for demo purpose

Only basic validation is applied to content field depending on lesson type (TEXT, VIDEO, etc.)

All relationships are handled with lazy loading unless specified otherwise

## 👨‍💻 Author
Subodh Kumar

## 📃 License
This project is licensed under the MIT License.