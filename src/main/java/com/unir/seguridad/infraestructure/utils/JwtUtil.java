package com.unir.seguridad.infraestructure.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;


@Component
public class JwtUtil {

  @Value("${jwt.secret}")
  private String jwtSecret;

  public String generateToken(UserDetails userDetails) {
    Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    return Jwts.builder()
        .setSubject(userDetails.getUsername())
        .claim("roles", userDetails.getAuthorities())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 86400000))
        .signWith(key, SignatureAlgorithm.HS512)
        .compact();
  }

}
