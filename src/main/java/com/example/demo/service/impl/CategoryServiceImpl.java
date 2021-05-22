package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.response.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICategoryRepository;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.service.ICategoryService;
import com.example.demo.shared.Utils;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	public ICategoryRepository cateRepository;

	@Autowired
	public Utils utils;

/*	@Override
	public List<CategoryEntity> getCategroies() {
		List<CategoryEntity> returnValue = new ArrayList<>();

		Iterable<CategoryEntity> categories = cateRepository.findAll();
		for(CategoryEntity categoryEntity: categories){
			CategoryDto categoryDto = new CategoryDto();
			BeanUtils.copyProperties(categoryEntity, categoryDto);
			returnValue.add(categoryDto);
		}

		return returnValue;
	}*/


	@Override
	public List<CategoryEntity> getCategories() {

		List<CategoryEntity> returnValue = (List<CategoryEntity>) cateRepository.findAll();

		return returnValue;
	}


/*
        Iterable<CompetitionEntity> competitions = compRepository.findAll();
        for(CompetitionEntity competitionEntity: competitions ){
            CompetitionDto competitionDto = new CompetitionDto();
            BeanUtils.copyProperties(competitionEntity, competitionDto);
            returnValue.add(competitionDto);
        }
*/

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
	public CategoryEntity getCategoryById(int id) {

		CategoryEntity categoryEntity = cateRepository.findCategoryById(id);

		if(categoryEntity == null)
			throw new NotFoundException("Category introuvable");

		return categoryEntity;
	}

    @Override
	public CategoryEntity updateCategory(CategoryEntity category){

		CategoryEntity updatedCategory = cateRepository.save(category);

		return updatedCategory;
	}
}
