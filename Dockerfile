FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/KMU-PBL-3-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]