package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.CompetitionEntity;
import com.example.demo.shared.dto.CategoryDto;
import com.example.demo.shared.dto.CompetitionDto;
import com.example.demo.shared.dto.UserDto;

public interface ICategoryService {

	List<CategoryDto> getCategroies();

	CategoryEntity createCategory(CategoryEntity category);

	void deleteCategory(int categoryId);

	CategoryDto getCategoryById(int categoryId);

	CategoryDto updateCategory(int id, CategoryDto category);

}


