package com.guildwebsitepoc.model;

import javax.persistence.*;

@Entity
@Table(name="hash_salts")
public class HashSalts {
    @Id
    @Column(name="hash_salt_account_id")
    private int hashSaltAccountId;

    @Column(name="hash")
    private String hash;

    @Column(name="salt")
    private String salt;

    // no argument constructor
    public HashSalts() {}

    // argument constructor for parent to pass in value
    public HashSalts(int hashSaltAccountId, String hash, String salt) {
        this.hashSaltAccountId = hashSaltAccountId;
        this.hash = hash;
        this.salt = salt;
    }

    // hash_salt_account_id
    public int getHashSaltAccountId() {
        return hashSaltAccountId;
    }

    public void setHashSaltAccountId(int hashSaltAccountId) {
        this.hashSaltAccountId = hashSaltAccountId;
    }

    // hash
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    // salt
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
