package com.guildwebsitepoc.utility;

import org.apache.commons.lang3.ArrayUtils;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

@Component
public class HashSaltManager {

    Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();

    public String getSalt64() {
        // initialize salt
        final byte[] salt = new byte[64];
        // initialize the random variable
        Random random = new SecureRandom();
        random.nextBytes(salt);
        // return the random salt
        return encoder.encodeToString(salt);
    }

    public String hashSHA3by512(String password, String salt) {

        try {
            // Combining Salt and Password
            final byte[] passwordBytes = password.getBytes("UTF-8");
            final byte[] saltBytes = salt.getBytes("UTF-8");
            // having salt added in the front to prevent rainbow attacks
            final byte[] all = ArrayUtils.addAll(saltBytes, passwordBytes);

            // Utilizing SHA3-512
            SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
            digestSHA3.update(all);
            return encoder.encodeToString(digestSHA3.digest());
        } catch (UnsupportedEncodingException e) {
            final String message = String.format("Caught UnsupportedEncodingException e: <%s>", e.getMessage());
        }
        return null;
    }

    public boolean passwordChecker(String password, String salt, String expectedHash) {

        try {
            // Combining Salt and Password
            final byte[] passwordBytes = password.getBytes("UTF-8");
            final byte[] saltBytes = salt.getBytes("UTF-8");
            final byte[] all = ArrayUtils.addAll(saltBytes, passwordBytes);

            // Utilizing SHA3-512
            SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
            digestSHA3.update(all);
            final byte[] actualHash = digestSHA3.digest();
            // Comparing user inputted password against actual password
            return expectedHash.equals(encoder.encodeToString(actualHash));
        } catch (UnsupportedEncodingException e) {
            final String message = String.format("Caught UnsupportedEncodingException e: <%s>", e.getMessage());
        }
        return false;
    }





}
