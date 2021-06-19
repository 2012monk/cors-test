package com.complete.cors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("http://localhost:47788", "http://localhost:8080", "http://127.0.0.1:5500")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("*")
                .exposedHeaders("*")
                .maxAge(3600L);
    }
}
