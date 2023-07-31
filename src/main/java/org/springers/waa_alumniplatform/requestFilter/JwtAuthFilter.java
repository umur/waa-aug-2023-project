package org.springers.waa_alumniplatform.requestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.service.JwtService;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    //    1. Check if there is a jwt token
//    2. Extract Email from JWT so can retrieve the user from DB using email
//    3. Validate the token
//    4. Register the User as authenticated user with SpringSecurityContext, so that the user with that token won't need a validation
//    5. Pass the request to the controller, if everything is fine
    @Override
    protected void doFilterInternal(
           @NonNull HttpServletRequest request,
           @NonNull HttpServletResponse response,
           @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String token = this.extractToken(authHeader);
        final String userEmail;
        final boolean userNotAuthenticatedAlready = SecurityContextHolder.getContext().getAuthentication() == null;

        if(token == null) {
            filterChain.doFilter(request, response);
            return;
        }
        userEmail = jwtService.getEmailFromToken(token);
        if(userEmail != null && userNotAuthenticatedAlready){
            if(jwtService.isTokenValid(token)){
                this.registerUserInAuthContext(userEmail);
            }
        }
        filterChain.doFilter(request, response);
    }

    private void registerUserInAuthContext(String userEmail) {
        Authentication usernamePasswordAuthToken = jwtService.getUsernamePasswordAuthToken(userEmail);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthToken);
    }

    private String extractToken(String authHeader) {
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            return authHeader.substring(7);
        }
        return null;
    }
}
