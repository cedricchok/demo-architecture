package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.CompetitionEntity;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.response.ErrorMessages;
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
	public ICategoryRepository cateRepository;

	@Autowired
	public Utils utils;

	@Override
	public List<CategoryDto> getCategroies() {
		List<CategoryDto> returnValue = new ArrayList<>();

		Iterable<CategoryEntity> categories = cateRepository.findAll();
		for(CategoryEntity categoryEntity: categories){
			CategoryDto categoryDto = new CategoryDto();
			BeanUtils.copyProperties(categoryEntity, categoryDto);
			returnValue.add(categoryDto);
		}

		return returnValue;
	}

	@Override
	public CategoryEntity createCategory(CategoryEntity category) {
		// Verifier qu'un titre est bien renseigné
		if (cateRepository.findByTitle(category.getTitle()) != null)
			throw new RuntimeException("Title already exists !");

        category.setCategoryId(utils.generateRandomEntityPublicId(30));

        CategoryEntity storedCategory = cateRepository.save(category);

        return storedCategory;

	}

	@Override
	public void deleteCategory(int id) {
		CategoryEntity categoryEntity = cateRepository.findCategoryById(id);

		if(categoryEntity == null)
			throw new NotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		cateRepository.delete(categoryEntity);

	}

	@Override
	public CategoryDto getCategoryById(int id) {
		CategoryDto returnValue = new CategoryDto();
		CategoryEntity categoryEntity = cateRepository.findCategoryById(id);

		if(categoryEntity == null)
			throw new NotFoundException("Category introuvable");

		BeanUtils.copyProperties(categoryEntity, returnValue);

		return returnValue;
	}
	@Override
	public CategoryDto updateCategory(int id, CategoryDto category) {

		CategoryDto returnValue = new CategoryDto();
		CategoryEntity categoryEntity = cateRepository.findCategoryById(id);

		if (categoryEntity == null)
			throw new NotFoundException("Category introuvable");

		categoryEntity.setTitle(category.getTitle());

		CategoryEntity updateCategory = cateRepository.save(categoryEntity);
		BeanUtils.copyProperties(updateCategory, returnValue);

		return returnValue;
	}
}
