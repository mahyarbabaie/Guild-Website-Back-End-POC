package com.guildwebsitepoc.controller;

import com.guildwebsitepoc.model.JwtUser;
import com.guildwebsitepoc.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guildwebsitepoc")
public class TokenController {

    @Autowired
    JwtGenerator jwtGenerator;

    @PostMapping("/token")
    public String generate(@RequestBody final JwtUser jwtUser) {
        return jwtGenerator.generate(jwtUser);
    }
}
