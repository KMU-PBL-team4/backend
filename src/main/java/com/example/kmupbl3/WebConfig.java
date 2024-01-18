package com.example.kmupbl3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("CORS Registry assign 2");
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
//                .allowCredentials(true);
        log.info("CORS registry assign finished");
    }
}

