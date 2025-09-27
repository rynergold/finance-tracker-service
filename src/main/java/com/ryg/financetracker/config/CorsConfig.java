package com.ryg.financetracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class CorsConfig implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/")
            .allowedOrigins("http://localhost:3000", "http://localhost:5173")
            .allowedMethods("*")
            .allowedHeaders("*");
    }
}

