package com.example.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.request.UserDetailsRequestModel;
import com.example.demo.models.response.UserRest;
import com.example.demo.service.IUserService;
import com.example.demo.shared.dto.UserDto;

@RestController
@RequestMapping("/user") // http://localhost:8080/users
public class UserController {
	@Autowired
	IUserService userService;

	@GetMapping
	public String getUser() {
		return "get user was called";
	}

	@PostMapping()
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();

		UserDto userDto = new UserDto();
		// regarder un peu mieux copyProperties
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);

		return returnValue;
	}

	@PutMapping
	public String updateUser() {
		return "user is update";
	}

	@DeleteMapping
	public String deleteUser() {
		return "user is delete";
	}

}
