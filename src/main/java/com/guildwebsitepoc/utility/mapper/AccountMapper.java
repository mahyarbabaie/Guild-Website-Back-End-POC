package com.guildwebsitepoc.utility.mapper;

import com.guildwebsitepoc.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setAccountId(rs.getInt("account_id"));
        account.setUsername(rs.getString("username"));
        account.setEmail(rs.getString("email"));
        account.setPasswordSalt(rs.getString("password_salt"));
        account.setPasswordHash(rs.getString("password_hash"));
        account.setRole(rs.getString("role"));

        return account;
    }

}
