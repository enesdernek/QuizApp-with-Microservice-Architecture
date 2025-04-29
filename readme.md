# Quiz Application (Microservice Architecture)

This project is a simple microservice-based quiz application.

## Technologies Used

- Java 21  
- Spring Boot  
- Spring Eureka Server (Service Discovery)  
- OpenFeign (Inter-service Communication)  
- MySQL

## How to Run

1. Clone or download the project.
2. Import it as a Maven project in your IDE.
3. Start the following applications in order by running their `main` classes:
   - `ServiceRegistryApplication.java`
   - `QuestionServiceApplication.java`
   - `QuizApplication.java`
   - `ApiGatewayApplication.java`
4. Once all services are up, you can test the endpoints using the following format:

```
http://localhost:8765/{service-name}/{request}
```

### Example Request

```
http://localhost:8765/quiz-service/quiz/3
```
