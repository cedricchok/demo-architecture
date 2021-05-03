package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Licence;
import com.example.demo.service.ILicenceService;

@RestController
@RequestMapping("/licences")
public class LicenceController {

	@Autowired
	public ILicenceService licenceService;

	@GetMapping
	public List<Licence> getLicences() {
		List<Licence> liste = licenceService.getLicences();
		if (liste != null) {
			return liste;
		} else {
			return liste = new ArrayList<Licence>();
		}
	}
	
	@PostMapping
	public Licence addALicence(@RequestBody Licence newLicence) {
		return licenceService.addLicence(newLicence);
	}
//	
//	@DeleteMapping
//	public void deleteLicence(int id) {
//		licenceService.deleteLicence(id);
//	}
}
