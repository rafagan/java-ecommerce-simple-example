package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class HashFactory {
    public static void main(String[] args) {
        System.out.println(generatePasswordHash("1234"));
        System.out.println(generatePasswordHash("5678"));
        System.out.println(generatePasswordHash("4321"));
        System.out.println(generatePasswordHash("8765"));
    }

    public static String generatePasswordHash(String word) {
        for(int i = 0; i < 1000; i++) {
            word = stringHexa(Objects.requireNonNull(generateHash(word, "SHA-1")));
        }

        return word;
    }

    private static String secret = "70b6e9cd54ddf20b5f6077c070d6cea13c4e5e2a";
    public static String generateTokenHash(String word) {
        // Seria interessante ao invés de algoritmos de hash trabalhar com criptografia
        // E extrair dados de expiração do token. Um bom gerador de token é o JWT
        String hash = word;
        for(int i = 0; i < 10; i++) {
            hash = stringHexa(Objects.requireNonNull(generateHash(word + secret, "SHA-256")));
        }

        return String.format("%s:%s", word, hash);
    }

    private static String stringHexa(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for (byte B : bytes) {
            int high = ((B >> 4) & 0xf) << 4;
            int low = B & 0xf;
            if (high == 0) s.append('0');
            s.append(Integer.toHexString(high | low));
        }
        return s.toString();
    }

    private static byte[] generateHash(String word, String algorithm) { // MD5, SHA-1, SHA-256
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(word.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
