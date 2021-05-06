package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITrainingRepository;
import com.example.demo.entity.Training;

@Service
public class TrainingServiceImpl implements ITrainingService{

	@Autowired
	public ITrainingRepository trainRepository;

	@Override
	public List<Training> findAll() {
		List<Training> liste = new ArrayList<Training>();
		trainRepository.findAll().forEach(liste::add);
		return liste;
	}

 	@Override
	public Training addTraining(Training newTraining) {
		return trainRepository.save(newTraining);
	}

	@Override
	public void deleteTraining(int id) {
		trainRepository.deleteById(id);
	}
	@Override
	public Training findById(int id) {
		return trainRepository.getOne(id);
	}
}
