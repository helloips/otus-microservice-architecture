FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/contract/src
COPY pom.xml /home/contract
RUN mvn -f /home/contract/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/contract/target/contract-2.0-RELEASE.jar /home/app/contract-2.0-RELEASE.jar
ENTRYPOINT ["java", "-jar", "/home/app/contract-2.0-RELEASE.jar"]