package com.guildwebsitepoc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="accounts")
@JsonIgnoreProperties(value = {"hashSalt"})
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
    private HashSalt hashSalt;

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
    public HashSalt getHashSalt() {
        return this.hashSalt;
    }

    public void setHashSalt(HashSalt hashSalt) {
        this.hashSalt = hashSalt;
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
