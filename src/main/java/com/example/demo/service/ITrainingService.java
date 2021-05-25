package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TrainingEntity;

public interface ITrainingService {

	List<TrainingEntity> getTrainings();

	TrainingEntity createTraining(TrainingEntity training);

	void deleteTraining(int trainingId);

	TrainingEntity getTrainingById(int trainingId);

	TrainingEntity updateTraining(TrainingEntity training);
}
