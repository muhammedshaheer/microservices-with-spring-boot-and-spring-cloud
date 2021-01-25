FROM openjdk:11
WORKDIR currency-conversion-service
ADD target/currency-conversion-service-0.0.1-SNAPSHOT.jar currency-conversion-service.jar
ENTRYPOINT ["java", "-jar", "currency-conversion-service.jar"]