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
import com.example.demo.entity.Localisation;
import com.example.demo.service.ActivityService;
import com.example.demo.service.ILocalisationService;

@RestController
@RequestMapping("/localisation")
public class LocalisationController {

	@Autowired
	public ILocalisationService localisationService;

	@GetMapping
	public List<Localisation> findAll() {
		List<Localisation> liste = localisationService.getLocalisations();
		if (liste != null) {
			return liste;
		} else {
			return liste = new ArrayList<Localisation>();
		}
	}
	
	@PostMapping
	public Localisation addLocalisation(@RequestBody Localisation newLocalisation) {
		return localisationService.addLocalisation(newLocalisation);
	}
	
	@DeleteMapping
	public void deleteLocalisation(int id) {
		localisationService.deleteLocalisation(id);
	}
	
//	@PostMapping("/update")
//	public Activity modifyActivity(@RequestBody Activity modifiedActivity) {
//		return actiService.modifyActivity(modifiedActivity);
//	}
	
}
