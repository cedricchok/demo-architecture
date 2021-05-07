package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserRepository;
import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.UserServiceException;
import com.example.demo.models.response.ErrorMessages;
import com.example.demo.service.IUserService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.UserDto;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	Utils utils;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	// Create user
	@Override
	public UserDto createUser(UserDto user) {
		// Verification if user email exist in database
		if (userRepository.findByEmail(user.getEmail()) != null)
			throw new RuntimeException("Email already exists !");

		// Copy of user to userEntity
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		String publicUserId = utils.generateRandomEntityPublicId(30);
		userEntity.setUserId(publicUserId);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		UserEntity storedUserDetails = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	}

	@Override
	public UserDto getUser(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userId);

		if (userEntity == null)
			throw new UsernameNotFoundException(ErrorMessages.COULD_NOT_DELETE_USER_ID.getErrorMessage() + userId);

		BeanUtils.copyProperties(userEntity, returnValue);

		return returnValue;
	}

	@Override
	public UserDto updateUser(String userId, UserDto user) {
		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userId);

		if (userEntity == null)
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());

		UserEntity updatedUserDetails = userRepository.save(userEntity);
		BeanUtils.copyProperties(updatedUserDetails, returnValue);

		return returnValue;
	}

	@Override
	public void deleteUser(String userId) {
		UserEntity userEntity = userRepository.findByUserId(userId);

		if (userEntity == null)
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		userRepository.delete(userEntity);
	}

	@Override
	public List<UserDto> getUsers(int page, int limit) {
		List<UserDto> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<UserEntity> usersPage = userRepository.findAll(pageableRequest);
		List<UserEntity> users = usersPage.getContent();

		for (UserEntity userEntity : users) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(userEntity, userDto);
			returnValue.add(userDto);
		}
		return returnValue;
	}

	@Override
	public List<UserDto> getUsers() {
		List<UserDto> returnValue = new ArrayList<>();

		Iterable<UserEntity> users = userRepository.findAll();
		for (UserEntity userEntity : users) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(userEntity, userDto);
			returnValue.add(userDto);
		}
		return returnValue;
	}

}
