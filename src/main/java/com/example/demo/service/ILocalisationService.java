package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Localisation;

public interface ILocalisationService {

	public List<Localisation> getLocalisations();
	
	public Localisation addLocalisation(Localisation newLocalisation);
	
	public void deleteLocalisation(int id);
	
	public Localisation getLocalisationById(int id);
}
