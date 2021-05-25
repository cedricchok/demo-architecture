package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TrainingEntity;

@Repository
public interface ITrainingRepository extends CrudRepository<TrainingEntity, Long> {

    TrainingEntity findByTitle(String title);

    TrainingEntity findTrainingById(int trainingId);

}
