package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface IUserService {

	public List<User> getUsers();
	
	public User addUser(User newUser);
	
	public void deleteUser(int id);
	
	public User getUserById(int id);
}
