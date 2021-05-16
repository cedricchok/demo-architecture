package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CompetitionEntity;
import com.example.demo.shared.dto.CompetitionDto;

public interface ICompetitionService {

	 List<CompetitionDto> getCompetitions();

	CompetitionEntity createCompetition(CompetitionEntity competition);
	
     void deleteCompetition(int competitionId);
	
     CompetitionDto getCompetitionById(int competitionId);

  	CompetitionDto updateCompetition(int competitionId, CompetitionDto competition);


}
