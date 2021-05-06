package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Team;

public interface ITeamService {

	public List<Team> findAll();
	
	public Team addTeam(Team newTeam);
	
	public void deleteTeam(int id);
	
	public Team findById(int id);
}
