package com.example.demo.controller;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.models.request.CategoryRequestModels;
import com.example.demo.models.response.CategoryRest;
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

//    @GetMapping()
//    public List<CategoryRest> findAll() {
//        List<CategoryDto> liste = categoryService.findAll();
//        if(liste != null){
//            return liste;
//        } else {
//            return liste = new ArrayList<CategoryDto>();
//        }
//    }

	@PostMapping()
	public CategoryRest createCategory(@RequestBody CategoryRequestModels newCategory) {
		// Objet retourné par l'api
		CategoryRest returnValue = new CategoryRest();

		CategoryDto categoryDto = new CategoryDto();
		BeanUtils.copyProperties(newCategory, categoryDto);

		CategoryDto createdCategory = categoryService.createCategory(categoryDto);
		BeanUtils.copyProperties(createdCategory, returnValue);

		return returnValue;
	}

//	@DeleteMapping(path = "/{id}")
//	public void deleteCategoryById(@PathVariable int id) {
//		cateService.deleteCategory(id);
//	}
//
//	@GetMapping(path = "/{id}")
//	public void searchCategoryById(@PathVariable int id) {
//		cateService.findById(id);
//	}
}
