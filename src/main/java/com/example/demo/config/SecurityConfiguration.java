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
        http.csrf().disable().cors()
                // Allow all requests without authentication
                .and().authorizeRequests().anyRequest().permitAll()
                // Disable session creation (we'll use stateless tokens instead)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
//         http
//                 .csrf()
//                 .disable()
//                 .authorizeHttpRequests()
//                 .requestMatchers("/api/authenticate/**","/register/**","/api/posts")
//                 .permitAll()
//                 .requestMatchers(HttpMethod.DELETE,"/users/{userId}").hasAuthority("ADMIN")
//                 .requestMatchers(HttpMethod.DELETE,"/posts/{postId}").hasAnyAuthority("AUTHOR","ADMIN")
//                 .requestMatchers("/users/{userId}/posts").hasAnyAuthority("AUTHOR","ADMIN")
//                 .anyRequest()
//                 .authenticated()
//                 .and()
//                 .sessionManagement()
//                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                 .and()
//                 .authenticationProvider(authenticationProvider)
//                 .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
    }
}
