package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Licence;

public interface ILicenceService {

	public List<Licence> getLicences();
	
	public Licence addLicence(Licence newLicence);
	
//	public void deleteLicence(int id);
	
	public Licence getLicenceById(int id);
}
