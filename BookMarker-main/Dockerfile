# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-jdk-slim-bullseye

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY target/app-3.1.5.jar .

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "app-3.1.5.jar"]
