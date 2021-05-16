package com.example.demo.controller;

import com.example.demo.entity.CompetitionEntity;
import com.example.demo.entity.TeamEntity;
import com.example.demo.models.request.TeamRequestModels;
import com.example.demo.models.response.*;
import com.example.demo.service.ITeamService;
import com.example.demo.shared.dto.TeamDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    public ITeamService teamService;

    @GetMapping(path = "/all")
    public List<TeamRest> getTeamsList(){
        List<TeamRest> returnValue = new ArrayList<>();

        List<TeamDto> teams = teamService.getTeams();

        for(TeamDto teamDto: teams){
            TeamRest teamModel = new TeamRest();
            BeanUtils.copyProperties(teamDto, teamModel);
            returnValue.add(teamModel);
        }
        return returnValue;
    }

    @GetMapping(path = "/{id}")
    public TeamRest getTeamById(@PathVariable int id){

        TeamRest returnValue = new TeamRest();
        TeamDto teamDto = teamService.getTeamById(id);
        BeanUtils.copyProperties(teamDto, returnValue);
        return returnValue;
    }

    @PostMapping()
    public TeamEntity createTeam(@RequestBody TeamEntity newTeam){

        TeamEntity createdTeam = teamService.createTeam(newTeam);

        return createdTeam;
    }
    @PutMapping(path ="/{id}")
    public TeamRest updateTeam(@PathVariable int id, @RequestBody TeamRequestModels teamDetails)
    {
       TeamRest returnValue = new TeamRest();

       TeamDto teamDto = new TeamDto();
       BeanUtils.copyProperties(teamDetails,teamDto);

       TeamDto updateTeam = teamService.updateTeam(id,teamDto);
       BeanUtils.copyProperties(updateTeam, returnValue);

       return returnValue;
    }

    @DeleteMapping(path= "/{id}")
    public OperationStatusModel deleteTeam(@PathVariable int id){
        OperationStatusModel returnValue = new OperationStatusModel();

        teamService.deleteTeam(id);

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        return returnValue;

    }

}
