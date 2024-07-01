# spring-boot-validate-objects

This project demonstrates how to implement data validation in a Spring Boot application using Hibernate Validator and custom validation logic. It includes examples of validating DTOs (Data Transfer Objects) and entities, ensuring data integrity and user input validation.

## Features

- **DTO Validation:** Use of annotations such as @NotBlank, @Size, etc., to validate incoming data transfer objects before processing.
- **Entity Validation:** Integration of Hibernate Validator to validate entity constraints before persistence.
- **Custom Validation Logic:** Implementation of a custom validator (`ObjectsValidator`) to handle complex validation scenarios not covered by default annotations.
- **REST API Integration:** Illustration of validation results through REST API responses, showing success messages and detailed error messages for validation failures.

## Prerequisites

- JDK 17 or higher
- Spring Boot 3
- Git (optional, for cloning the repository)

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Clone the Repository

```bash
	git clone https://github.com/bouguern/spring-boot-validate-objects.git
	
	cd spring-boot-validate-objects

	./mvnw spring-boot:run

	
## API Endpoints

### 1. Create a New Post

- **Endpoint:** `POST /create-post`
- **Description:** This endpoint creates a new post.
- **Request:**
  - **Content-Type:** application/json
  - **Body:**
    ```json
    {
        "content": "First Post"
    }
    ```
  - **Example:**
    ```bash
    curl -X POST http://localhost:9095/create-post \
    -H "Content-Type: application/json" \
    -d '{
          "content": "First Post"
        }'
    ```

- **Responses:**
  - **Success:**
    - **Status Code:** 202 Accepted
    - **Body:** "POST Validated and Saved"
  - **Validation Error (Empty Content):**
    - **Status Code:** 202 Accepted
    - **Body:** "The content must not be null and must contain at least one non-whitespace character, content must be at most 500 characters, and has at least one character"
  - **Validation Error (Whitespace Content):**
    - **Status Code:** 202 Accepted
    - **Body:** "The content must not be null and must contain at least one non-whitespace character"


## Usage Examples

### Create a New Post

1. **Valid Content:**
   ```http
   POST http://localhost:9095/create-post
   Content-Type: application/json

   {
       "content": "First Post"
   }