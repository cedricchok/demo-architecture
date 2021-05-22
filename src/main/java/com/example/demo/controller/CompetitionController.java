package com.example.demo.controller;

import com.example.demo.entity.CompetitionEntity;
import com.example.demo.service.ICompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/competition")
    public class CompetitionController {

        @Autowired
        public ICompetitionService competitionService;

        @GetMapping(path = "/all")
        public List<CompetitionEntity> getCompetitionList() {

            List<CompetitionEntity> returnValue = competitionService.getCompetitions();

            return returnValue;
        }

        @GetMapping(path = "/{id}")
        public CompetitionEntity getCompetitionById(@PathVariable int id) {

            CompetitionEntity returnValue = competitionService.getCompetitionById(id);

            return returnValue;
        }
/*
        public CompetitionRest getCompetitionById(@PathVariable int id) {

            CompetitionRest returnValue = new CompetitionRest();
            CompetitionDto competitionDto = competitionService.getCompetitionById(id);
            BeanUtils.copyProperties(competitionDto, returnValue);
            return returnValue;
        }
*/

        @PostMapping()
        public CompetitionEntity createCompetition(@RequestBody CompetitionEntity newCompetition) {


            CompetitionEntity createdCompetition = competitionService.createCompetition(newCompetition);


            return createdCompetition;
        }
/*
        @PutMapping(path = "/{id}")

        public CompetitionRest updateCompetition(@PathVariable int id, @RequestBody CompetitionRequestModels competitionDetails) {
            CompetitionRest returnValue = new CompetitionRest();

            CompetitionDto competitionDto = new CompetitionDto();
            BeanUtils.copyProperties(competitionDetails, competitionDto);

            CompetitionDto updateCompetition = competitionService.updateCompetition(id, competitionDto);
            BeanUtils.copyProperties(updateCompetition, returnValue);

            return returnValue;
        }*/

        @PutMapping(path = "/{id}")
        public CompetitionEntity updateCompetition(@RequestBody CompetitionEntity competition){

            CompetitionEntity updatedCompetition = competitionService.updateCompetition(competition);

            return updatedCompetition;

        }

        @DeleteMapping(path = "/{id}")
        public void deleteCompetition(@PathVariable int id) {

            competitionService.deleteCompetition(id);

       }

    }
