package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TeamEntity;

public interface ITeamService {

	List<TeamEntity> getTeams();

	TeamEntity createTeam(TeamEntity team);
	
	void deleteTeam(int teamId);
	
	TeamEntity getTeamById(int teamId);

	TeamEntity updateTeam(TeamEntity team);

}
