# Task API

A REST API for managing tasks — create, retrieve, update, delete. Built to work through Spring Boot layer by layer rather than adopting a finished example.

**Java 26 · Spring Boot 4.1 · Spring Data JPA · H2 · Gradle**

## Getting started

```bash
git clone https://github.com/Qubaja/Spring.git
cd Spring
./gradlew bootRun
```

The API is then available at `http://localhost:8080/tasks`, with two sample tasks created on startup. All you need is a JDK 17 or newer — the server and the database come with the project.

## Endpoints

| Method | Path | Description |
|---|---|---|
| `GET` | `/tasks` | All tasks |
| `GET` | `/tasks/{id}` | A single task |
| `POST` | `/tasks` | Create a task |
| `PUT` | `/tasks/{id}` | Update a task |
| `DELETE` | `/tasks/{id}` | Delete a task |

A task:

```json
{ "id": 1, "titel": "Spring lernen", "erledigt": false }
```

Creating one:

```bash
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"titel":"Einkaufen","erledigt":false}'
```

The `id` is assigned by the database and ignored on input — on update it is taken from the URL.

## Errors

Both failure cases return the same shape, so a client only has to parse one format.

Unknown task — status 404:

```json
{ "status": 404, "message": "Task 99 nicht gefunden" }
```

Invalid input, such as an empty title — status 400:

```json
{ "status": 400, "message": "must not be blank" }
```

## Structure

The application is split into three layers, each with one clearly defined responsibility:

**Controller** — receives HTTP requests and returns responses. Contains no business logic.

**Service** — decides what happens, such as treating an unknown id as an error. Knows nothing about HTTP.

**Repository** — talks to the database. An interface without an implementation; Spring Data generates the class behind it at runtime.

Alongside these sits a central exception handler that translates domain errors and validation failures into HTTP status codes, keeping error handling in one place instead of spread across the endpoints.

The value of that separation showed during the switch of the persistence layer: tasks originally lived in a Java list, later in a database. Only the bottom layer was replaced — the controller and the error handling stayed untouched.

## Database

Data is held in an in-memory H2 database and resets on every restart.

The web console is available at `http://localhost:8080/h2-console` — JDBC URL `jdbc:h2:mem:testdb`, user `sa`, no password.

## Next steps

- Tests with MockMvc and Mockito
- PostgreSQL instead of H2
