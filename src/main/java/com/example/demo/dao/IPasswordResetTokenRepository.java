package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.PasswordResetTokenEntity;

public interface IPasswordResetTokenRepository
		extends
			CrudRepository<PasswordResetTokenEntity, Long> {
	PasswordResetTokenEntity findByToken(String token);

}
