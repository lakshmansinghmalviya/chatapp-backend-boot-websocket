# Stage 1: Build JAR
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /chatapp
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the JAR
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /chatapp
COPY --from=build /chatapp/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
