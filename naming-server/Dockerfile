FROM openjdk:11
WORKDIR naming-server
ADD target/naming-server-0.0.1-SNAPSHOT.jar naming-server.jar
ENTRYPOINT ["java", "-jar", "naming-server.jar"]