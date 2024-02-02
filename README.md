# Simple JWT Authentication using Spring Boot OAuth2 Resource Server

This is a simple Spring Boot application that demonstrates how to implement user authentication using
JSON Web Tokens (JWT) in Spring Boot OAuth2 Resource Server and Spring Security.
The application also includes a access token and refresh token functionality.

 :star: If you find this project useful, please consider giving us a star on GitHub! Your support helps us continue to innovate and deliver exciting features.

![Number of GitHub contributors](https://img.shields.io/github/contributors/lochuung/simple-jwt-auth)
[![Number of GitHub issues that are open](https://img.shields.io/github/issues/lochuung/simple-jwt-auth)](https://github.com/lochuung/simple-jwt-auth/issues)
[![Number of GitHub stars](https://img.shields.io/github/stars/lochuung/simple-jwt-auth)](https://github.com/lochuung/simple-jwt-auth/stargazers)
![Number of GitHub closed issues](https://img.shields.io/github/issues-closed/lochuung/simple-jwt-auth)
![Number of GitHub pull requests that are open](https://img.shields.io/github/issues-pr-raw/lochuung/simple-jwt-auth)
![GitHub release; latest by date](https://img.shields.io/github/v/release/lochuung/simple-jwt-auth)
![GitHub commit activity](https://img.shields.io/github/commit-activity/m/lochuung/simple-jwt-auth)
[![GitHub license which is APGL license](https://img.shields.io/github/license/lochuung/simple-jwt-auth)](https://github.com/lochuung/simple-jwt-auth)
[![Follow me on Facebook](https://img.shields.io/badge/Facebook-Connect-brightgreen?style=social&logo=facebook)](https://facebook.com/lochuung)



## Built With

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security)
- [OAuth2 Resource Server](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web.security.oauth2.server)


## Features

- User authentication via JWT
- Refresh token functionality

## Setup and Running

1. Clone the repository
2. Edit the `application.properties` file to configure the database and JWT information:
```properties
# ===============================
# = JWT CONFIGURATION
# ===============================
# Below are the configurations for JWT

# JWT Access Token Expiration Time
jwt.access-token.expiration-time=3600
# JWT Refresh Token Expiration Time
jwt.refresh-token.expiration-time=86400

# ===============================
# = SERVER
# ===============================
# Set here configurations for the web server

server.port=8080
```
3. Navigate to the project directory
4. Run the application using the command `./mvnw spring-boot:run`

## API Endpoints

- POST `/api/auth/login`: Authenticate a user and return an access and refresh token.

#### Request Body

```json
{
  "email": "admin@cnj.vn",
  "password": "123"
}
```

#### Response Body

```json
{
  "access_token": "access_token",
  "refresh_token": "refresh_token"
}
```

- POST `/api/auth/refresh-token`: Refresh the access token.

#### Request Header

```
Authorization: Bearer <refresh_token>
```

#### Response Body

```json
{
  "access_token": "access_token",
  "refresh_token": "refresh_token"
}
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)
