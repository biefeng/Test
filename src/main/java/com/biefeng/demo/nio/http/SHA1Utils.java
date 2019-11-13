package com.biefeng.demo.nio.http;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHA1Utils {

    private static MessageDigest digest;

    public static String encode(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        digest = MessageDigest.getInstance("SHA-1");
        digest.update(message.getBytes("utf-8"),0,message.length());
        byte[] bytes = digest.digest();
        return new String(new BASE64Encoder().encode(bytes));
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(encode("E0ZE0jb/Kb181Q3yP+kRfg=="));
    }
}
