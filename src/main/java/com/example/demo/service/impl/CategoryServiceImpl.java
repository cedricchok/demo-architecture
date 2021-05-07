package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICategoryRepository;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.service.ICategoryService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.CategoryDto;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	public ICategoryRepository categoryRepo;

	@Autowired
	public Utils utils;

	@Override
	public List<CategoryDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto createCategory(CategoryDto category) {
		// Verifier qu'un titre est bien renseigné
		if (categoryRepo.findByTitle(category.getTitle()) != null)
			throw new RuntimeException("Title already exists !");

		CategoryEntity categoryEntity = new CategoryEntity();
		BeanUtils.copyProperties(category, categoryEntity);

		String publicCategoryId = utils.generateRandomEntityPublicId(30);
		categoryEntity.setCategoryId(publicCategoryId);

		CategoryEntity storedCategory = categoryRepo.save(categoryEntity);

		CategoryDto returnValue = new CategoryDto();
		BeanUtils.copyProperties(storedCategory, returnValue);
		return returnValue;

	}

	@Override
	public CategoryDto deleteCategory(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto findByCategoryId(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto updateCategory(String categoryId, CategoryDto category) {
		// TODO Auto-generated method stub
		return null;
	}

}
