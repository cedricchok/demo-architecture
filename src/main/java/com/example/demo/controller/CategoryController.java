package com.example.demo.controller;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.models.response.*;
import com.example.demo.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	public ICategoryService categoryService;

	@GetMapping(path = "/all")
	public List<CategoryEntity> getCategoriesList() {

		List<CategoryEntity> returnValue = categoryService.getCategories();

    	return returnValue;
	}

	@GetMapping(path = "/{id}")
	public CategoryEntity getCategoryById(@PathVariable int id){

		CategoryEntity returnValue = categoryService.getCategoryById(id);

		return returnValue;
	}

    @PostMapping()
	public CategoryEntity createCategory(@RequestBody CategoryEntity newCategory){

		CategoryEntity createdCategory = categoryService.createCategory(newCategory);

		return createdCategory;
	}

    @PutMapping(path = "/{id}")
	public CategoryEntity updateCateogry(@RequestBody CategoryEntity category){

		CategoryEntity updatedCategory = categoryService.updateCategory(category);

		return updatedCategory;
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
