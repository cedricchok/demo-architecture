package com.example.demo.service;

import org.springframework.security.core.clubdetails.ClubDetailsService;

import com.example.demo.shared.dto.ClubDto;

public interface IClubService extends ClubDetailsService{
	ClubDto createClub(ClubDto club);

}
