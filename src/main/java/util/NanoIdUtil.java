package util;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public enum NanoIdUtil {
    ;
    private static final SecureRandom DEFAULT_NUMBER_GENERATOR = new SecureRandom();
    private static final char[] DEFAULT_ALPHABET = "_-0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final int DEFAULT_SIZE = 21;


    public static class SecureRandomString {
        private static final SecureRandom random = new SecureRandom();
        private static final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();

        public static String generate() {
            byte[] buffer = new byte[20];
            random.nextBytes(buffer);
            return encoder.encodeToString(buffer);
        }
    }

    public static String randomNanoId() {
        return randomNanoId(DEFAULT_NUMBER_GENERATOR, DEFAULT_ALPHABET, 21);
    }

    /**
     * 生成 NanoId
     */
    public static String randomNanoId(Random random, char[] alphabet, int size) {
        if (random == null) {
            throw new IllegalArgumentException("random cannot be null.");
        }
        if (alphabet == null) {
            throw new IllegalArgumentException("alphabet cannot be null.");
        }
        if (alphabet.length == 0 || alphabet.length > 256) {
            throw new IllegalArgumentException("alphabet must contain between 1 and 255 symbols.");
        }
        if (size <= 0) {
            throw new IllegalArgumentException("size must be greater than zero.");
        }

        int mask = (2 << (int) Math.floor(Math.log((double) (alphabet.length - 1)) / Math.log(2.0D))) - 1;
        int step = (int) Math.ceil(1.6D * (double) mask * (double) size / (double) alphabet.length);
        StringBuilder idBuilder = new StringBuilder();

        while (true) {
            byte[] bytes = new byte[step];
            random.nextBytes(bytes);

            for (int i = 0; i < step; ++i) {
                int alphabetIndex = bytes[i] & mask;
                if (alphabetIndex < alphabet.length) {
                    idBuilder.append(alphabet[alphabetIndex]);
                    if (idBuilder.length() == size) {
                        return idBuilder.toString();
                    }
                }
            }
        }

    }
}