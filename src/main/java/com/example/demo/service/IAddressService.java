package com.example.demo.service;

import java.util.List;

import com.example.demo.shared.dto.AddressDto;

public interface IAddressService {
	List<AddressDto> getAddresses(String userId);

	AddressDto getAddress(String addressId);

	// AddressDto getAddress(String addressId);

}
