package org.equilibrium;

import org.equilibrium.utils.EncryptionUtils;
import org.junit.Test;

public class EncryptionTests {


    @Test
    public void whenIsEncryptedAndDecrypted_thenDecryptedEqualsOriginal()
            throws Exception {
        String encryptionKeyString =  "7x!A%D*G-KaPdSgU";
        String originalMessage = "pass1234";
        String encryptedMessage = EncryptionUtils.encrypt(originalMessage, encryptionKeyString);
        String decryptedMessage = EncryptionUtils.decrypt(encryptedMessage, encryptionKeyString);

        System.out.println("ORIGINAL MESSAGE: " + originalMessage);
        System.out.println("ENCRYPTED MESSAGE: " + encryptedMessage);
        System.out.println("DECRYPTED MESSAGE: " +  decryptedMessage);
    }
}
