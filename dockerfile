FROM openjdk:8-jdk-alpine
#за основу взята 8 версия джавы
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#запуск
#docker run --rm -p 8080:8080 springapp1