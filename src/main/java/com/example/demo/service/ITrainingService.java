package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TrainingEntity;
import com.example.demo.shared.dto.TrainingDto;

public interface ITrainingService {

	List<TrainingDto> getTrainings();

	TrainingEntity createTraining(TrainingEntity training);

	void deleteTraining(int trainingId);

	TrainingDto getTrainingById(int trainingId);

	TrainingDto updateTraining(int trainingId, TrainingDto training);
}
