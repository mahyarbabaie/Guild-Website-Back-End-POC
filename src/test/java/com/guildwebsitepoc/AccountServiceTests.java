package com.guildwebsitepoc;

import com.guildwebsitepoc.dao.AccountRepository;
import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTests {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void getAccountsTest() {
        // Given
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("John","jsmith@abc.com"));
        accounts.add(new Account("Bob", "bsmith@abc.com"));
        // When
        when(accountRepository.getAccount()).thenReturn(accounts);
        // Then
        assertEquals(accounts.size(), accountService.getAccount().size());
    }

    @Test
    public void getAccountTest(){
        // Given
        Account account = new Account("Bob", "bsmith@abc.com");
        // When
        when(accountRepository.getAccount(1)).thenReturn(account);
        // Then
        assertEquals(account, accountService.getAccount(1));
    }

    @Test
    public void addAccountTest(){
        // Given
        Account account = new Account ("Bob", "bsmith@abc.com");
        account.setPasswordHash("password");
        // When
        doAnswer((Answer) -> {
            System.out.println("Adding an Account");
            assertEquals(account, Answer.getArgument(0));
            return null;
        }).when(accountRepository).addAccount(any(Account.class));
        accountService.addAccount(account);
    }

}
