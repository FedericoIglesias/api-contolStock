FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/controlStock-0.0.1.jar
COPY ${JAR_FILE} app_controlStock.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_controlStock.jar"]