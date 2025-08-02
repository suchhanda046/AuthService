package com.example.Auth.jwtUtil;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenGeneraton  {
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expireTime = 1000 * 60 * 60;

    public String generateToken(String username, List<String> roles){
        return Jwts.builder().setSubject(username).claim("roles",roles).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expireTime))
                .signWith(secretKey).compact();
    }
}
