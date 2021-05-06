package com.example.demo.controller;

import com.example.demo.entity.Competition;
import com.example.demo.service.ICompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

    @RestController
    @RequestMapping("/competition")
    public class CompetitionController {

        @Autowired
        public ICompetitionService compService;

        @GetMapping(value = "/list")
        public List<Competition> findAll() {
            List<Competition> liste = compService.findAll();
            if (liste != null) {
                return liste;
            } else {
                return liste = new ArrayList<Competition>();
            }
        }
        @PostMapping (path = "/add")
        public Competition addCompetition(@RequestBody Competition newCompetition)
        {return compService.addCompetition(newCompetition); }

        @DeleteMapping(path = "/delete/{id}")
        public void  deleteCompetitionById(@PathVariable int id) {compService.deleteCompetition(id);}

        @GetMapping(path = "/search/{id}")
        public void searchCompetitionById(@PathVariable int id) {compService.findById(id);}
    }


