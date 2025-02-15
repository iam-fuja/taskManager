
# API Documentation
The application provides the following RESTFUL endpoints:

### 1. Create a New Task
**Endpoint:** `POST /tasks`

**Request Body:**
```json
{
    "title": "Valentine",
    "description": "Ire is Val",
    "dueDate": "2025-02-17",
    "completed": false,
    "category": "PERSONAL"
}
```

**Response:** Returns the created task.

### 2. Display All Tasks
**Endpoint:** `GET /tasks`

**Response:** Returns a list of all tasks.

### 3. Edit a Particular Task
**Endpoint:** `PUT /tasks/{id}`

**Request Body:**
```json
{
    "title": "Valentine",
    "description": "Ire is Val",
    "dueDate": "2025-02-17",
    "completed": false,
    "category": "PERSONAL"
}
```

**Response:** Returns the updated task.

### 4. Delete a Particular Task
**Endpoint:** `DELETE /tasks/{id}`

**Response:** Confirms the deletion of the task.

### 5. Mark a Particular Task as Completed
**Endpoint:** `PATCH /tasks/{id}/complete`

**Request Body:**
```json
{
    "completed": true
}
```

**Response:** Returns the updated task with completion status.

Thank you

