package com.guildwebsitepoc.model;

import javax.persistence.*;

@Entity
@Table(name="accounts")
public class Account {

    // variables for accounts
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="account_id")
    private int accountId;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="account_id")
    private HashSalts hashSalts;

    // no argument constructor
    public Account (){}

    // argument constructor
    public Account(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // accountId
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    // username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // hash_salt table
    public HashSalts getHashSalts() {
        return this.hashSalts;
    }

    public void setHashSalts(HashSalts hashSalts) {
        this.hashSalts = hashSalts;
    }

    // toString() method
    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
