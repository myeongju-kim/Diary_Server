package com.kingmj.api.account.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
  @Value("${jwt.token.secret}")
  private String secretKey;
  @Value("${jwt.token.time}")
  private Integer time;
  public String createToken() {
    // jwt time
    Long tokenExpired= Duration.ofMinutes(time).toMillis();
    // jwt header setting
    Map<String, Object> headers=new HashMap<>();
    headers.put("typ","JWT");
    headers.put("alg","HS256");
    // jwt payloads setting
    Map<String, Object> payloads = new HashMap<>();
    payloads.put("Name", "킹명주");
    // jwt create date
    Date now = new Date();
    // return json web token
    return Jwts.builder()
        .setHeader(headers)
        .setClaims(payloads)
        .setIssuedAt(now)
        .setExpiration(new Date(now.getTime()+tokenExpired))
        .signWith(SignatureAlgorithm.HS256,secretKey)
        .compact();
  }
}
