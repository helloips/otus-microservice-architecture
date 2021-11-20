FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/metrics/src
COPY pom.xml /home/metrics
RUN mvn -f /home/metrics/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/metrics/target/metrics-1.0-RELEASE.jar /home/app/metrics-1.0-RELEASE.jar
ENTRYPOINT ["java", "-jar", "/home/app/metrics-1.0-RELEASE.jar"]