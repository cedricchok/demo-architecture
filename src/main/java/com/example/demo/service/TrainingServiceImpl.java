package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITrainingRepository;
import com.example.demo.entity.Training;

@Service
public class TrainingServiceImpl {

	@Autowired
	public ITrainingRepository trainingRepo;

	public List<Training> findAll() {
		List<Training> liste = new ArrayList<Training>();
		trainingRepo.findAll().forEach(liste::add);
		return liste;
//		return trainingRepo.findAll();
	}

//	@Override
//	public Training addTraining(Training newTraining) {
//		return trainingRepo.save(newTraining);
//	}
//	
//	@Override
//	public void deleteTraining(int id) {
//		trainingRepo.deleteById(id);
//	}
	
	public Training findById(int id) {
		return trainingRepo.getOne(id);
	}
}
