package DSAssignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.RenderingHints.Key;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DesEncrypter {
  Cipher ecipher;

  Cipher dcipher;

  DesEncrypter(String key) throws Exception {
    DESKeySpec dks = new DESKeySpec(key.getBytes());
    SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
    SecretKey desKey = skf.generateSecret(dks);
    dcipher = Cipher.getInstance("DES");
    ecipher = Cipher.getInstance("DES");
    ecipher.init(Cipher.ENCRYPT_MODE, desKey);
    dcipher.init(Cipher.DECRYPT_MODE, desKey);
  }

  public String encrypt(String str) throws Exception {
    // Encode the string into bytes using utf-8
    byte[] utf8 = str.getBytes("UTF8");

    // Encrypt
    byte[] enc = ecipher.doFinal(utf8);

    // Encode bytes to base64 to get a string
    return new sun.misc.BASE64Encoder().encode(enc);
  }

  public String decrypt(String str) throws Exception {
    // Decode base64 to get bytes
    byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

    byte[] utf8 = dcipher.doFinal(dec);

    // Decode using utf-8
    return new String(utf8, "UTF8");
  }

//
//  public static void main(String[] args) throws Exception {
//    String key = "abcdefghijk";
//    DesEncrypter encrypter = new DesEncrypter(key);
//    String encrypted = encrypter.encrypt("Don't tell anybody!");
//    String decrypted = encrypter.decrypt(encrypted);
//      System.out.println(encrypted);
//      System.out.println(decrypted);
//  }
}
