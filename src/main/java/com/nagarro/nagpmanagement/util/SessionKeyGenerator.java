package com.nagarro.nagpmanagement.util;

import java.util.Random;

public class SessionKeyGenerator {
	public static String generateKey() {
		Random random = new Random();
		StringBuffer key = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			key.append(random.nextInt(100));
		}
		System.out.println(key.toString());
		return key.toString();
	}
}
