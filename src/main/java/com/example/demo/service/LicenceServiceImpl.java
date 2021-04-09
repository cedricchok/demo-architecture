package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ILicenceRepository;
import com.example.demo.entity.Licence;

@Service
public class LicenceServiceImpl {

	@Autowired
	public ILicenceRepository licenceRepo;

	public List<Licence> findAll() {
		List<Licence> liste = new ArrayList<Licence>();
		licenceRepo.findAll().forEach(liste::add);
		return liste;
	}

//	@Override
//	public Licence addLicence(Licence newLicence) {
//		return licenceRepo.save(newLicence);
//	}
//	
//	@Override
//	public void deleteLicence(int id) {
//		licenceRepo.deleteById(id);
//	}
	
	public Licence findById(int id) {
		return licenceRepo.getOne(id);
	}
}
