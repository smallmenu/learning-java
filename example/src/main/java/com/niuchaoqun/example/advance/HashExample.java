package com.niuchaoqun.example.advance;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.niuchaoqun.utils.Hash;

public class HashExample {
	private static Hash hash = Hash.getSingleton();

	public static void run(String[] args) {
		md5();
		sha();
		base64();
	}

	public static void md5() {
		String md5 = null;
		try {
			md5 = hash.md5("123456");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(md5);
	}

	public static void sha() {
		String sha1 = null;
		String sha256 = null;
		try {
			sha1 = hash.sha("123456");
			sha256 = hash.sha("123456", 256);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(sha1);
		System.out.println(sha256);
	}

	public static void base64() {
		String encode = new BASE64Encoder().encode("123456".getBytes());
		byte[] decode = null;
		try {
			decode = new BASE64Decoder().decodeBuffer(encode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(encode);
		System.out.println(new String(decode));
	}
}
