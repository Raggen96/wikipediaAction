FROM openjdk:8-jdk-alpine
COPY ./target/wikipediaAction-1.0-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app/
RUN sh -c "touch wikipediaAction-1.0-SNAPSHOT.jar"
ENTRYPOINT ["java", "-jar", "wikipediaAction-1.0-SNAPSHOT.jar"]