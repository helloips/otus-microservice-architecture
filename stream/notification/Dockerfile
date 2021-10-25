FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/notification/src
COPY pom.xml /home/notification
RUN mvn -f /home/notification/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/notification/target/notification-1.0-RELEASE.jar /home/app/notification-1.0-RELEASE.jar
ENTRYPOINT ["java", "-jar", "/home/app/notification-1.0-RELEASE.jar"]