FROM openjdk:17

ARG JAR_FILE=./target/*.jar

EXPOSE 8080

COPY ${JAR_FILE} aws-project01.jar

ENTRYPOINT ["java", "-jar", "aws-project01.jar"]