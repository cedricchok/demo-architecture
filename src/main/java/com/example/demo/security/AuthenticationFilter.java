package com.example.demo.security;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Date;

import javax.management.RuntimeErrorException;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.SpringApplicationContext;
import com.example.demo.models.request.UserLoginRequestModel;
import com.example.demo.service.IUserService;
import com.example.demo.shared.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	// AUTH user with password and email
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			// creds = Credentials
			UserLoginRequestModel creds = new ObjectMapper().readValue(req.getInputStream(),
					UserLoginRequestModel.class);
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// Create token with email inside if user is succesfully authenticated with
	// return userID to header
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServerException {

		String email = ((User) auth.getPrincipal()).getUsername();

		String token = Jwts.builder().setSubject(email)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret()).compact();

		IUserService userService = (IUserService) SpringApplicationContext.getBean("userServiceImpl");
		UserDto userDto = userService.getUser(email);

		res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
		res.addHeader("userID", userDto.getUserId());

	}
}