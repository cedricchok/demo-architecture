package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICompetitionRepository;
import com.example.demo.entity.Competition;

@Service
public class CompetitionServiceImpl {

	@Autowired
	public ICompetitionRepository competitionRepo;

	public List<Competition> getCompetitions() {
		List<Competition> liste = new ArrayList<Competition>();
		competitionRepo.findAll().forEach(liste::add);
		return liste;
	}

//	@Override
//	public Competition addCompetition(Competition newCompetition) {
//		return competitionRepo.save(newCompetition);
//	}
//	
//	@Override
//	public void deleteCompetition(int id) {
//		competitionRepo.deleteById(id);
//	}
	
	public Competition findById(int id) {
		return competitionRepo.getOne(id);
	}
}
