FROM openjdk:11
WORKDIR currency-exchange-service
ADD target/currency-exchange-service-0.0.1-SNAPSHOT.jar currency-exchange-service.jar
ENTRYPOINT ["java", "-jar", "currency-exchange-service.jar"]