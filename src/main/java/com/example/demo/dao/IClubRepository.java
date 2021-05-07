package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ClubEntity;

@Repository
public interface IClubRepository extends CrudRepository<ClubEntity, Long> {
	ClubEntity findByClubId(String id);
}
