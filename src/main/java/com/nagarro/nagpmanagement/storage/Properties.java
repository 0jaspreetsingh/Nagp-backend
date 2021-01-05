package com.nagarro.nagpmanagement.storage;

import java.util.HashMap;

public class Properties {

	private static HashMap<String, String> sessionStorage = new HashMap<String, String>();

	public static void addSessionKey(String username, String sessionKey) {
		sessionStorage.put(username, sessionKey);
		System.out.println("key added:" + sessionKey);
	}

	public static String getSessionKey(String username) {
		System.out.println(sessionStorage.get(username));
		return sessionStorage.get(username);
	}
}
