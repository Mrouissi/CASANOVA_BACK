FROM openjdk:11-jre-slim
EXPOSE 8080
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} casanova-back.jar
ENTRYPOINT ["java","-jar","/casanova-back.jar"]