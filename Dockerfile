FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} casanova-back.jar
ENTRYPOINT ["java","-jar","casanova-back.jar"]