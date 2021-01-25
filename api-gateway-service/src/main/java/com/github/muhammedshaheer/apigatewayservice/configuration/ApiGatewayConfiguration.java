package com.github.muhammedshaheer.apigatewayservice.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Muhammed Shaheer
 * @since 20 January 2021
 */

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/get")
                        .filters(filter -> filter.addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue")
                        )
                        .uri("http://httpbin.org:80")
                )
                .route(p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange-service")
                )
                .route(p -> p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion-service")
                )
                .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion-service")
                )
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(filter -> filter.rewritePath("/currency-conversion-new/", "/currency-conversion-feign/"))
                        .uri("lb://currency-conversion-service")
                )
                .build();
    }
}
