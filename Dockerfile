# Use Java 21 JDK
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy the Maven project (all files)
COPY . .

# Build the project inside Docker (skip tests)
RUN ./mvnw clean package -DskipTests

# Copy the built JAR to root
RUN cp target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose Spring Boot port
EXPOSE 3333

# Run the app
ENTRYPOINT ["java","-jar","app.jar"]
