package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.ICompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITeamRepository;
import com.example.demo.entity.Team;

@Service
public class TeamServiceImpl implements ITeamService{

	@Autowired
	public ITeamRepository teamRepository;

	@Override
	public List<Team> findAll() {
		List<Team> liste = new ArrayList<Team>();
		teamRepository.findAll().forEach(liste::add);
		return liste;
	}
	@Override
	public Team addTeam(Team newTeam) {
		return teamRepository.save(newTeam);
	}
	@Override
	public void deleteTeam(int id) {
		teamRepository.deleteById(id);
	}
	@Override
	public Team findById(int id) {
		return teamRepository.getOne(id);
	}
}
