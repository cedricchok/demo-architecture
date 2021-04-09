package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICategoryRepository;
import com.example.demo.entity.Category;

@Service
public class CategoryServiceImpl {

	@Autowired
	public ICategoryRepository categoryRepo;


	public List<Category> findAll() {
		List<Category> liste = new ArrayList<Category>();
		categoryRepo.findAll().forEach(liste::add);
		return liste;
	}

//	@Override
//	public Category addCategory(Category newCategory) {
//		return categoryRepo.save(newCategory);
//	}
//	
//	@Override
//	public void deleteCategory(int id) {
//		categoryRepo.deleteById(id);
//	}
	
	public Category findById(int id) {
		return categoryRepo.getOne(id);
	}
	
}
