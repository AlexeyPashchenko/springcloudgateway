package com.example.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Locale;

@Configuration
@Slf4j
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        log.info("Created bean!");
        return builder.routes()
                .route("route_1", r -> r.path("/hidden")
                        .filters(f -> f.modifyResponseBody(String.class, String.class,
                                (exchange, s) -> Mono.just(s.toUpperCase(Locale.ROOT))))
                        .uri("http://localhost:8085"))
                .build();
    }
}
