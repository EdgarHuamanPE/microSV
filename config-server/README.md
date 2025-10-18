### Procedimiento
1. En el directorio config-repo crear el archivo user-service.yml
``` 
server:
  port: 8080

spring:
  application:
    name: user-service

  datasource:
    url: jdbc:postgresql://localhost:5432/userdb
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver

  flyway:
    enabled: true
    locations: classpath:db/migration
    baseline-on-migrate: true
    validate-on-migrate: true

  cloud:
    config:
      server:
        git:
          uri: file:///C:/Users/edgar/IdeaProjects/config-repo
```

2. crear repositorio GIT en el directorio config-repo
``` 
    git init
    git branch -M main
    git add .
    git commit -m "created config repo"
    
```
2. crear el archivo application.yml

```
    server:
    port: 8084
    # Application Name
    
    # -- Application Configuration --
    spring:
    application:
    name: config-server
    cloud:
    config:
    server:
    git:
    # File URI - Adjust path according to your system:
    # Windows: file:///C:/Users/YourUser/microservices-lab1/config-repo
    #uri: file://${user.home}/IdeaProjects/config-repo
    uri: file:///C:/Users/edgar/IdeaProjects/config-repo
    
              # Git Configuration
              default-label: main
```
3.  