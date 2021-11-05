FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/promo/src
COPY pom.xml /home/promo
RUN mvn -f /home/promo/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/promo/target/promo-2.0-RELEASE.jar /home/app/promo-2.0-RELEASE.jar
ENTRYPOINT ["java", "-jar", "/home/app/promo-2.0-RELEASE.jar"]