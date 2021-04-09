package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Category;

public interface ICategoryService {
	
	public List<Category> getCategories();
	
//	public Category addCategory(Category newCategory);
	
//	public void deleteCategory(int id);
	
	public Category getCategoryById(int id);

}
