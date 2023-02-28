package com.example.PortfolioAPI;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
        registry.addMapping("/**")
                .allowedOrigins("https://luca-pagnossin-front-end.firebaseapp.com", "https://luca-pagnossin-front-end.web.app")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
