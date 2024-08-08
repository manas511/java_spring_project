# Start with a base image containing Java runtime
FROM openjdk:17-jdk

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's JAR file
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar

# Add the application's JAR file to the container
ADD ${JAR_FILE} app.jar

# Run the JAR file
ENTRYPOINT ["java","-jar","/app.jar"]