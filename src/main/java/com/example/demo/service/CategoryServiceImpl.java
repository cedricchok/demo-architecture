package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICategoryRepository;
import com.example.demo.entity.Category;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
	public ICategoryRepository cateRepository;

/*	public CategoryServiceImpl(ICategoryRepository cateRepository) {
		super();
		this.cateRepository = cateRepository;
	}*/


	@Override
	public List<Category> findAll() {
		List<Category> liste = new ArrayList<Category>();
		cateRepository.findAll().forEach(liste::add);
		return liste;
	}

	@Override
	public Category addCategory(Category newCategory) {
	return cateRepository.save(newCategory);
	}

	@Override
    public void deleteCategory(int id) {
		cateRepository.deleteById(id);
	}
    @Override
	public Category findById(int id) {
		return cateRepository.getOne(id);
	}

}
