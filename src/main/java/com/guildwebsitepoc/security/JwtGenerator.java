package com.guildwebsitepoc.security;

import com.guildwebsitepoc.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class JwtGenerator {

    @Value("${spring.security.secret}")
    private String secret;

    @Value("${spring.security.jwt.accesstoken.expiration}")
    private String accessTokenJwtExpiration;

    public String generateAccessToken(JwtUser jwtUser) {
        Claims claims = Jwts.claims().setSubject(jwtUser.getUsername());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());

        Calendar expirationTime = Calendar.getInstance();
        expirationTime.add(Calendar.HOUR, Integer.valueOf(accessTokenJwtExpiration));

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Calendar.getInstance().getTime())
                .setExpiration(expirationTime.getTime())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
