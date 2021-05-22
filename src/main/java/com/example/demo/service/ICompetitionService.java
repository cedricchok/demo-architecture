package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CompetitionEntity;

public interface ICompetitionService {

	 List<CompetitionEntity> getCompetitions();

   	CompetitionEntity createCompetition(CompetitionEntity competition);
	
     void deleteCompetition(int competitionId);
	
     CompetitionEntity getCompetitionById(int competitionId);

 /*	CompetitionDto updateCompetition(int competitionId, CompetitionDto competition);*/

	CompetitionEntity updateCompetition(CompetitionEntity competition);



}
