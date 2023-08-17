package com.example.springproject.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JWTAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;


    

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        		.cors().disable()
        		.csrf().disable()
                .authorizeRequests()
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Allow all OPTIONS requests
                .requestMatchers("/admin/**").permitAll()
                .requestMatchers("/admin/student/**").permitAll()
                .requestMatchers("/student/**").permitAll()
                .requestMatchers("/job/**").permitAll()
                .requestMatchers("/event/**").permitAll()
                .requestMatchers("/news/**").permitAll()
                .requestMatchers("/survey/**").permitAll()
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/users/**").permitAll()
                .requestMatchers("/api/applications/**").permitAll()
                .requestMatchers("/api/products/**").hasAuthority("ADMIN")
                .requestMatchers("/api/addresses/**").hasAuthority("ADMIN")
                .requestMatchers("/api/advertisements/**").permitAll()
                .requestMatchers("/api/categories/**").hasAuthority("ADMIN")
                .requestMatchers("/api/comments/**").hasAuthority("ADMIN")
                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                .requestMatchers("/admin/news/**").hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider)
                .exceptionHandling()
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    // Log the access denied exception
                    System.out.println("Access Denied: " + accessDeniedException.getMessage());
                    accessDeniedException.printStackTrace();
                });;

        return httpSecurity.build();
    }
}

