package fr.ensim.dp.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    public static final String KEY = "test";

    /**
     * Fournit une chaine de caractère en utilisant le hashage MD5
     *
     * @param toEncrypt : texte à chiffrer
     */
    private static SecretKeySpec getKey(String secretKey) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        try {
            return new SecretKeySpec(digest.digest(new String(secretKey.getBytes(), "UTF8").getBytes()), "AES");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Chiffre une chaine de caractère en utilisant l'algo AES128
     * 
     * @param toEncrypt : texte à chiffrer
     */
    public static byte[] encryptAES(byte[] toEncrypt, String secretKey) {
        byte[] encrypted = null;
        try {
            // Instantiate the cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, getKey(secretKey));
            // Récupère la clé secrète
            return cipher.doFinal(toEncrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;
    }

    /**
     * Dechiffre une chaine de caractère en utilisant l'algo AES128
     * 
     * @param toDecrypt
     */
    public static byte[] decryptAES(byte[] toDecrypt, String secretKey) {
        byte[] decrypted = null;
        try {
            // Instantiate the cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, getKey(secretKey));
            return cipher.doFinal(toDecrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypted;
    }
}
