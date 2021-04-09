package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IImageRepository;
import com.example.demo.entity.Image;

@Service
public class ImageServiceImpl {

	@Autowired
	public IImageRepository imageRepo;

//	public List<Image> findAll() {
//		List<Image> liste = new ArrayList<Image>();
//		imageRepo.findAll().forEach(liste::add);
//		return liste;
//	}

	public Image addImage(Image newImage) {
		return imageRepo.save(newImage);
	}
	
	public void deleteImage(int id) {
		imageRepo.deleteById(id);
	}
	
	public Image findById(int id) {
		return imageRepo.getOne(id);
	}
}
