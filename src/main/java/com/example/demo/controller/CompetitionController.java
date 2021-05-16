package com.example.demo.controller;

import com.example.demo.entity.CompetitionEntity;
import com.example.demo.models.request.CompetitionRequestModels;
import com.example.demo.models.response.*;
import com.example.demo.service.ICompetitionService;
import com.example.demo.shared.dto.CompetitionDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

    @RestController
    @RequestMapping("/competition")
    public class CompetitionController {

        @Autowired
        public ICompetitionService competitionService;

        @GetMapping(path = "/all")
        public List<CompetitionRest> getCompetitionList() {
            List<CompetitionRest> returnValue = new ArrayList<>();

            List<CompetitionDto> competitions = competitionService.getCompetitions();

            for (CompetitionDto competitionDto : competitions) {
                CompetitionRest competitionModel = new CompetitionRest();
                BeanUtils.copyProperties(competitionDto, competitionModel);
                returnValue.add(competitionModel);
            }
            return returnValue;
        }


        @GetMapping(path = "/{id}")
        public CompetitionRest getCompetitionById(@PathVariable int id) {

            CompetitionRest returnValue = new CompetitionRest();
            CompetitionDto competitionDto = competitionService.getCompetitionById(id);
            BeanUtils.copyProperties(competitionDto, returnValue);
            return returnValue;
        }

        @PostMapping()
        public CompetitionEntity createCompetition(@RequestBody CompetitionEntity newCompetition) {


            CompetitionEntity createdCompetition = competitionService.createCompetition(newCompetition);


            return createdCompetition;
        }

        @PutMapping(path = "/{id}")
        public CompetitionRest updateCompetition(@PathVariable int id, @RequestBody CompetitionRequestModels competitionDetails) {
            CompetitionRest returnValue = new CompetitionRest();

            CompetitionDto competitionDto = new CompetitionDto();
            BeanUtils.copyProperties(competitionDetails, competitionDto);

            CompetitionDto updateCompetition = competitionService.updateCompetition(id, competitionDto);
            BeanUtils.copyProperties(updateCompetition, returnValue);

            return returnValue;
        }

        @DeleteMapping(path = "/{id}")
        public OperationStatusModel deleteCompetition(@PathVariable int id) {
            OperationStatusModel returnValue = new OperationStatusModel();

            competitionService.deleteCompetition(id);

            returnValue.setOperationName(RequestOperationName.DELETE.name());
            returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
            return returnValue;

        }
    }


