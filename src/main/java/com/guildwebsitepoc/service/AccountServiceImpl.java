package com.guildwebsitepoc.service;

import com.guildwebsitepoc.dao.AccountRepository;
import com.guildwebsitepoc.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() { return accountRepository.findAll(); }

    @Override
    public Account findById(int accountId) {
        // "Optional<T>" checks for nulls
        Optional<Account> result = accountRepository.findById(accountId);
        // Declaring an account;
        Account account = null;

        if (result.isPresent()) {
            account = result.get();
        } else {
            // we didn't find the account
            throw new RuntimeException("Did not find the account with the account id - " + accountId);
        }

        return account;
    }

    // TODO: Create Hashing and Salt utility class
    @Override
    public void save(Account account) {
        // Grab the DB ID
//        Account dbAccount = accountRepository.save(account);
        // Generate Hash
        // Save the new data with the hash
        accountRepository.save(account);
    }

    @Override
    public void deleteById(int accountId) { accountRepository.deleteById(accountId); }
}
