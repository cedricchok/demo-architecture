package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Activity;

public interface ActivityService {

	public List<Activity> findAll();
	
//	public Activity addActivity(Activity newActivity);
	
//	public void deleteActivity(int id);
	
	public Activity findById(int id);
	
//	public Activity modifyActivity(Activity modifiedActivity);
}
