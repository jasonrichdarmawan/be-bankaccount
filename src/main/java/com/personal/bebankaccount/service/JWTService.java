package com.personal.bebankaccount.service;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Calendar;

@Service
public class JWTService {
  @Value("${jwt.secret}")
  private String jwtSecret;

  public String generate(String accountNumber, String userID) {
    SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));

    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MINUTE, 10);

    return Jwts.builder()
            .claim("Account_Number", accountNumber)
            .claim("User_ID", userID)
            .setExpiration(calendar.getTime())
            .signWith(key)
            .compact();
  }

  public boolean isValid(String token) {
    SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));

    try {
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;
    } catch (JwtException e) {
      return false;
    }
  }
}
