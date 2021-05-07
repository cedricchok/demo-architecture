package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.request.UserDetailsRequestModel;
import com.example.demo.models.response.OperationStatusModel;
import com.example.demo.models.response.RequestOperationName;
import com.example.demo.models.response.RequestOperationStatus;
import com.example.demo.models.response.UserRest;
import com.example.demo.service.IUserService;
import com.example.demo.shared.dto.UserDto;

@RestController
@RequestMapping("/user") // http://localhost:8080/users
public class UserController {
	@Autowired
	IUserService userService;

	@GetMapping(path = "/{id}")
	public UserRest getUser(@PathVariable String id) {
		UserRest returnValue = new UserRest();

		UserDto userDto = userService.getUserByUserId(id);
		BeanUtils.copyProperties(userDto, returnValue);

		return returnValue;
	}

	@PostMapping()
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception {
		UserRest returnValue = new UserRest();

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);

		return returnValue;
	}

	@PutMapping(path = "/{id}")
	public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto updatedUser = userService.updateUser(id, userDto);
		BeanUtils.copyProperties(updatedUser, returnValue);

		return returnValue;
	}

	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteUser(@PathVariable String id) {
		OperationStatusModel returnValue = new OperationStatusModel();

		userService.deleteUser(id);

		returnValue.setOperationName(RequestOperationName.DELETE.name());
		returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		return returnValue;
	}

	@GetMapping()
	public List<UserRest> getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit) {
		List<UserRest> returnValue = new ArrayList<>();

		List<UserDto> users = userService.getUsers(page, limit);
		// for each UserDto in UserDto list
		for (UserDto userDto : users) {
			UserRest userModel = new UserRest();
			BeanUtils.copyProperties(userDto, userModel);
			returnValue.add(userModel);
		}
		return returnValue;
	}

	@GetMapping(path = "/all")
	public List<UserRest> getUsersList() {
		List<UserRest> returnValue = new ArrayList<>();

		List<UserDto> users = userService.getUsers();
		// for each UserDto in UserDto list
		for (UserDto userDto : users) {
			UserRest userModel = new UserRest();
			BeanUtils.copyProperties(userDto, userModel);
			returnValue.add(userModel);
		}
		return returnValue;
	}

}
