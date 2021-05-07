package com.example.demo.service;

import java.util.List;

import com.example.demo.shared.dto.CategoryDto;

public interface ICategoryService {

	List<CategoryDto> findAll();

	CategoryDto createCategory(CategoryDto category);

	CategoryDto deleteCategory(String categoryId);

	CategoryDto findByCategoryId(String categoryId);

	CategoryDto updateCategory(String categoryId, CategoryDto category);

}
