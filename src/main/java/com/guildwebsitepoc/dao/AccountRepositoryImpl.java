package com.guildwebsitepoc.dao;

import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.utility.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // This variable references the accounts table in the database
    private static final String accountsTable = "guild_website_poc_app.accounts";

    // This method returns all accounts
    @Override
    public List<Account> getAccount() {
        try {
            String sql = "SELECT * FROM " + accountsTable;
            RowMapper<Account> rowMapper = new AccountMapper();
            return jdbcTemplate.query(sql, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // This method returns a single account
    @Override
    public Account getAccount(int accountId) {
        try {
            String sql = "SELECT * FROM " + accountsTable + " WHERE account_id = ?";
            Account account = jdbcTemplate.queryForObject(sql, new Object[]{accountId}, new AccountMapper());
            return account;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // This method inserts a new account
    @Override
    public void addAccount(Account account) {
        String sql = "INSERT INTO " +
                accountsTable +
                " (account_id, username, email, password_salt, password_hash, role) VALUES (?,?,?,?,?,?)";

        jdbcTemplate.update(
                sql,
                account.getAccountId(),
                account.getUsername(),
                account.getEmail(),
                account.getPasswordSalt(),
                account.getPasswordHash(),
                account.getRole());
    }

    // This method updates an existing account
    @Override
    public void updateAccount(Account account) {
        // accountId is not included in the UPDATE call because we don't want users updating that value
        String sql = "UPDATE " +
                accountsTable +
                " SET username=?, email=?, password_salt=?, password_hash=?, role=? WHERE account_id=?";

        jdbcTemplate.update(
                sql,
                account.getUsername(),
                account.getEmail(),
                account.getPasswordSalt(),
                account.getPasswordHash(),
                account.getRole(),
                account.getAccountId());
    }

    // This method deletes an existing account
    @Override
    public void deleteAccount(int accountId) {
        String sql = "DELETE FROM " + accountsTable + " WHERE account_id=?";
        jdbcTemplate.update(sql, accountId);
    }

    // This method finds an account by their username
    @Override
    public Account findAccountByUsername(String username) {
        try {
            System.out.println("Username: " + username);
            String sql = "SELECT DISTINCT * FROM " + accountsTable + " WHERE username = ?";
            System.out.println("Querying Account from findAccountByUsername");
            Account account = jdbcTemplate.queryForObject(sql, new Object[]{username}, new AccountMapper());
            System.out.println("Returning Account from findAccountByUsername");
            return account;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // This method finds an account by their email
    @Override
    public Account findAccountByEmail(String email) {
        try {
            System.out.println("Email: " + email);
            String sql = "SELECT DISTINCT * FROM " + accountsTable + " WHERE email = ?";
            System.out.println("Querying Account from findAccountByEmail");
            Account account = jdbcTemplate.queryForObject(sql, new Object[]{email}, new AccountMapper());
            System.out.println("Returning Account from findAccountByEmail");
            return account;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
