package com.guildwebsitepoc.controller;


import com.guildwebsitepoc.exception.AccountPasswordMismatchException;
import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.model.GenericResponse;
import com.guildwebsitepoc.model.JwtUser;
import com.guildwebsitepoc.model.JwtUserDetails;
import com.guildwebsitepoc.service.AccountService;
import com.guildwebsitepoc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/guildwebsitepoc/AuthService")
public class AuthController {

    @Value("spring.security.secret")
    private String secret;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthService authService;

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
        Account expectedAccount = accountService.findByEmail(jwtUser.getEmail());
        boolean passwordMatch = accountService.verifyPassword(jwtUser.getPassword(),
                expectedAccount.getPasswordSalt(),
                expectedAccount.getPasswordHash());
        if (!passwordMatch) {
            throw new AccountPasswordMismatchException("Password does not match");
        }

        return authService.createUserJwtToken(jwtUser);
    }

    // utility api to generate new accessToken
    @PostMapping("/token")
    public JwtUserDetails createJwtTokens(@RequestBody JwtUser jwtUser) {
        return authService.createUserJwtToken(jwtUser);
    }
}
