FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/orchestrator/src
COPY pom.xml /home/orchestrator
RUN mvn -f /home/orchestrator/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/orchestrator/target/orchestrator-2.0-RELEASE.jar /home/app/orchestrator-2.0-RELEASE.jar
ENTRYPOINT ["java", "-jar", "/home/app/orchestrator-2.0-RELEASE.jar"]