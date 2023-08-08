package com.waa.project.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtTokenService {
    String generateToken(final UserDetails userDetails);
    String validateTokenAndGetUsername(final String token);
}
