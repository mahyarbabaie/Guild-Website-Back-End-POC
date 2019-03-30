package com.guildwebsitepoc.dao;

import com.guildwebsitepoc.model.Account;

import java.util.List;

public interface AccountRepositoryCustom {
    List<Account> findByUsername(String username);
}
