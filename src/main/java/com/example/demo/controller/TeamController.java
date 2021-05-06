package com.example.demo.controller;

import com.example.demo.entity.Team;
import com.example.demo.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    public ITeamService teamService;

    @GetMapping(value = "/list")
    public List<Team> findAll() {
        List<Team> liste = teamService.findAll();
        if(liste != null){
            return liste;
        } else {
            return liste = new ArrayList<Team>();
        }
    }

    @PostMapping(path = "/add")
    public Team addTeam(@RequestBody Team newTeam) {return teamService.addTeam(newTeam); }

    @DeleteMapping(path = "/delete/{id}")
    public void  deleteTeamById(@PathVariable int id) {teamService.deleteTeam(id);}

    @GetMapping(path = "/search/{id}")
    public void searchTeamById(@PathVariable int id) {teamService.findById(id);}


}
