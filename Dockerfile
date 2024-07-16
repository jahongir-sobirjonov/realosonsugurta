# Stage 1: Build the application
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/RealOsonSugurta-0.0.1-SNAPSHOT.jar osonsugurta.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "osonsugurta.jar"]
