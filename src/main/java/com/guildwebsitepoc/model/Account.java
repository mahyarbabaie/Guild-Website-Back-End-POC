package com.guildwebsitepoc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="accounts")
@JsonIgnoreProperties(value = {"passwordSalt", "passwordHash"}, allowSetters = true)
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

    @Column(name="password_salt")
    private String passwordSalt;

    @Column(name="password_hash")
    private String passwordHash;

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

    // passwordSalt
    public String getPasswordSalt() { return passwordSalt; }

    public void setPasswordSalt(String passwordSalt) { this.passwordSalt = passwordSalt; }

    // passwordHash
    public String getPasswordHash() { return passwordHash; }

    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    // excluding the hash and salts
    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
