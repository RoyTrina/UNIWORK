package labs;

//Code taken from: https://www.devglan.com/java8/rsa-encryption-decryption-java

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtil {
    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCApPDStjoUaQzAjdoBk4M7cdjUqpnoSIlqYerVr9GMNcuJlZmzLKka7Y9zsuSwXBOcD1nZb5tEuno5oQZ7W8w9TMSTtDQdz9qO6QMj5LWJtNkPvkwZQ0Oua5W6Jn11P/4Bl2fHPjuU/R0DJr3v2GJqd8f3CdcfKK+jeFw6MKz1YQIDAQAB";
    public static final String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAICk8NK2OhRpDMCN2gGTgztx2NSqmehIiWph6tWv0Yw1y4mVmbMsqRrtj3Oy5LBcE5wPWdlvm0S6ejmhBntbzD1MxJO0NB3P2o7pAyPktYm02Q++TBlDQ65rlbomfXU//gGXZ8c+O5T9HQMmve/YYmp3x/cJ1x8or6N4XDowrPVhAgMBAAECgYA33mowOK+0mYLORUy+jn/Z2zGd+pFozcfQCcJhF0BcMii5Ed10cRrn9O/uAW1MIlDp38jXo569FHdse8BC5rUl7yUG1CcVrttKquhAJd8jJVg3aqkbgw7PbK4qeqvib5Mv73oKFXP5fCmjVjBRKWm/ao8o//5c0pQe5F2Can+IoQJBAOt9rmqssJR37RFNeTeLULYf77eL8m4pNe1xd/GFo3/9n/AfEGjiQfL7EYc7LDicN1Rtlosvrtj0LoJ90uBXllUCQQCL2Rd3NB8f7O";

    public static PublicKey getPublicKey(String base64PublicKey) {
        PublicKey publicKey;
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PrivateKey getPrivateKey(String base64PrivateKey) {
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec KEY_SPEC = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
        KeyFactory KEY_FACTORY = null;
        try {
            KEY_FACTORY = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            if (KEY_FACTORY != null) {
                privateKey = KEY_FACTORY.generatePrivate(KEY_SPEC);
            }
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return privateKey;
    }

    public static byte[] encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException,
            InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
        return cipher.doFinal(data.getBytes());
    }

    public static String decrypt(byte[] data, PrivateKey privateKey) throws NoSuchPaddingException,
            NoSuchAlgorithmException, java.security.InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(data));

    }

    public static String decrypt(String data, String base64PrivateKey) throws IllegalBlockSizeException,
            BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, java.security.InvalidKeyException {
        return decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey(base64PrivateKey));
    }

    public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException {
        try {
            String encryptedString = Base64.getEncoder().encodeToString(encrypt("I love Shah Rukh Khan. ", publicKey));
            System.out.println(encryptedString);

            String decryptedString = RSAUtil.decrypt(encryptedString, privateKey);
            System.out.println(decryptedString);
        } catch (NoSuchPaddingException e) {
            System.err.println(e.getMessage());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
