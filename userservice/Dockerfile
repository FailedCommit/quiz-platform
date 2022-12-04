FROM eclipse-temurin:17-jre

VOLUME /tmp
ARG JAR_FILE=build/libs/userservice-*.jar
COPY ${JAR_FILE} userservice.jar

EXPOSE 8091

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=aws", "/userservice.jar"]