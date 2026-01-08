# Use Eclipse Temurin JDK 21 (lightweight Alpine image)
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR from your project
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that Spring Boot runs on
EXPOSE 3333

# Set environment variables for database (optional if using Render ENV vars)
# ENV DB_HOST=your-db-host
# ENV DB_PORT=3306
# ENV DB_NAME=your-db-name
# ENV DB_USER=your-db-user
# ENV DB_PASSWORD=your-db-password

# Command to run the Spring Boot app
ENTRYPOINT ["java","-jar","app.jar"]
