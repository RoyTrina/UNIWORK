package labs;

//Code taken from: https://www.devglan.com/java8/rsa-encryption-decryption-java

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.util.Base64;

public class RSAKeyPairGenerator {

    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public RSAKeyPairGenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public void writeToFile(String path, byte[] key) throws IOException {
        File f = new File(path);
        //f.getParentFile().mkdirs();

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        RSAKeyPairGenerator KEY_PAIR_GENERATOR = new RSAKeyPairGenerator();
        KEY_PAIR_GENERATOR.writeToFile("RSA/publicKey", KEY_PAIR_GENERATOR.getPublicKey().getEncoded());
        KEY_PAIR_GENERATOR.writeToFile("RSA/privateKey", KEY_PAIR_GENERATOR.getPrivateKey().getEncoded());
        System.out.println(Base64.getEncoder().encodeToString(KEY_PAIR_GENERATOR.getPrivateKey().getEncoded()));
        System.out.println(Base64.getEncoder().encodeToString(KEY_PAIR_GENERATOR.getPublicKey().getEncoded()));

    }

}

