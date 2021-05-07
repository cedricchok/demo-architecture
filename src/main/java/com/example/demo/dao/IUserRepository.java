package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
<<<<<<< HEAD
=======

	UserEntity findByUserId(String userId);

>>>>>>> 345400a9fbf4bb8c94476ccb24626243f702ad6f
}
