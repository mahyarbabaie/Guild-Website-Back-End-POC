package com.guildwebsitepoc.security;

import com.guildwebsitepoc.exception.JwtTokenExpiredException;
import com.guildwebsitepoc.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    @Value("${spring.security.secret}")
    private String secret;

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;

        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            jwtUser = new JwtUser();
            jwtUser.setUsername(body.getSubject());
            jwtUser.setId(Integer.parseInt((String)body.get("userId")));
            jwtUser.setRole((String)body.get("role"));
            jwtUser.setIssuedDate(body.getIssuedAt().toString());
            jwtUser.setExpiredDate(body.getExpiration().toString());

        } catch (ExpiredJwtException e) {
            throw new JwtTokenExpiredException("Your JWT Token is expired. Please generate a new one");
        } catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
