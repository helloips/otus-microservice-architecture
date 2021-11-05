FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/course/src
COPY pom.xml /home/course
RUN mvn -f /home/course/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/course/target/course-2.0-RELEASE.jar /home/app/course-2.0-RELEASE.jar
ENTRYPOINT ["java", "-jar", "/home/app/course-2.0-RELEASE.jar"]