FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/joyapi.jar joyapi.jar
EXPOSE 8080
CMD ["java", "-jar", "joyapi.jar"]