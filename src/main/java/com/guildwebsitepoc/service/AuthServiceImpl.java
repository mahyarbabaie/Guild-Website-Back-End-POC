package com.guildwebsitepoc.service;

import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.model.JwtUser;
import com.guildwebsitepoc.model.JwtUserDetails;
import com.guildwebsitepoc.security.JwtGenerator;
import com.guildwebsitepoc.security.JwtValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    JwtGenerator jwtGenerator;

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtValidator jwtValidator;

    @Override
    public JwtUserDetails createUserJwtToken(JwtUser jwtUser, Account expectedAccount) {

        long randomGeneratedId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        // Grabs the issued and expired date
        String jwtAccessToken = jwtGenerator.generateAccessToken(jwtUser);
        JwtUser jwtUserWithToken = jwtValidator.validate(jwtAccessToken);

        JwtUserDetails jwtUserDetails = new JwtUserDetails(
                expectedAccount.getUsername(),
                randomGeneratedId,
                jwtAccessToken,
                expectedAccount.getRole(),
                null,
                jwtUserWithToken.getIssuedDate(),
                jwtUserWithToken.getExpiredDate());

        return jwtUserDetails;
    }

    @Override
    public JwtUserDetails createUserJwtToken(JwtUser jwtUser) {

        Account expectedAccount = accountService.findByEmail(jwtUser.getEmail());
        return createUserJwtToken(jwtUser, expectedAccount);
    }
}
