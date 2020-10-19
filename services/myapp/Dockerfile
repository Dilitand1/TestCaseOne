FROM openjdk:8-jdk-alpine
#за основу взята 8 версия джавы
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar

COPY TestCaseOne-jar-with-dependencies.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

