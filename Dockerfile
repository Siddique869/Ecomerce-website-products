# Step 1: Build the application using Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Run the application using Java 21 JRE
FROM eclipse-temurin:21-jre
WORKDIR /app
# This copies the generated WAR file to the runtime image
COPY --from=build /target/*.war app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.war"]
