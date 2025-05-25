package edu.uptc.swii.login_service.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // o /** para todos
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("*") // GET, POST, etc.
                .allowedHeaders("*");
    }
}
