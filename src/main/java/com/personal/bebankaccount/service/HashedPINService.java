package com.personal.bebankaccount.service;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

@Service
public class HashedPINService {
  public String hash(String pin) {
    byte[] salt = getSalt();
    int iterations = 65536;

    byte[] generatedHashedPIN = generateSecretPBKDF2WithHmacSHA512(pin.toCharArray(), salt, iterations, 512);

    return iterations + ":" + toHex(salt) + ":" + toHex(generatedHashedPIN);
  }
  
  /**
   * Comparing the hashedPIN with the generatedHashedPIN.
   *
   * 1. a. 1 | 1 = 1, bitwise OR, return 1 if one of the variable is 1.
   *    b. 1 | 0 = 1
   * 2. a. 1 ^ 1 = 0, bitwise XOR, return 1 if not same.
   *    b. 1 ^ 0 = 1, return 0 if different.
   * 3. difference |= hash[i] ^ generatedHashedPIN[i]
   *    => `a += b + c` is equal to `a = a + b + c`
   *    => difference = difference | hash[i] ^ generatedHashedPIN[i]
   *    => difference = ( difference | hash[i] ) ^ generatedHashedPIN[i]
   *
   * Confused? use Arrays.equals(hashedPIN, generatedHashedPIN);
   */
  public boolean validate(String pin, String hashedPIN) {
    String[] parts = hashedPIN.split(":");
    int iterations = Integer.parseInt(parts[0]);
    byte[] salt = fromHex(parts[1]);
    byte[] hash = fromHex(parts[2]);

    byte[] generatedHashedPIN = generateSecretPBKDF2WithHmacSHA512(pin.toCharArray(), salt, iterations, hash.length * 8);

    int difference = hash.length ^ generatedHashedPIN.length; // 16 ^ 16 == 0;
    for (
            int i = 0;
            i < hash.length && i < generatedHashedPIN.length; // i < 16 && i < 16; the constraints.
            i++
    ) {
      difference |= hash[i] ^ generatedHashedPIN[i];
    }
    return difference == 0;
  }

  public byte[] generateSecretPBKDF2WithHmacSHA512(char[] pin, byte[] salt, int iterations, int keyLength) {
    KeySpec keySpec = new PBEKeySpec(pin, salt, iterations, keyLength);
    try {
      SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
      return secretKeyFactory.generateSecret(keySpec).getEncoded();
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException("Invalid algorithm PBKDF2WithHmacSHA512", e);
    } catch (InvalidKeySpecException e) {
      throw new IllegalStateException("Invalid KeySpec", e);
    }
  }

  private byte[] getSalt() {
    SecureRandom secureRandom = new SecureRandom();
    byte[] salt = new byte[16];
    secureRandom.nextBytes(salt);
    return salt;
  }

  private String toHex(byte[] bytes) {
    BigInteger bigInteger = new BigInteger(1, bytes);
    return bigInteger.toString(16);
  }

  private byte[] fromHex(String hex) {
    byte[] bytes = new byte[hex.length() / 2];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
    }
    return bytes;
  }
}
