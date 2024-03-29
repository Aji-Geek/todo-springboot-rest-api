****TodoMVC API Documentation:****

**Overview**
The TodoMVC API provides endpoints to manage a list of todos. Todos are simple tasks that users can create, read, update, and delete. This documentation outlines the available endpoints, their functionalities, and the expected request and response formats.

**Base URL**
http://localhost:8087/todoapplication

**Swagger URL**
http://localhost:8087/todoapplication/swagger-ui/index.html#/ 

**Endpoints**

**1. Get All Todos** <br>
 Endpoint: GET - /api/todos <br>
 Description: Retrieve a list of all todos. <br>
 Request: None <br>
 Response:<img width="965" alt="image" src="https://github.com/Aji-Geek/todo-springboot-rest-api/assets/54324401/172ef9b0-f787-4a08-ba56-63a598a0bd74">

**2. Get Todo by ID** <br>
 Endpoint: GET - /api/todos/{id} <br>
 Description: Retrieve a specific todo by its ID. <br>
 Request: None <br>
 Response:<img width="951" alt="image" src="https://github.com/Aji-Geek/todo-springboot-rest-api/assets/54324401/e60e2dab-a53f-4c40-b6cc-9a04eb3b1d38">

**3. Create Todo** <br>
 Endpoint: POST - /api/todos <br>
 Description: Create a new todo. <br>
 Request:<br>
 {
    "title": "Deploy Project",
    "completed": false
 }

  Response: <br>
<img width="962" alt="image" src="https://github.com/Aji-Geek/todo-springboot-rest-api/assets/54324401/c294ac6b-366d-4a86-bfbb-1f86823495b5">
<img width="956" alt="image" src="https://github.com/Aji-Geek/todo-springboot-rest-api/assets/54324401/d9162e4f-1d3a-4d1d-8870-ea093139928b">

**4. Update Todo**<br>
 Endpoint: PUT - /api/todos/{id}<br>
 Description: Update an existing todo by ID.<br>
 Request:<br>
      {
	"title": "Deploy Project",
 	 "completed": false
         }

 Response:<br>
<img width="959" alt="image" src="https://github.com/Aji-Geek/todo-springboot-rest-api/assets/54324401/0237a96d-4ee1-4318-b84f-adba2a474e4c">
<img width="956" alt="image" src="https://github.com/Aji-Geek/todo-springboot-rest-api/assets/54324401/6e7f00a5-ec53-4fcc-a6a4-90f6968970ca">

**5. Delete Todo**<br>
 Endpoint: DELETE - /api/todos/{id}<br>
 Description: Delete a todo by its ID.<br>
 Request: None<br>
 Response: true/false -  HTTP Status 200<br>
<img width="959" alt="image" src="https://github.com/Aji-Geek/todo-springboot-rest-api/assets/54324401/03154111-34da-489f-849b-f10a5fa66a45">



Note: Schema for todo table is present in project at path
src/main/resources/scripts

**Test Cases for TodoService**<br>
<img width="1471" alt="image" src="https://github.com/Aji-Geek/todo-springboot-rest-api/assets/54324401/f8f8a79f-e83c-49a4-8873-e4c3ddad8c21">



