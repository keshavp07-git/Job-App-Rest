package com.keshav.Job.App.Rest.service;

import org.springframework.context.annotation.Bean;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import java.net.http.HttpRequest;

@Component
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // Changing Security Filter
        http
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated()) // Putting Restriction to access data
                .oauth2Login(Customizer.withDefaults()); // Telling about the Oauth2 Client
        return http.build();
    }
}
