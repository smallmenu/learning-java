package com.niuchaoqun.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	private static class HashHolder {
		private static final Hash INSTANCE = new Hash();
	}

	private Hash() {}

	public static final Hash getSingleton() {
		return HashHolder.INSTANCE;
	}
	
	public static String BytesToHex(byte[] resultBytes) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < resultBytes.length; i++) {
			if (Integer.toHexString(0xFF & resultBytes[i]).length() == 1) {
				builder.append("0").append(Integer.toHexString(0xFF & resultBytes[i]));
			} else {
				builder.append(Integer.toHexString(0xFF & resultBytes[i]));
			}
		}
		return builder.toString();
	}

	public String md5(String string) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.reset();
		md.update(string.getBytes());
		byte[] resultBytes = md.digest();

		String resultString = BytesToHex(resultBytes);
		return resultString;
	}
	
	public String md5File(String path) throws Exception {
		FileInputStream fis = new FileInputStream(new File(path));
		DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("MD5"));
		byte[] buffer = new byte[1024];
		int read = dis.read(buffer, 0, 1024);
		while (read != -1){
			read = dis.read(buffer, 0, 1024);
		}
		
		MessageDigest md = dis.getMessageDigest();
		byte[] resultBytes = md.digest();
		String resultString = BytesToHex(resultBytes);
		return resultString;
	}
	
	public String sha(String string, int type) throws NoSuchAlgorithmException {
		String mdStr = "SHA-" + type;
		MessageDigest md = MessageDigest.getInstance(mdStr);
		md.reset();
		md.update(string.getBytes());
		byte[] resultBytes = md.digest();
		
		String resultString = BytesToHex(resultBytes);
		return resultString;
	}
	
	public String sha(String string) throws NoSuchAlgorithmException {
		return sha(string, 1);
	}
}
