FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/profiles/src
COPY pom.xml /home/profiles
RUN mvn -f /home/profiles/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/profiles/target/profiles-1.0-RELEASE.jar /home/app/profiles-1.0-RELEASE.jar
ENTRYPOINT ["java", "-jar", "/home/app/profiles-1.0-RELEASE.jar"]