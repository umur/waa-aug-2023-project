package com.example.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
                 .csrf()
                 .disable()
                 .authorizeHttpRequests()
                 .requestMatchers("/users/login/**","/users/register/**")
                 .permitAll()
                 .requestMatchers(HttpMethod.DELETE,"/users/{userId}").hasAuthority("ADMIN")
                 .requestMatchers(HttpMethod.GET,"/eventParticipants").hasAuthority("ADMIN")
                 .requestMatchers(HttpMethod.POST, "/events/**").hasAuthority("ADMIN")
                 .requestMatchers(HttpMethod.PUT, "/events/**").hasAuthority("ADMIN")
                 .requestMatchers(HttpMethod.DELETE, "/events/**").hasAuthority("ADMIN")
                 .requestMatchers(HttpMethod.POST, "/news/**").hasAuthority("ADMIN")
                 .requestMatchers(HttpMethod.PUT, "/news/**").hasAuthority("ADMIN")
                 .requestMatchers(HttpMethod.DELETE, "/news/**").hasAuthority("ADMIN")
                 .requestMatchers( "/surveys/questions/*/answers/**").hasAnyAuthority("ADMIN","STUDENT", "FACULTY")
                 .requestMatchers(HttpMethod.POST, "/surveys/**").hasAuthority("ADMIN")
                 .requestMatchers(HttpMethod.PUT, "/surveys/**").hasAuthority("ADMIN")
                 .requestMatchers(HttpMethod.DELETE, "/surveys/**").hasAuthority("ADMIN")

                 .anyRequest()
                 .authenticated()
                 .and()
                 .sessionManagement()
                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                 .and()
                 .authenticationProvider(authenticationProvider)
                 .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
