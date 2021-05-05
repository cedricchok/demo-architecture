package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}
