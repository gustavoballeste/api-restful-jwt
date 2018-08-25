# API RESTful JWT

## Instructions

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes

### Prerequisites

- JDK 8

- Gradle 3.5+

- Docker

### Installation

A step by step series of examples that tell you have to get a development env running

```
./gradlew jibDockerBuild
```

After verifying that the image was built correctly through the ```docker build``` command, type:

```
docker run -d --name api-restful-jwt -p 80:8080 gustavoballeste/api-restful-jwt:0.0.1-SNAPSHOT
```
