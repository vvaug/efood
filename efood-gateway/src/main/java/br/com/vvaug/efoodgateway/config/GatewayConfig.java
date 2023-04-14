package br.com.vvaug.efoodgateway.config;

import br.com.vvaug.efoodgateway.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
public class GatewayConfig {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("efood-login", r -> r.path("/login/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8084"))
                .route("efood-register", r -> r.path("/register/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8085"))
                .route("efood-stores", r -> r.path("/stores/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8086"))
                .build();
    }

}