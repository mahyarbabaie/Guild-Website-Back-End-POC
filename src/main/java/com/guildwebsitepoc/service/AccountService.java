package com.guildwebsitepoc.service;

import com.guildwebsitepoc.model.Account;

import java.util.List;

public interface AccountService {

    // GET all
    public List<Account> findAll();

    // GET specific
    public Account findById(int accountId);

    // CREATE and UPDATE
    public void save(Account account);

    // DELETE
    public void deleteById(int accountId);
}
