package com.guildwebsitepoc.service;

import com.guildwebsitepoc.model.JwtUser;
import com.guildwebsitepoc.model.JwtUserDetails;

public interface AuthService {

    JwtUserDetails createUserJwtToken(JwtUser jwtUser);
}
