package com.niuchaoqun.apache;


import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CommonsCodec {

    private static String source = "hello，中国";

    public static void main(String[] args) {
        md5();
        sha();
        base64();
        url();
    }

    public static void md5() {
        String md5 = DigestUtils.md5Hex(source);
        System.out.println(md5);

        System.out.println("----- md5 -----");
    }

    public static void sha() {
        String sha1 = DigestUtils.sha1Hex(source);
        String sha256 = DigestUtils.sha256Hex(source);
        System.out.println(sha1);
        System.out.println(sha256);

        System.out.println("----- sha -----");
    }

    public static void base64() {
        String encode = Base64.encodeBase64String(source.getBytes());
        byte[] decode = Base64.decodeBase64(encode);
        System.out.println(encode);
        System.out.println(new String(decode));

        String safe_encode = Base64.encodeBase64URLSafeString(source.getBytes());
        byte[] safe_decode = Base64.decodeBase64(safe_encode);
        System.out.println(safe_encode);
        System.out.println(new String(safe_decode));

        System.out.println("----- base64 -----");
    }

    public static void url() {
        String url = "http://www.ncq8.com/news?args1=v1&args2=v2";
        URLCodec urlCodec = new URLCodec();
        String encode1 = null;
        try {
            encode1 = urlCodec.encode(url);
        } catch (EncoderException e) {
            e.printStackTrace();
        }

        String encode2 = null;
        try {
            encode2 = URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        System.out.println(encode1);
        System.out.println(encode2);
    }
}
