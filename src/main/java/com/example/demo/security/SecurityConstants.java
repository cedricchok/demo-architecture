package com.example.demo.security;

public class SecurityConstants {
	public static final long EXPIRATION_TIME = 864000000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer "; // prefixe du jwt token
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/user"; // sign up url POST
	public static final String TOKEN_SECRET = "jf96gj5";
}
