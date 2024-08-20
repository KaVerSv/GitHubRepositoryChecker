# gitRepoChecker Repositories API

## Overview
A Spring Boot application that provides an API for fetching GitHub repositories that are not a fork for a given user. The API returns the repository name, owner login, and branch details.

## Requirements
- Java 21
- Maven

## Running the Application
1. Clone the repository.
2. Navigate to the project directory.
3. Run the application:
   ```bash
   mvn spring-boot:run

## Usage

1. Open API checking application of your choice like for example Postman.
2. Select GET method and type http://localhost:8080/repositories?username="username"
3. For header use “Accept: application/json”.
4. Click Send.
