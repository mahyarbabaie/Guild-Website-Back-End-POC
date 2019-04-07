package com.guildwebsitepoc.service;

import com.guildwebsitepoc.dao.AccountRepository;
import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.utility.HashSaltManager;
import jdk.jshell.spi.ExecutionControl;
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
        List<Account> duplicateAccount = accountRepository.findByUsername(account.getUsername());
        System.out.println(duplicateAccount);
        if (!duplicateAccount.isEmpty()) {
            throw new RuntimeException("Username already exists");
        }
        if (account.getAccountId() == 0){
            // new account so lets do password magic
            account = hashSaltPassword(account);
        } else if (account.getAccountId() != -1){
            // if account exists then lets check if they wanted a password change
            Account originalAccount = findById(account.getAccountId());
            // if password has been modified in the PUT then lets update the password
            if (account.getPasswordHash() != null && !originalAccount.getPasswordHash().equals(account.getPasswordHash())) {
                account = hashSaltPassword(account);
            } else {
                // lets keep the old password if they omit the values in the PUT. Prevent null values passed in to DB
                if (account.getPasswordHash() == null) {
                    account.setPasswordHash(originalAccount.getPasswordHash());
                }
                if (account.getPasswordSalt() == null) {
                    account.setPasswordSalt(originalAccount.getPasswordSalt());
                }
            }
        }
        // save or update the account
        accountRepository.save(account);

    }

    @Override
    public void deleteById(int accountId) { accountRepository.deleteById(accountId); }

    @Override
    public Account findByUsername(String username) {
        Account account = accountRepository.findByUsername(username).get(0);
        if (account != null) {
            return account;
        }
        return null;
    }

    @Override
    public boolean verifyPassword(String password, String salt, String expectedHash) {
        return hashSaltManager.passwordChecker(password, salt, expectedHash);
    }

    private Account hashSaltPassword(Account account) {
        // Generate Hash and Salt
        final String salt = hashSaltManager.getSalt64();
        final String hash = hashSaltManager.hashSHA3by512(account.getPasswordHash(), salt);
        // Save the new data with the hash
        account.setPasswordSalt(salt);
        account.setPasswordHash(hash);

        return account;
    }
}
