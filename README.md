#### Tour Package Management API

A Spring Boot 3 backend application for managing tour packages, including creation, retrieval, search by location, and fetching details by ID. The project follows a clean architecture approach with DTOs, services, and controllers, and is documented with Swagger (OpenAPI 3).

#### Features

- Add new Tour Packages with details
- Retrieve all tour packages
- Search tour packages by location
- Get a tour package by ID
- Swagger UI for easy API testing
- Standardized API responses with `ResponseDTO`
- Validation with Jakarta Validation
- Modular Service Layer for clean separation

#### Tech Stack

| Technology        | Purpose                                  |
|-------------------|------------------------------------------|
| Java 17+          | Programming language                     |
| Spring Boot 3     | Backend framework                         |
| Spring Web        | REST API development                     |
| Spring Validation | Request validation                       |
| Springdoc OpenAPI | Swagger documentation                    |
| Lombok            | Boilerplate code reduction               |
| Maven             | Build tool                               |

#### Code is structured under:

* `controllers`
* `services`
* `repositories`
* `dto`
* `entities`
* `constants`
* `mappers`
* `exceptions`


#### Getting Started

1. Prerequisites
    - Java 17+
    - Maven 3.8+
    - An IDE like IntelliJ IDEA or Eclipse
    - PostgreSQL or any other relational database

2. Clone the Repository
```bash
git clone https://github.com/yourusername/tour-package.git
cd tour-package
```

3. Configure Database

   Update `application.yml` with your database credentials.

4. Install Dependencies

```bash
mvn clean install
```

5. Run the Application

```bash
mvn spring-boot:run
```

The server will start at:

```
http://localhost:8080
```

#### API Documentation

Once the application is running, open Swagger UI in your browser:

```
http://localhost:8080/swagger-ui/index.html
```

#### API Endpoints

##### 1. Add Tour Package

POST `/api/v1/tour-packages/add`
Request Body (JSON):

```json
{
  "title": "Himalayan Trek Adventure",
  "description": "A 14-day trek through the beautiful Himalayan mountain range with expert guides.",
  "location": "Himalayas, India",
  "duration": "14Days/13Nights",
  "percentageDiscount": 17,
  "actualPrice": 1200.00
}
```

Response:

```json
{
  "message": "Tour package added successfully",
  "status": true,
  "data": { ... }
}
```

<img src="/doc/add-tour-package.png">

##### 2. Get All Tour Packages

GET `/api/v1/tour-packages/all`

<img src="/doc/get-all-tour-package.png">

##### 3. Get Tour Package by ID

GET `/api/v1/tour-packages/{id}`

<img src="/doc/get-tour-package-by-id.png">

##### 4. Search by Location

GET `/api/v1/tour-packages/search?location=Goa`

<img src="/doc/get-tour-package-by-location.png">