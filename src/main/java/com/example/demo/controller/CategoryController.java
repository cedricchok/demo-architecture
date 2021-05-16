package com.example.demo.controller;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.CompetitionEntity;
import com.example.demo.models.request.CategoryRequestModels;
import com.example.demo.models.response.*;
import com.example.demo.service.ICategoryService;
import com.example.demo.shared.dto.CategoryDto;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	public ICategoryService categoryService;

	@GetMapping(path = "/all")
	public List<CategoryRest> getCategoriesList() {
		List<CategoryRest> returnValue = new ArrayList<>();

		List<CategoryDto> categories = categoryService.getCategroies();

		for(CategoryDto categoryDto : categories){
			CategoryRest categoryModel = new CategoryRest();
			BeanUtils.copyProperties(categoryDto, categoryModel);
			returnValue.add(categoryModel);
		}
		return returnValue;
	}

	@GetMapping(path = "/{id}")
	public CategoryRest getCategoryById(@PathVariable int id){

		CategoryRest returnValue = new CategoryRest();
		CategoryDto categoryDto = categoryService.getCategoryById(id);
		BeanUtils.copyProperties(categoryDto, returnValue);
		return returnValue;
	}

    @PostMapping()
	public CategoryEntity createCategory(@RequestBody CategoryEntity newCategory){

		CategoryEntity createdCategory = categoryService.createCategory(newCategory);

		return createdCategory;
	}

	@PutMapping(path = "/{id}")
	public CategoryRest updateCategory(@PathVariable int id, @RequestBody CategoryRequestModels categoryDetails)
	{
		CategoryRest returnValue = new CategoryRest();

		CategoryDto categoryDto = new CategoryDto();
		BeanUtils.copyProperties(categoryDetails,categoryDto);

		CategoryDto updateCategory = categoryService.updateCategory(id, categoryDto);
		BeanUtils.copyProperties(updateCategory,returnValue);

			return returnValue;
	}

	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteCategory(@PathVariable int id){
		OperationStatusModel returnValue = new OperationStatusModel();

		categoryService.deleteCategory(id);

		returnValue.setOperationName(RequestOperationName.DELETE.name());
		returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		return returnValue;

	}


}
