Certainly! Here's an example README.md file for an API security application built on Spring Boot 6, Spring Security, and Docker:

```markdown
# API Security App

API Security App is a sample application built on top of Spring Boot 6 and Spring Security. It provides a basic structure for securing APIs using Spring Security and is packaged as a Docker container for easy deployment.

## Features

- Token-based authentication using Spring Security
- Basic API endpoints secured with role-based access control
- Dockerized for easy deployment

## Prerequisites

- JDK 17 or later
- Docker installed on your machine

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-username/api-security-app.git
cd api-security-app
```

### Build the Application

```bash
./mvnw clean install
```

### Build the Docker Image

```bash
docker build -t api-security-app .
```

### Run the Docker Container

```bash
docker run -p 8080:8080 -d api-security-app
```

The application should now be running on http://localhost:8080.

## Configuration

The application can be configured through the `application.properties` file.

### Security Configuration

Security-related configurations are present in the `application.properties` file under the `src/main/resources` directory.

```properties
# JWT Configuration
jwt.secret=mySecretKey
jwt.expirationMs=86400000

# Spring Security Configuration
spring.security.user.name=admin
spring.security.user.password=adminpassword
```

## API Endpoints

- `/public` - Publicly accessible endpoint
- `/secured` - Secured endpoint requiring authentication
- `/admin` - Admin-only endpoint

## Testing

To test the secured endpoints, you can use tools like [Postman](https://www.postman.com/) or [curl](https://curl.se/).

Example Request:

```bash
curl -X GET http://localhost:8080/secured -H "Authorization: Bearer YOUR_ACCESS_TOKEN"
```

Replace `YOUR_ACCESS_TOKEN` with the actual token obtained during the authentication process.

## Contributing

If you'd like to contribute to the development of this application, please follow the standard GitHub Fork and Pull Request workflow.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

Remember to replace placeholder values such as `your-username`, `api-security-app`, and others with your actual project details. Additionally, you may need to tailor the content based on your specific application structure and features.