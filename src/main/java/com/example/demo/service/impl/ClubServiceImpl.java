package com.example.demo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IClubRepository;
import com.example.demo.entity.ClubEntity;
import com.example.demo.service.IClubService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.ClubDto;

@Service
public class ClubServiceImpl implements IClubService {

	@Autowired
	IClubRepository clubRepository;

	@Autowired
	Utils utils;

	@Override
	public ClubDto createClub(ClubDto club) {

		ClubEntity clubEntity = new ClubEntity();
		BeanUtils.copyProperties(club, clubEntity);

		String publicClubId = utils.generateRandomEntityPublicId(30);
		clubEntity.setClubId(publicClubId);

		ClubEntity storedClubDetails = clubRepository.save(clubEntity);

		ClubDto returnValue = new ClubDto();
		BeanUtils.copyProperties(storedClubDetails, returnValue);
		return returnValue;
	}

}
