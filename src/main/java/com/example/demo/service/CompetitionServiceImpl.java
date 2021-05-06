package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICompetitionRepository;
import com.example.demo.entity.Competition;

@Service
public class CompetitionServiceImpl implements ICompetitionService  {


	@Autowired
	public ICompetitionRepository compRepository;


	@Override
	public List<Competition> findAll() {
		List<Competition> liste = new ArrayList<Competition>();
		compRepository.findAll().forEach(liste::add);
		return liste;
	}

    @Override
     public Competition addCompetition(Competition newCompetition) {
		return compRepository.save(newCompetition);
     }

	@Override
	public void deleteCompetition(int id) {
		compRepository.deleteById(id);
	}
	@Override
	public Competition findById(int id) {
		return compRepository.getOne(id);
	}
}
