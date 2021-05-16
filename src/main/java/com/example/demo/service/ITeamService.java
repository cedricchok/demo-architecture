package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CompetitionEntity;
import com.example.demo.entity.TeamEntity;
import com.example.demo.shared.dto.TeamDto;

public interface ITeamService {

	List<TeamDto> getTeams();

	TeamEntity createTeam(TeamEntity team);
	
	void deleteTeam(int teamId);
	
	TeamDto getTeamById(int teamId);

	TeamDto updateTeam(int teamId, TeamDto team);

}
