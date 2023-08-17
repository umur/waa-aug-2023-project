package com.example.springproject.config;


import com.example.springproject.entity.Constants;
import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {


    public String extractEmailFromJWT(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);
    }

    public <T> T extractClaim(String jwtToken, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(jwtToken);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String jwtToken) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyAsBytes = Base64.getDecoder().decode(Constants.SecretKey);
        return Keys.hmacShaKeyFor(keyAsBytes);
    }

    public String generateJWTToken(Map<String, Object> claimsMap, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(claimsMap)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS512)
                .compact();
    }


    public String generateJWTToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.ROLE, userDetails.getAuthorities());
        return generateJWTToken(claims, userDetails);
    }

    public boolean isTokenValid(String jwtToken, UserDetails userDetails) {
        final String email = extractEmailFromJWT(jwtToken);
        return email.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken);
    }

    private boolean isTokenExpired(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date());
    }

    private Date extractExpiration(String jwtToken) {
        return extractClaim(jwtToken, Claims::getExpiration);
    }


}
