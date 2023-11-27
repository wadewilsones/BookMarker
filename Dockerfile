# Use a base image with Java (JDK) installed
FROM eclipse-temurin:17-jdk-focal

# Set the working directory
WORKDIR /app

# Copy the .class files into the container
COPY target/classes/com /app

# Create a JAR file from the compiled classes
RUN jar cvf app.jar .

# Optional: Remove the .class files to reduce the image size
RUN rm -rf com

# Expose the port your application will run on
EXPOSE 8080

# Command to run the application when the container starts
CMD ["java", "-jar", "app.jar"]