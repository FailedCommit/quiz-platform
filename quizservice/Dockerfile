FROM eclipse-temurin:17-jre

VOLUME /tmp
ARG JAR_FILE=build/libs/quizservice-*.jar
COPY ${JAR_FILE} quizservice.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=aws", "/quizservice.jar"]
