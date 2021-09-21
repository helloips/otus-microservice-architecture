FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/crud/src
COPY pom.xml /home/crud
RUN mvn -f /home/crud/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/crud/target/crud-1.0-RELEASE.jar /home/app/crud-1.0-RELEASE.jar
ENTRYPOINT ["java", "-jar", "/home/app/crud-1.0-RELEASE.jar"]