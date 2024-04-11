FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/joyapi-0.0.1-SNAPSHOT.jar joyapi-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "joyapi-0.0.1-SNAPSHOT.jar"]