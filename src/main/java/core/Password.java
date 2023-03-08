package core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Dannyel
 */
public class Password {
    public static String encrypt(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    public static boolean verify(String password, String hashedPassword) throws NoSuchAlgorithmException {
        String encryptedPassword = Password.encrypt(password);
        return encryptedPassword.equals(hashedPassword);
    }
}
