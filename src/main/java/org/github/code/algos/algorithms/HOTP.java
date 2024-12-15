package org.github.code.algos.algorithms;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * HOTP - RFC 4226
 * https://tools.ietf.org/html/rfc4226
 *
 * HOTP is a one-time password algorithm that generates a one-time password
 * from a shared secret and a counter. It is used in different forms of two
 * factor authentication.
 *
 * @author Nambi Sankaran
 */
public class HOTP {

    public static String generateHOTP(String secret, long counter, int digits)
            throws NoSuchAlgorithmException, InvalidKeyException {
        // Convert the counter to byte array
        byte[] counterBytes = ByteBuffer.allocate(8).putLong(counter).array();

        // Create HMAC-SHA1 key from the shared secret
        byte[] secretBytes = secret.getBytes();
        SecretKeySpec signKey = new SecretKeySpec(secretBytes, "HmacSHA1");

        // Create HMAC-SHA1 instance and initialize with the signing key
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signKey);

        // Compute the HMAC
        byte[] hmac = mac.doFinal(counterBytes);

        // Dynamic truncation
        int offset = hmac[hmac.length - 1] & 0xf;
        int binary =
                ((hmac[offset] & 0x7f) << 24) |
                        ((hmac[offset + 1] & 0xff) << 16) |
                        ((hmac[offset + 2] & 0xff) << 8) |
                        (hmac[offset + 3] & 0xff);

        // Generate HOTP value
        int hotp = binary % (int) Math.pow(10, digits);
        return String.format("%0" + digits + "d", hotp);
    }

    public static void main(String[] args) {
        try {
            String secretKey = "mysecretkey";
            long counter = 1000;
            int digits = 6;
            String otp = generateHOTP(secretKey, counter, digits);
            System.out.println("HOTP: " + otp);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}