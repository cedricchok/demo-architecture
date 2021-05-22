package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CategoryEntity;

public interface ICategoryService {

	List<CategoryEntity> getCategories();

	CategoryEntity createCategory(CategoryEntity category);

	void deleteCategory(int categoryId);

	CategoryEntity getCategoryById(int categoryId);

	CategoryEntity updateCategory(CategoryEntity category);

}


