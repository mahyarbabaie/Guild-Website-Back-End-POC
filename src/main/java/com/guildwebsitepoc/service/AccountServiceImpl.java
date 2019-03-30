package com.guildwebsitepoc.service;

import com.guildwebsitepoc.dao.AccountRepository;
import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.utility.HashSaltManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private HashSaltManager hashSaltManager;

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

    @Override
    public void save(Account account) {
        if (account.getAccountId() == 0) {
            // Generate Hash and Salt
            final String salt = hashSaltManager.getSalt64();
            final String hash = hashSaltManager.hashSHA3by512(account.getPasswordHash(), salt);
            // Save the new data with the hash
            account.setPasswordSalt(salt);
            account.setPasswordHash(hash);
            // save the account with its updated value
            accountRepository.save(account);
        } else {
            accountRepository.save(account);
        }
    }

    @Override
    public void deleteById(int accountId) { accountRepository.deleteById(accountId); }
}
