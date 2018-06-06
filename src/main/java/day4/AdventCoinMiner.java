package day4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class AdventCoinMiner {

    int compute(String secretKey) {
        String candidate;
        int i = 0;
        do {
            candidate = secretKey + i;
            if (hash(candidate)) {
                return i;
            }
            i++;
        } while (true);
    }

    private boolean hash(String candidate) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] digest = md5.digest(candidate.getBytes());
            return toHexString(digest).startsWith("00000");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 indisponible");
        }
    }

    private String toHexString(byte[] digest) {
        return String.format("%032x", new BigInteger(1, digest));
    }

}
