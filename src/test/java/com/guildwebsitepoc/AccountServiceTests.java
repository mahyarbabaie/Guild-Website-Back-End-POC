package com.guildwebsitepoc;

import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTests {

    @MockBean
    private AccountService accountService;

    // test variables
    private Account testAccountBob = new Account("Bob", "bsmith@abc.com");
    private Account testAccountJohn = new Account("John","jsmith@abc.com");

    // validates retrieval of multiple accounts
    @Test
    public void getAccountsTest() {
        // Given
        List<Account> expectedAccounts = new ArrayList<Account>();
        expectedAccounts.add(testAccountBob);
        expectedAccounts.add(testAccountJohn);
        // When
        when(accountService.getAccount()).thenReturn(expectedAccounts);
        // Then
        assertEquals(expectedAccounts.size(), accountService.getAccount().size());
    }

    // validates retrieval of a single account
    @Test
    public void getAccountTest(){
        // Given
        Account expectedAccount = testAccountBob;
        // When
        when(accountService.getAccount(1)).thenReturn(expectedAccount);
        // Then
        assertEquals(expectedAccount, accountService.getAccount(1));
    }

    // validates adding a single account
    @Test
    public void addAccountTest() {
        // Given
        Account expectedAccount = testAccountBob;
        expectedAccount.setPasswordHash("password");
        // When
        doAnswer((Answer) -> {
            System.out.println("Adding an Account");
            // Then
            Account actualAccount = Answer.getArgument(0);
            assertEquals(expectedAccount.getUsername(), actualAccount.getUsername());
            assertEquals(expectedAccount.getEmail(), actualAccount.getEmail());
            assertEquals(expectedAccount.getAccountId(), actualAccount.getAccountId());
            return null;
        }).when(accountService).addAccount(any(Account.class));
        accountService.addAccount(expectedAccount);
    }

    // validates updating a account
    @Test
    public void updateAccountTest() {
        // Given
        Account expectedAccount = testAccountBob;
        // When
        doAnswer((Answer) -> {
            System.out.println("Updating an Account");
            // Then
            Account actualAccount = Answer.getArgument(0);
            assertEquals(expectedAccount.getUsername(), actualAccount.getUsername());
            assertEquals(expectedAccount.getEmail(), actualAccount.getEmail());
            assertEquals(expectedAccount.getAccountId(), actualAccount.getAccountId());
            return null;
        }).when(accountService).updateAccount(any(Account.class));
        accountService.updateAccount(expectedAccount);
    }

    // validates deleting an account
    @Test
    public void deleteAccountTest() {
        // Given
        Account expectedAccount = testAccountBob;
        expectedAccount.setAccountId(1);
        // When
        doAnswer((Answer) -> {
            System.out.println("Deleting an Account");
            // Then
            Integer actualAccountId = Answer.getArgument(0);
            assert(expectedAccount.getAccountId() == actualAccountId);
            return null;
        }).when(accountService).deleteAccount(anyInt());
        accountService.deleteAccount(1);
    }

}
