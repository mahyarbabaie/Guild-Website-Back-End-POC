package com.guildwebsitepoc.controller;


import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.model.JwtUser;
import com.guildwebsitepoc.security.JwtGenerator;
import com.guildwebsitepoc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guildwebsitepoc/AuthService")
public class AuthController {

    @Autowired
    private AccountService accountService;

    @Autowired
    JwtGenerator jwtGenerator;

    // POST a new account
    @PostMapping("/register")
    public Account addAccount(@RequestBody Account account) {
        // if they pass an id, then set it to 0
        // This will insure a new account is created instead of update due to: "currentSession.saveOrUpdate()"
        account.setAccountId(0);
        // Create new account in database
        accountService.save(account);

        return account;
    }

    // Post login with existing account
    @PostMapping("/login")
    public String loginAccount(@RequestBody JwtUser jwtUser) {
        Account expectedAccount = accountService.findByUsername(jwtUser.getUsername());
        boolean passwordMatch = accountService.verifyPassword(jwtUser.getPassword(),
                expectedAccount.getPasswordSalt(),
                expectedAccount.getPasswordHash());
        if (!passwordMatch) {
            throw new RuntimeException("Password does not match");
        }

        return jwtGenerator.generate(jwtUser);
    }
}
