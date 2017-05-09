package com.tistory.heowc.util;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;

public class AES256Util {

    public static String SECRET_KEY = "heowc1992@gmail.com";

    private String iv;
    private Key keySpec;

    public AES256Util(String key) throws UnsupportedEncodingException {
        this.iv = key.substring(0, 16);
        byte[] keyBytes = new byte[16];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if(len > keyBytes.length)
            len = keyBytes.length;
        System.arraycopy(b, 0, keyBytes, 0, len);

        this.keySpec = new SecretKeySpec(keyBytes, "AES");
    }
 
    // 암호화
    public String toEncrypt(String str) {

        try {
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
            byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
            return new String(Base64.encodeBase64(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    //복호화
    public String toDecrypt(String str) {
        try {
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes("UTF-8")));
            byte[] byteStr = Base64.decodeBase64(str.getBytes());
            return new String(c.doFinal(byteStr),"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}