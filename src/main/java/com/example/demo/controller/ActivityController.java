package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Activity;
import com.example.demo.service.ActivityService;

@RestController
@RequestMapping("/activities")
public class ActivityController {

	@Autowired
	public ActivityService actiService;

	@GetMapping
	public List<Activity> findAll() {
		List<Activity> liste = actiService.findAll();
		if (liste != null) {
			return liste;
		} else {
			return liste = new ArrayList<Activity>();
		}
	}
	
	@PostMapping
	public Activity addActivity(@RequestBody Activity newActivity) {
		return actiService.addActivity(newActivity);
	}
	
	@DeleteMapping
	public void deleteActivity(int id) {
		actiService.deleteActivity(id);
	}
	
//	@PostMapping("/update")
//	public Activity modifyActivity(@RequestBody Activity modifiedActivity) {
//		return actiService.modifyActivity(modifiedActivity);
//	}

}
