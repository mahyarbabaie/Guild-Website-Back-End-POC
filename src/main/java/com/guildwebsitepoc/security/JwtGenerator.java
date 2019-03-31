package com.guildwebsitepoc.security;

import com.guildwebsitepoc.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    @Value("${spring.security.secret}")
    private String secret;

    public String generate(JwtUser jwtUser) {
        Claims claims = Jwts.claims().setSubject(jwtUser.getUsername());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
