package com.niuchaoqun.example.advance;

import com.niuchaoqun.utils.Hash;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;

public class HashExample {
    private static Hash hash = Hash.getSingleton();

    private static String source = "hello，中国";

    public static void run(String[] args) {
        md5();
        commonMd5();
        sha();
        commonSha();
        base64();
        commonBase64();
        url();
    }

    public static void md5() {
        String md5 = null;
        try {
            md5 = hash.md5(source);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(md5);
    }

    public static void commonMd5() {
        String md5 = DigestUtils.md5Hex(source);
        System.out.println(md5);
    }

    public static void sha() {
        String sha1 = null;
        String sha256 = null;
        try {
            sha1 = hash.sha(source);
            sha256 = hash.sha(source, 256);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(sha1);
        System.out.println(sha256);
    }

    public static void commonSha() {
        String sha1 = DigestUtils.sha1Hex(source);
        String sha256 = DigestUtils.sha256Hex(source);
        System.out.println(sha1);
        System.out.println(sha256);
    }

    public static void base64() {
        String encode = new BASE64Encoder().encode(source.getBytes());
        byte[] decode = null;
        try {
            decode = new BASE64Decoder().decodeBuffer(encode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(encode);
        System.out.println(new String(decode));
    }

    public static void commonBase64() {
        String encode = Base64.encodeBase64String(source.getBytes());
        byte[] decode = Base64.decodeBase64(encode);
        System.out.println(encode);
        System.out.println(new String(decode));
    }

    public static void url()
    {
        String url = "http://www.yaoyanbaike.com/tag/沃尔沃.html";
        try {
            System.out.println(URLEncoder.encode(url, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
