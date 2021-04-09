package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ActivityRepository;
import com.example.demo.entity.Activity;

@Service
public class ActivityServiceImplementation implements ActivityService {
	
	public ActivityRepository actiRepository;

	public ActivityServiceImplementation(ActivityRepository actiRepository) {
		super();
		this.actiRepository = actiRepository;
	}

	@Override
	public List<Activity> findAll() {
		List<Activity> liste = new ArrayList<Activity>();
		actiRepository.findAll().forEach(liste::add);
		return liste;
//		return actiRepository.findAll();
	}

//	@Override
//	public Activity addActivity(Activity newActivity) {
//		return actiRepository.save(newActivity);
//	}
//	
//	@Override
//	public void deleteActivity(int id) {
//		actiRepository.deleteById(id);
//	}
	
	@Override
	public Activity findById(int id) {
		return actiRepository.getOne(id);
	}
	
//	@Override
//	public Activity modifyActivity(Activity activity) {
//		return actiRepository.save(activity);
//	}

}
