FROM openjdk:8-jdk-alpine
COPY ./target/wikipediaaction-1.0-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app/
RUN sh -c "touch wikipediaaction-1.0-SNAPSHOT.jar"
ENTRYPOINT ["java", "-jar", "wikipediaaction-1.0-SNAPSHOT.jar"]