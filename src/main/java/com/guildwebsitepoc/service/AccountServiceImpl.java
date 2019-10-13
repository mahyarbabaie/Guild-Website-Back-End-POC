package com.guildwebsitepoc.service;

import com.guildwebsitepoc.dao.AccountRepository;
import com.guildwebsitepoc.exception.AccountEmailAlreadyExistsException;
import com.guildwebsitepoc.exception.AccountUsernameAlreadyExistsException;
import com.guildwebsitepoc.exception.AccountNotFoundException;
import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.utility.HashSaltManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private HashSaltManager hashSaltManager;

    @Value("${spring.role.member}")
    private String memberRole;

    @Override
    public List<Account> getAccount() { return accountRepository.getAccount(); }

    @Override
    public Account getAccount(int accountId) {
        // "Optional<T>" checks for nulls
        Optional<Account> result = Optional.ofNullable(accountRepository.getAccount(accountId));
        // Declaring an account;
        Account account = null;

        if (result.isPresent()) {
            account = result.get();
        } else {
            // we didn't find the account
            throw new AccountNotFoundException("Did not find the account with the account id: " + accountId);
        }

        return account;
    }

    @Override
    public void addAccount(Account account) {
        Account duplicateUsername = accountRepository.findAccountByUsername(account.getUsername());
        System.out.println(duplicateUsername);
        if (duplicateUsername != null) {
            throw new AccountUsernameAlreadyExistsException("Username already exists. Please use a different username.");
        }
        Account duplicateEmail = accountRepository.findAccountByEmail(account.getEmail());
        if (duplicateEmail != null) {
            throw new AccountEmailAlreadyExistsException("Email already exists. Please use a different email.");
        }
        System.out.println("Going to generate salt and hash for the user");
        // new account so lets do password magic
        account = hashSaltPassword(account);

        System.out.println("Going to be setting the role of member for the user");
        // member is the default role upon account creation
        account.setRole(memberRole);

        System.out.println("Going to be inserting the account into the database");
        // inserts the account
        accountRepository.addAccount(account);

    }

    @Override
    public void updateAccount(Account account) {
        // if account exists then lets check if they wanted a password change
        Account originalAccount = getAccount(account.getAccountId());
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
        // We do not want to require users to pass in their role to update their account
        if (account.getRole() == null) {
            account.setRole(originalAccount.getRole());
        }

        // updates the account
        accountRepository.updateAccount(account);
    }


    @Override
    public void deleteAccount(int accountId) {
        // "Optional<T>" checks for nulls
        Optional<Account> result = Optional.ofNullable(accountRepository.getAccount(accountId));
        // Declaring an account;
        Account account = null;

        if (result.isPresent()) {
            account = result.get();
        } else {
            // we didn't find the account
            throw new AccountNotFoundException("Did not find the account with the account id: " + accountId);
        }

        // Using the accountId from the account query instead of directly using the parameter to avoid potential errors
        accountRepository.deleteAccount(account.getAccountId());
    }

    @Override
    public Account findAccountByUsername(String username) {
        try {
            Account account = accountRepository.findAccountByUsername(username);
            if (account == null) {
                throw new AccountNotFoundException("Account does not exist");
            }
            return account;
        } catch (Exception err) {
            err.getStackTrace();
            throw new AccountNotFoundException("Account does not exist");
        }
    }

    @Override
    public Account findAccountByEmail(String email) {
        try {
            Account account = accountRepository.findAccountByEmail(email);
            if (account == null) {
                throw new AccountNotFoundException("Account does not exist");
            }
            return account;
        } catch (Exception err) {
            err.getStackTrace();
            throw new AccountNotFoundException("Account does not exist");
        }
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
