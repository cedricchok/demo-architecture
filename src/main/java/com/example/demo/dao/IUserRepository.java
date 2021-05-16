package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);


	UserEntity findByUserId(String userId);

}
