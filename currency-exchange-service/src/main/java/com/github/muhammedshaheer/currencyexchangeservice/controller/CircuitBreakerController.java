package com.github.muhammedshaheer.currencyexchangeservice.controller;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Muhammed Shaheer
 * @since 20 January 2021
 */

@RestController
public class CircuitBreakerController {
    private static final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    public String sampleApi() {
        logger.info("Sample API Call received");
        ResponseEntity<String> stringResponseEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy", String.class);
        return stringResponseEntity.getBody();
    }

    @GetMapping("sample-api-circuit")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    public String sampleApiCircuit() {
        logger.info("Sample API Call received");
        ResponseEntity<String> stringResponseEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy", String.class);
        return stringResponseEntity.getBody();
    }

    private String hardcodedResponse(Exception exception) {
        return "Fallback Response";
    }
}
