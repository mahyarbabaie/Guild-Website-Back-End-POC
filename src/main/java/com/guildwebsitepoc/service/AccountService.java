package com.guildwebsitepoc.service;

import com.guildwebsitepoc.model.Account;

import java.util.List;

public interface AccountService {

    // GET all
    List<Account> findAll();

    // GET specific
    Account findById(int accountId);

    // CREATE and UPDATE
    void save(Account account);

    // DELETE
    void deleteById(int accountId);

    // GET username
    Account findByUsername(String username);

    // Validate passowrd
    boolean verifyPassword(String password, String salt, String expectedHash);

}
