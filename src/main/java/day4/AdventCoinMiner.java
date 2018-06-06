package day4;

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
            return digest[0] == 0x00 && digest[1] == 0x00 && (digest[2] & 0xF0) == 0;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 indisponible");
        }
    }

}
