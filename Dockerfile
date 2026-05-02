# Step 1: Build the application
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Run the application
FROM eclipse-temurin:21-jre
WORKDIR /app
# This line matches the artifactId and version in your pom.xml
COPY --from=build /target/e-comerse-web-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
