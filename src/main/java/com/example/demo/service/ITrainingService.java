package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Training;

public interface ITrainingService {

	public List<Training> findAll();
	
    public Training addTraining(Training newTraining);
	
 	public void deleteTraining(int id);
	
	public Training findById(int id);
}
