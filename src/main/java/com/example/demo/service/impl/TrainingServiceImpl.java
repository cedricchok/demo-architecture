package com.example.demo.service.impl;


import com.example.demo.dao.ITrainingRepository;
import com.example.demo.entity.TrainingEntity;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.response.ErrorMessages;
import com.example.demo.service.ITrainingService;
import com.example.demo.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements ITrainingService {

    @Autowired
    public ITrainingRepository trainRepository;

    @Autowired
    public Utils utils;

    @Override
    public List<TrainingEntity> getTrainings() {

        List<TrainingEntity> returnValue = (List<TrainingEntity>) trainRepository.findAll();

        return returnValue;

    }

    @Override
    public TrainingEntity createTraining(TrainingEntity training){
        if(trainRepository.findByTitle(training.getTitle()) != null)
            throw new RuntimeException("Title already exists!");

        training.setTrainingId(utils.generateRandomEntityPublicId(30));

        TrainingEntity storedTraining = trainRepository.save(training);

        return storedTraining;
    }
    /* @Override
    public TrainingDto createTraining(TrainingEntity training) {
        if(trainRepository.findByTitle(training.getTitle()) != null)
            throw new RuntimeException("This training already exists!");

        TrainingEntity trainingEntity = new TrainingEntity();
        BeanUtils.copyProperties(trainingEntity,training);

        String publicTrainingId = utils.generateRandomEntityPublicId(30);
        trainingEntity.setTrainingId(publicTrainingId);

        TrainingEntity storedTraining = trainRepository.save(trainingEntity);

        TrainingDto returnValue = new TrainingDto();
        BeanUtils.copyProperties(storedTraining, returnValue);
        return  returnValue;
    }*/
     @Override
    public void deleteTraining(int trainingId){
        TrainingEntity trainingEntity = trainRepository.findTrainingById(trainingId);

        if(trainingEntity == null)
            throw new NotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        trainRepository.delete(trainingEntity);

    }

    @Override
    public TrainingEntity getTrainingById(int id){

        TrainingEntity trainingEntity = trainRepository.findTrainingById(id);

        if(trainingEntity == null)
            throw new NotFoundException("Training introuvable");

        return trainingEntity;
    }

    @Override
    public TrainingEntity updateTraining(TrainingEntity training) {

        TrainingEntity updatedTraining = trainRepository.save(training);

        return updatedTraining;
    }
}
