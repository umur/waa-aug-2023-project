package com.waa.project.filter;

import com.waa.project.entity.User;
import com.waa.project.repository.UserRepository;
import com.waa.project.service.impl.JwtTokenService;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;
    private final UserRepository userRepository;

    public JwtRequestFilter(JwtTokenService jwtTokenService, UserRepository userRepository) {
        this.jwtTokenService = jwtTokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        // Look for Bearer auth header
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith("Bearer ")) {
            // If the header is missing or does not start with "Bearer ", continue with the filter chain
            chain.doFilter(request, response);
            return;
        }

        // Extract the token from the header
        final String token = header.substring(7);
        // Validate the token and get the username
        final String username = jwtTokenService.validateTokenAndGetUsername(token);
        if (username == null) {
            // Validation failed or token expired, continue with the filter chain
            chain.doFilter(request, response);
            return;
        }

        // Find the user in the database using the email (username) obtained from the token
        final User user = userRepository.findByEmail(username).orElse(null);
        if (user == null) {
            // User not found, continue with the filter chain
            chain.doFilter(request, response);
            return;
        }

        // Create an authentication object with the user and their authorities
        final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                user, null, user.getAuthorities());

        // Set the authentication object in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Continue with the authenticated user
        chain.doFilter(request, response);
    }
}
