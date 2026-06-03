package com.example.micro_academico.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.context.annotation.Bean;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient estudiantesWebClient() {
        return WebClient.builder().baseUrl("http://localhost:5002/estudiantes").build();
    }
}