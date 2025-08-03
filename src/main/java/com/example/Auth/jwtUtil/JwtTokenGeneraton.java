package com.example.Auth.jwtUtil;


import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenGeneraton  {
    Dotenv dotenv = Dotenv.load();
    String jwtKey = dotenv.get("JWT_SECRET");

    private final SecretKey secretKey = Keys.hmacShaKeyFor(jwtKey.getBytes());
    private final long expireTime = 1000 * 60 * 60;

    public String generateToken(String username, List<String> roles){
        return Jwts.builder().setSubject(username).claim("roles",roles).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expireTime))
                .signWith(secretKey).compact();
    }
}
