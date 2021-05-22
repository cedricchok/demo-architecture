package com.example.demo.service.impl;

import com.example.demo.dao.ITeamRepository;
import com.example.demo.entity.TeamEntity;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.response.ErrorMessages;
import com.example.demo.service.ITeamService;
import com.example.demo.shared.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements ITeamService {

    @Autowired
    public ITeamRepository teamRepository;

    @Autowired
    public Utils utils;


    @Override
    public List<TeamEntity> getTeams() {

        List<TeamEntity> returnValue = (List<TeamEntity>) teamRepository.findAll();

        return returnValue;

        }

    @Override
    public TeamEntity createTeam(TeamEntity team){
        if(teamRepository.findByLabel(team.getLabel()) != null)
            throw new RuntimeException("Label already exists!");

        team.setTeamId(utils.generateRandomEntityPublicId(30));

        TeamEntity storedTeam = teamRepository.save(team);

        return storedTeam;
    }

    @Override
    public void deleteTeam(int id) {
        TeamEntity teamEntity = teamRepository.findTeamById(id);

        if(teamEntity == null)
            throw new NotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        teamRepository.delete(teamEntity);
    }

    @Override
    public TeamEntity getTeamById(int id) {

        TeamEntity teamEntity = teamRepository.findTeamById(id);

        if(teamEntity == null)
            throw new NotFoundException("Team introuvable");

        return teamEntity;
    }

    @Override
    public TeamEntity updateTeam(TeamEntity team) {

       TeamEntity updatedTeam = teamRepository.save(team);

       return updatedTeam;
    }
}
