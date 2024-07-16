# Stage 1: Build the application
FROM maven:3.8.6-openjdk-17 AS build
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17.0.2-jdk-slim
COPY --from=build /app/target/realosonsugurta-0.0.1-SNAPSHOT.jar realosonsugurta.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","realosonsugurta.jar"]
