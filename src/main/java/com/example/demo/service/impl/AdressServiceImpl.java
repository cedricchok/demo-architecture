package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAddressRepository;
import com.example.demo.dao.IUserRepository;
import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.IAddressService;
import com.example.demo.shared.dto.AddressDto;

@Service
public class AdressServiceImpl implements IAddressService {
	@Autowired
	IUserRepository userRepository;
	@Autowired
	IAddressRepository addressRepository;

	@Override
	public List<AddressDto> getAddresses(String userId) {
		List<AddressDto> returnValue = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();

		UserEntity userEntity = userRepository.findByUserId(userId);
		if (userEntity == null) {
			return returnValue;
		}

		Iterable<AddressEntity> addresses = addressRepository.findAllByUserDetails(userEntity);
		for (AddressEntity addressEntity : addresses) {
			returnValue.add(modelMapper.map(addressEntity, AddressDto.class));
		}
		return returnValue;
	}

	@Override
	public AddressDto getAddress(String addressId) {
		AddressDto returnValue = null;

		AddressEntity addressEntity = addressRepository.findByAddressId(addressId);

		if (addressEntity != null) {
			returnValue = new ModelMapper().map(addressEntity, AddressDto.class);
		}

		return returnValue;
	}

	/*
	 * @Override public AddressDto getAddress(String addressId) { AddressDto
	 * returnValue = null; AddressEntity addressEntity =
	 * addressRepository.findByAddressId(addressId); if (addressEntity != null) {
	 * returnValue = new ModelMapper().map(addressEntity, AddressDto.class); }
	 * return returnValue; }
	 */

}
