package com.kludge.calculation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for web security settings.
 * This class is responsible for configuring the security aspects of the application,
 * specifically disabling CSRF protection for the application.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    /**
     * Configures the {@link HttpSecurity} to disable CSRF protection.
     * This is typically done for APIs where CSRF protection is not needed or is managed in a different way.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF protection entirely
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}

