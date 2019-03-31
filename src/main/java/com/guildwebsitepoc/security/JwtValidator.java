package com.guildwebsitepoc.security;

import com.guildwebsitepoc.model.JwtUser;
import io.jsonwebtoken.Claims;
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
        } catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
