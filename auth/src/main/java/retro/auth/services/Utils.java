package retro.auth.services;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Utils {

    public Utils() {
        //No-op
    }

    public String hashPassword(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] encodedPassword = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));
        String encodedPasswordToString = new String(encodedPassword);
        return encodedPasswordToString;
    }
}
