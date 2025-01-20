package com.scheduler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
  
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir todos os endpoints
            .allowedOrigins("http://localhost:4200") // Permitir apenas a origem do Angular
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
            .allowedHeaders("*") // Permitir todos os cabeçalhos
            .allowCredentials(true); // Permitir envio de cookies ou autenticação
      }
    };
  }
}
