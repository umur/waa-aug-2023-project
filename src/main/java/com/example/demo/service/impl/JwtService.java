package com.example.demo.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "4B6150645367566B597033733676397924423F4528482B4D6251655468576D5A";
    public String extractUsername(String jwt) {

//        return extractClaim(jwt,Claims::getSubject);
        return Jwts.parser().setSigningKey(getSigningKey()).parseClaimsJws(jwt).getBody().getSubject();
    }

    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails) {
//        return Jwts.builder()
//                .setClaims(extraClaims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
//                .signWith(SignatureAlgorithm.HS256, getSigningKey())
//                .compact();
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(SignatureAlgorithm.HS256, getSigningKey())
                .compact();

    }
    public String generateToken(UserDetails userDetails) {

//        return generateToken(new HashMap<>(),userDetails);
        return generateToken(new HashMap<>(), userDetails);
    }
    public boolean isTokenValid(String token,UserDetails userDetails) {
//        String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
////        assert extractExpiration(token) != null;
//        return extractExpiration(token).before(new Date());
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(getSigningKey()).parseClaimsJws(token).getBody();
    }

//    private Date extractExpiration(String token) {
//        return extractClaim(token,Claims::getExpiration);
//    }

//    public <T> T extractClaim(String token, Function<Claims,T>claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//    private Claims extractAllClaims(String token) {
////        return Jwts.parserBuilder()
////                .setSigningKey(getSigningKey())
////                .build()
////                .parseClaimsJws(token)
////                .getBody();
//        return null;
//    }

    private Key getSigningKey() {
        byte[] keyByes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyByes);
    }
}
