package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Team;

public interface ITeamService {

	public List<Team> getTeams();
	
	public Team addTeam(Team newTeam);
	
	public void deleteTeam(int id);
	
	public Team getTeamById(int id);
}
