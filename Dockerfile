FROM openjdk:8-jre-alpine

EXPOSE 9900

ARG JAR=build/libs
COPY ${JAR}/ClubMileage-0.0.1-SNAPSHOT.jar /server.jar

ENTRYPOINT ["java","-jar","/server.jar"]
