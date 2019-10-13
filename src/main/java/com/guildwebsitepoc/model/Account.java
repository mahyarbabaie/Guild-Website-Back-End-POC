package com.guildwebsitepoc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"passwordSalt", "passwordHash"}, allowSetters = true)
public class Account {

    // variables for accounts
    private int accountId;

    private String username;

    private String email;

    private String passwordSalt;

    private String passwordHash;

    private String role;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // excluding the hash and salts
    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


}
