package com.northcoders.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.web.servlet.function.RequestPredicates.headers;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests( auth -> {
            auth.requestMatchers("api/v1/protected/greeting").authenticated();
            auth.requestMatchers("api/v1/open/greeting").permitAll();
            auth.requestMatchers(toH2Console()).permitAll();


        })
                .oauth2Login(withDefaults())
                .headers(headers -> headers.frameOptions((frameOptions) -> frameOptions.disable()));
        return http.build();
    }
}
