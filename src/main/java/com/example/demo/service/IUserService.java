package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.shared.dto.UserDto;

public interface IUserService extends UserDetailsService {
	UserDto createUser(UserDto user);

	UserDto getUser(String email);

}
