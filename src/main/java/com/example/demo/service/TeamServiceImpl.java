package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITeamRepository;
import com.example.demo.entity.Team;

@Service
public class TeamServiceImpl {

	@Autowired
	public ITeamRepository teamRepo;

	public List<Team> findAll() {
		List<Team> liste = new ArrayList<Team>();
		teamRepo.findAll().forEach(liste::add);
		return liste;
	}

	public Team addTeam(Team newTeam) {
		return teamRepo.save(newTeam);
	}
	
	public void deleteTeam(int id) {
		teamRepo.deleteById(id);
	}
	
	public Team findById(int id) {
		return teamRepo.getOne(id);
	}
}
