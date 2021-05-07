package com.example.demo.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

<<<<<<< HEAD
	public String generateUserId(int length) {
		return generateRandomString(length);
	}
=======
	public String generateRandomEntityPublicId(int length) {
		return generateRandomString(length);
	}
	
>>>>>>> 345400a9fbf4bb8c94476ccb24626243f702ad6f

	public String generateRandomString(int length) {
		StringBuilder returnValue = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));

		}
		return new String(returnValue);
	}

}
