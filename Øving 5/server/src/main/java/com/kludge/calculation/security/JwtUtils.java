package com.kludge.calculation.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateJwtToken(Authentication authentication) {
        // Current time
        Date now = new Date();
        // Calculate expiration time (5 minutes)
        Date expiryDate = new Date(now.getTime() + 300000); // 300000 milliseconds = 5 minutes

        // Convert the secret string to a SecretKey object
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        return Jwts.builder()
                .setSubject((authentication.getName()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS512) // Updated to use the Key object
                .compact();
    }
}
