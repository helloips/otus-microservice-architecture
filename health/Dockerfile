FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/health/src
COPY pom.xml /home/health
RUN mvn -f /home/health/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/health/target/health-1.0-RELEASE.jar /home/app/health-1.0-RELEASE.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/home/app/health-1.0-RELEASE.jar"]