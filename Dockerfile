FROM openjdk:11-jre-slim
EXPOSE 8080
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} casanova-back.jar
ENTRYPOINT ["java","-jar","/casanova-back.jar"]
#
#FROM adoptopenjdk/openjdk11:ubi
#RUN mkdir /opt/app
#COPY japp.jar /opt/app
#CMD ["java", "-jar", "/opt/app/japp.jar"]