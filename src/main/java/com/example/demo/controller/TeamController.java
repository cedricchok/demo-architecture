package com.example.demo.controller;

import com.example.demo.entity.TeamEntity;
import com.example.demo.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    public ITeamService teamService;

    @GetMapping(path = "/all")
    public List<TeamEntity> getTeamsList(){

        List<TeamEntity> returnValue = teamService.getTeams();

           return returnValue;
    }

    @GetMapping(path = "/{id}")

    public TeamEntity getTeamById(@PathVariable int id){

        TeamEntity returnValue = teamService.getTeamById(id);

        return returnValue;
    }

    @PostMapping()
    public TeamEntity createTeam(@RequestBody TeamEntity newTeam){

        TeamEntity createdTeam = teamService.createTeam(newTeam);

        return createdTeam;
    }

    @PutMapping(path ="/{id}")
    public TeamEntity updateTeam(@PathVariable TeamEntity team){

        TeamEntity updatedTeam = teamService.updateTeam(team);

        return updatedTeam;
    }

    @DeleteMapping(path= "/{id}")

    public void deleteTeam(@PathVariable int id) {

        teamService.deleteTeam(id);

    }

}
