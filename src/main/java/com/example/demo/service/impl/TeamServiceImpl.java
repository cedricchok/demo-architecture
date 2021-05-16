package com.example.demo.service.impl;

import com.example.demo.dao.ITeamRepository;
import com.example.demo.entity.TeamEntity;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.response.ErrorMessages;
import com.example.demo.service.ITeamService;
import com.example.demo.shared.Utils;

import com.example.demo.shared.dto.TeamDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements ITeamService {

    @Autowired
    public ITeamRepository teamRepository;

    @Autowired
    public Utils utils;


    @Override
    public List<TeamDto> getTeams() {
        List<TeamDto> returnValue = new ArrayList<>();

        Iterable<TeamEntity> teams = teamRepository.findAll();
        for(TeamEntity teamEntity: teams){
            TeamDto teamDto = new TeamDto();
            BeanUtils.copyProperties(teamEntity, teamDto);
            returnValue.add(teamDto);
        }
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
    public TeamDto getTeamById(int id) {
        TeamDto returnValue = new TeamDto();
        TeamEntity teamEntity = teamRepository.findTeamById(id);

        if(teamEntity == null)
            throw new NotFoundException("Team introuvable");
        BeanUtils.copyProperties(teamEntity, returnValue);
        return returnValue;
    }

    @Override
    public TeamDto updateTeam(int id, TeamDto team) {

        TeamDto returnValue = new TeamDto();
        TeamEntity teamEntity = teamRepository.findTeamById(id);

        if(teamEntity == null)
            throw new NotFoundException("team introuvable!");

        teamEntity.setLabel((team.getLabel()));
        TeamEntity updateTeam = teamRepository.save(teamEntity);
        BeanUtils.copyProperties(updateTeam,returnValue);
        return returnValue;
    }

}
