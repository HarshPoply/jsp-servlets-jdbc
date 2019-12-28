package com.md5;

public class Main {
		
	public static void main(String[] args) {
		String password = "fs";
		System.out.println("MD5 : "+ Encryption.MD5(password));
		System.out.println("SHA1: "+ Encryption.SHA1(password));
	}
}
