package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.UserEntity;

@Repository
public interface IAddressRepository extends CrudRepository<AddressEntity, Long> {
	List<AddressEntity> findAllByUserDetails(UserEntity userEntity);

	AddressEntity findByAddressId(String addressId);
}
