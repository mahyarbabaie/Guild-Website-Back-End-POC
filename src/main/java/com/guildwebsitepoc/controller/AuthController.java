package com.guildwebsitepoc.controller;


import com.guildwebsitepoc.exception.AccountPasswordMismatchException;
import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.model.GenericResponse;
import com.guildwebsitepoc.model.JwtUser;
import com.guildwebsitepoc.model.JwtUserDetails;
import com.guildwebsitepoc.security.JwtGenerator;
import com.guildwebsitepoc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/guildwebsitepoc/AuthService")
public class AuthController {

    @Autowired
    private AccountService accountService;

    @Autowired
    JwtGenerator jwtGenerator;

    // POST a new account
    @PostMapping("/register")
    public ResponseEntity<GenericResponse> addAccount(@RequestBody Account account) {
        // if they pass an id, then set it to 0
        // This will insure a new account is created instead of update due to: "currentSession.saveOrUpdate()"
        account.setAccountId(0);
        // Create new account in database
        accountService.save(account);

        GenericResponse accountCreationResponse = new GenericResponse(HttpStatus.OK.value(),
                                                             "Account Created Successfully",
                                                                      System.currentTimeMillis());

        return new ResponseEntity<>(accountCreationResponse, HttpStatus.OK);
    }

    // Post login with existing account
    @PostMapping("/login")
    public JwtUserDetails loginAccount(@RequestBody JwtUser jwtUser) {
        Account expectedAccount = accountService.findByUsername(jwtUser.getUsername());
        boolean passwordMatch = accountService.verifyPassword(jwtUser.getPassword(),
                expectedAccount.getPasswordSalt(),
                expectedAccount.getPasswordHash());
        if (!passwordMatch) {
            throw new AccountPasswordMismatchException("Password does not match");
        }

        JwtUserDetails jwtUserDetails = new JwtUserDetails(expectedAccount.getUsername(),
                                            expectedAccount.getAccountId(),
                                            jwtGenerator.generate(jwtUser),
                            null);
        return jwtUserDetails;
    }
}