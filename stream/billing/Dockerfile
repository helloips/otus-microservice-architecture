FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/billing/src
COPY pom.xml /home/billing
RUN mvn -f /home/billing/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/billing/target/billing-1.0-RELEASE.jar /home/app/billing-1.0-RELEASE.jar
ENTRYPOINT ["java", "-jar", "/home/app/billing-1.0-RELEASE.jar"]