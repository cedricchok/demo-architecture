package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Competition;

public interface ICompetitionService {

	public List<Competition> findAll();
	
    public Competition addCompetition(Competition newCompetition);
	
    public void deleteCompetition(int id);
	
	public Competition findById(int id);


}
