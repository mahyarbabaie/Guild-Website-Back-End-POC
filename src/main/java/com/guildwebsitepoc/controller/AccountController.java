package com.guildwebsitepoc.controller;

import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.base.url}" + "/AccountsService")
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



    // PUT an existing account's information
    @PutMapping("/accounts/{accountId}")
    public Account updateAccount(@PathVariable int accountId,
                                 @RequestBody Account account) {
        Account initialAccount = accountService.findById(accountId);
        if (initialAccount.getAccountId() != account.getAccountId()) {
            throw new RuntimeException("AccountId does not match the desired account for updating");
        }
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
