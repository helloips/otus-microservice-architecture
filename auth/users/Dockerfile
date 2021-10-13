FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/users/src
COPY pom.xml /home/users
RUN mvn -f /home/users/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/users/target/users-1.0-RELEASE.jar /home/app/users-1.0-RELEASE.jar
ENTRYPOINT ["java", "-jar", "/home/app/users-1.0-RELEASE.jar"]