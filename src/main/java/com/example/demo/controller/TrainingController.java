package com.example.demo.controller;


import com.example.demo.entity.Training;
import com.example.demo.service.ITrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {
    @Autowired
    public ITrainingService trainService;

    @GetMapping(value = "/list")
    public List<Training> findAll() {
        List<Training> liste = trainService.findAll();
        if(liste != null){
            return liste;
        } else {
            return liste = new ArrayList<Training>();
        }
    }
    @PostMapping(path = "/add")
    public Training addTraining(@RequestBody Training newTraining) {return trainService.addTraining(newTraining); }

    @DeleteMapping(path = "/delete/{id}")
    public void  deleteTrainingById(@PathVariable int id) {trainService.deleteTraining(id);}

    @GetMapping(path = "/search/{id}")
    public void searchTrainingById(@PathVariable int id) {trainService.findById(id);}

}
