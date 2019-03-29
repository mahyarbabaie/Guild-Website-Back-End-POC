package com.guildwebsitepoc.controller;

import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.base.url}")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // GET all accounts
    @GetMapping("/accounts")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    // GET an account by accountId
    @GetMapping("/accounts/{accountId}")
    public Account getAccount(@PathVariable int accountId) {
        Account account = accountService.findById(accountId);

        if (account == null) {
            throw new RuntimeException("Account id not found - " + accountId);
        }
        return account;
    }

    // POST a new account
    @PostMapping("/accounts")
    public Account addAccount(@RequestBody Account account) {
        // if they pass an id, then set it to 0
        // This will insure a new account is created instead of update due to: "currentSession.saveOrUpdate()"
        account.setAccountId(0);
        // Create new account in database
        accountService.save(account);

        return account;
    }

    // PUT an existing account's information
    @PutMapping("/accounts")
    public Account updateAccount(@RequestBody Account account) {
        accountService.save(account);

        return account;
    }

    // DELETE an account by accountId
    @DeleteMapping("/accounts/{accountId}")
    public String deleteAccount(@PathVariable int accountId) {
        // Grab the account
        Account account = accountService.findById(accountId);
        // throw exception if account is null
        if (account == null) {
            throw new RuntimeException("Account id not found - " + accountId);
        }

        accountService.deleteById(accountId);

        return "Deleted account id - " + accountId;
    }

}
