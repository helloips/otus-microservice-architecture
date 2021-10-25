FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/orders/src
COPY pom.xml /home/orders
RUN mvn -f /home/orders/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/orders/target/orders-1.0-RELEASE.jar /home/app/orders-1.0-RELEASE.jar
ENTRYPOINT ["java", "-jar", "/home/app/orders-1.0-RELEASE.jar"]