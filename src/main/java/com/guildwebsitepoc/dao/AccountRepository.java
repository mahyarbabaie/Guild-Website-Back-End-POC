package com.guildwebsitepoc.dao;

import com.guildwebsitepoc.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer>, AccountRepositoryCustom {

}
