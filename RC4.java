//RC4 Implementation in Java

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class RC4Example {
    public static void main(String[] args) throws Exception {
        String plainText = "Hello World";

        // Generate RC4 key (128-bit)
        KeyGenerator keyGen = KeyGenerator.getInstance("RC4");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        // Encrypt
        Cipher rc4 = Cipher.getInstance("RC4");
        rc4.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = rc4.doFinal(plainText.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("RC4 Encrypted Text: " + encryptedText);

        // Decrypt
        rc4.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = rc4.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes);
        System.out.println("RC4 Decrypted Text: " + decryptedText);
    }
}


