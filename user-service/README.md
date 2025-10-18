### Procedimiento
1.- En el directorio config-repo crear el archivo user-service.yml
server:
port: 8081

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
2.- Crear un repositorio GIT en el directorio config-repo
git init
git add .
git branch -M main
git commit -m "create config-repo"

3.- Crear el archivo application.yml
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
uri: file://${user.home}/git_codigo/config-repo
# Git Configuration
default-label: main

4.- Anotaciones personales:
-1. Cambiar el archivo application.properties a application.yml
-2. Copiar application.yml en directorio config-repo
-3. Agregar dependecias spring cloud config client en el pom.xml  
    
``` 
    <spring-cloud.version>2025.0.0</spring-cloud.version>
       
    <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```    
-4. Agregar dependendia de spring cloud bootstrap

```
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter</artifactId>
    </dependency>
```

-5. Agregar el archivo bootstrap.yml en el directorio src/main/resources
    

```
    spring :
      application :
        name : user-service
      cloud:
        config:
          uri: http://localhost:8884
          fail-fast: true
      
```

-6.Agrgar la anotacion @EnableConfigServer en la clase principal


    

            
    






