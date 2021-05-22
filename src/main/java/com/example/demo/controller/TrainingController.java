package com.example.demo.controller;

import com.example.demo.entity.TrainingEntity;
import com.example.demo.service.ITrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
    public class TrainingController {

    @Autowired
    public ITrainingService trainingService;

    @GetMapping(path="/all")
    public List<TrainingEntity> getTrainingList(){

        List<TrainingEntity> returnValue = trainingService.getTrainings();

        return returnValue;
    }

    @GetMapping(path = "/{id}")
    public TrainingEntity getTrainingById(@PathVariable int id){

        TrainingEntity returnValue = trainingService.getTrainingById(id);

        return returnValue;
    }

     @PostMapping()
    public TrainingEntity  createTraining(@RequestBody TrainingEntity newTraining){

        TrainingEntity createdTraining = trainingService.createTraining(newTraining);

        return createdTraining;
    }

    @PutMapping(path ="/{id}")
    public TrainingEntity updateTraining(@PathVariable TrainingEntity training){

        TrainingEntity updatedTraining = trainingService.updateTraining(training);

        return updatedTraining;
    }

    @DeleteMapping(path= "/{id}")
    public void deleteTraining(@PathVariable int id) {

        trainingService.deleteTraining(id);

    }

}

