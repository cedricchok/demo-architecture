package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IClubRepository;
import com.example.demo.entity.Club;

@Service
public class ClubServiceImpl {
	
	@Autowired
	public IClubRepository clubRepo;
	
//	public List<Club> findAll() {
//		List<Club> liste = new ArrayList<Club>();
//		clubRepo.findAll().forEach(liste::add);
//		return liste;
//	}

//	@Override
//	public Club addClub(Club newClub) {
//		return clubRepo.save(newClub);
//	}
//	
//	@Override
//	public void deleteClub(int id) {
//		clubRepo.deleteById(id);
//	}
	
	public Club findById(int id) {
		return clubRepo.getOne(id);
	}
}
