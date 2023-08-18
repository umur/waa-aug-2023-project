package org.springers.waa_alumniplatform.config;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.enums.Role;
import org.springers.waa_alumniplatform.requestFilter.JwtAuthFilter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecAuthFiltersConfig {

    private final UserDetailsService userDetailsService;
    private final JwtAuthFilter jwtAuthFilter;
    private final LoginFailuerAttemptHandler loginFailuerAttemptHandler;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(authroize -> {
                    authroize.anyRequest().permitAll();
                   authroize
                            .requestMatchers("/auth/**").permitAll()
                            .requestMatchers("/news/**").permitAll()

                            .requestMatchers(HttpMethod.GET,"/alumnus/**").hasAuthority(Role.ALUMNI.name())
                            .requestMatchers(HttpMethod.PUT,"/alumnus/**").hasAuthority(Role.ALUMNI.name())

                            .requestMatchers(HttpMethod.PUT,"/admins/**").hasAuthority(Role.ADMIN.name())
                            .requestMatchers(HttpMethod.GET,"/admins/**").hasAuthority(Role.ADMIN.name())
                            .requestMatchers(HttpMethod.PATCH,"/admins/**").hasAuthority(Role.ADMIN.name())
                            .requestMatchers(HttpMethod.POST,"/admins/**").hasAuthority(Role.ADMIN.name())

                            .requestMatchers(HttpMethod.DELETE, "/users/**")
                                .hasAnyAuthority(Role.ALUMNI.name(), Role.FACULTY.name(), Role.ADMIN.name())
                           .anyRequest().authenticated();
                })
//                .formLogin(httpSecurityFormLoginConfigurer -> {
//                    httpSecurityFormLoginConfigurer
//                            .failureHandler(loginFailuerAttemptHandler)
//                            .loginPage("/auth/login")
////                            .failureUrl("/auth/login")
////                            .failureForwardUrl("/auth/login")
////                            .usernameParameter("userEmail")
//                            .permitAll();
//                })
                .sessionManagement(sessionManager -> {
                    sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .authenticationProvider(this.authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(this.bcryptPasswordEncoder());
        return authenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public AuthenticationEventPublisher authenticationEventPublisher
            (ApplicationEventPublisher applicationEventPublisher) {
        return new DefaultAuthenticationEventPublisher(applicationEventPublisher);
    }
}
