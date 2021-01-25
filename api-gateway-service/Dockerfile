FROM openjdk:11
WORKDIR api-gateway-service
ADD target/api-gateway-service-0.0.1-SNAPSHOT.jar api-gateway-service.jar
ENTRYPOINT ["java", "-jar", "api-gateway-service.jar"]