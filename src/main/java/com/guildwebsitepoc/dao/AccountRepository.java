package com.guildwebsitepoc.dao;

import com.guildwebsitepoc.model.Account;
import java.util.List;

public interface AccountRepository  {

    // This method returns all accounts
    List<Account> getAccount();

    // This method returns a single account
    Account getAccount(int accountId);

    // This method inserts a new account
    void addAccount(Account account);

    // This method updates an existing account
    void updateAccount(Account account);

    // This method deletes an existing account
    void deleteAccount(int accountId);

    // This method finds an account by their username
    Account findAccountByUsername(String username);

    // This method finds an account by their email
    Account findAccountByEmail(String email);
}
