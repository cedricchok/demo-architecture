package com.example.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.clubdetails.ClubDetails;
import org.springframework.security.core.clubdetails.Club;
import org.springframework.security.core.clubdetails.ClubnameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ClubDto createClub(ClubDto club) {

        if (clubRepository.findByEmail(club.getEmail()) != null)
            throw new RuntimeException("Email already exists !");

        ClubEntity clubEntity = new ClubEntity();
        BeanUtils.copyProperties(club, clubEntity);

        String publicClubId = utils.generateClubId(30);
        clubEntity.setClubId(publicClubId);
        clubEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(club.getPassword()));

        ClubEntity storedClubDetails = clubRepository.save(clubEntity);

        ClubDto returnValue = new ClubDto();
        BeanUtils.copyProperties(storedClubDetails, returnValue);
        return returnValue;
    }

    @Override
    public ClubDetails loadClubByUsername(String email) throws ClubnameNotFoundException {
        ClubEntity clubEntity = clubRepository.findByEmail(email);

        if (clubEntity == null)
            throw new ClubnameNotFoundException(email);

        return new Club(clubEntity.getEmail(), clubEntity.getEncryptedPassword(), new ArrayList<>());
    }

}
