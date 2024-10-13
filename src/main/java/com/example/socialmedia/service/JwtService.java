package com.example.socialmedia.service;

import com.example.socialmedia.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Use a strong secret key
    private final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds

    // Generate token
    public String generateToken(UserEntity userEntity) {
        JwtBuilder builder = Jwts.builder()
                .setSubject(String.valueOf(userEntity.getId()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY);
        System.out.println("JWT" + SECRET_KEY.toString());
        return builder.compact();
    }

    // Validate token
    public boolean validateToken(String token, String username) {
        final String tokenUsername = extractId(token);
        return (username.equals(tokenUsername) && !isTokenExpired(token));
    }

    // Extract username
    public String extractId(String token) {
        return extractAllClaims(token).getSubject();
    }

    // Check if token is expired
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    // Extract claims
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
