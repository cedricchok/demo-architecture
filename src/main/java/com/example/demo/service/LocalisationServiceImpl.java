package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ILocalisationRepository;
import com.example.demo.entity.Localisation;

@Service
public class LocalisationServiceImpl {

	@Autowired
	public ILocalisationRepository localisationRepo;

//	public List<Localisation> findAll() {
//		List<Localisation> liste = new ArrayList<Localisation>();
//		localisationRepo.findAll().forEach(liste::add);
//		return liste;
//	}

	public Localisation addLocalisation(Localisation newLocalisation) {
		return localisationRepo.save(newLocalisation);
	}
	
	public void deleteLocalisation(int id) {
		localisationRepo.deleteById(id);
	}
	
	public Localisation findById(int id) {
		return localisationRepo.getOne(id);
	}
}
