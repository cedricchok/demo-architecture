package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserRepository;
import com.example.demo.entity.User;

@Service
public class UserServiceImpl {

	public IUserRepository userRepo;

	public List<User> findAll() {
		List<User> liste = new ArrayList<User>();
		userRepo.findAll().forEach(liste::add);
		return liste;
	}

	public User addUser(User newUser) {
		return userRepo.save(newUser);
	}
	
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}
	
	public User findById(int id) {
		return userRepo.getOne(id);
	}
}
