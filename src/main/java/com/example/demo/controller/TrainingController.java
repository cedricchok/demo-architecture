package com.example.demo.controller;


import com.example.demo.entity.TeamEntity;
import com.example.demo.entity.TrainingEntity;
import com.example.demo.models.request.TrainingRequestModel;
import com.example.demo.models.response.*;
import com.example.demo.service.ITrainingService;
import com.example.demo.shared.dto.TeamDto;
import com.example.demo.shared.dto.TrainingDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/training")
    public class TrainingController {

    @Autowired
    public ITrainingService trainingService;

    @GetMapping(path="/all")
    public List<TrainingRest> getTrainingList(){
        List<TrainingRest> returnValue = new ArrayList<>();

        List<TrainingDto> trainings = trainingService.getTrainings();

        for(TrainingDto trainingDto: trainings){
            TrainingRest trainingModel = new TrainingRest();
            BeanUtils.copyProperties(trainingDto, trainingModel);
            returnValue.add(trainingModel);
        }
        return returnValue;
    }

    @GetMapping(path="/{id}")
    public TrainingRest getTrainingById(@PathVariable int id){

        TrainingRest returnValue = new TrainingRest();
        TrainingDto trainingDto = trainingService.getTrainingById(id);
        BeanUtils.copyProperties(trainingDto, returnValue);
        return returnValue;
    }

     @PostMapping()
    public TrainingEntity  createTraining(@RequestBody TrainingEntity newTraining){

        TrainingEntity createdTraining = trainingService.createTraining(newTraining);

        return createdTraining;
    }

    @PutMapping(path="/{id}")
    public TrainingRest updateTraining(@PathVariable int id,@RequestBody TrainingRequestModel trainingDetails)
    {
        TrainingRest returnValue = new TrainingRest();

        TrainingDto trainingDto = new TrainingDto();
        BeanUtils.copyProperties(trainingDetails, trainingDto);

        TrainingDto updateTraining = trainingService.updateTraining(id,trainingDto);
        BeanUtils.copyProperties(updateTraining, returnValue);

        return returnValue;

    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteTraining(@PathVariable int id){
        OperationStatusModel returnValue = new OperationStatusModel();

        trainingService.deleteTraining(id);

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        return returnValue;

    }
}

