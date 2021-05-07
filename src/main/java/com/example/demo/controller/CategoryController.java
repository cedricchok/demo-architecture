package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    public ICategoryService cateService;

    @GetMapping(value = "/list")
    public List<Category> findAll() {
        List<Category> liste = cateService.findAll();
        if(liste != null){
            return liste;
        } else {
            return liste = new ArrayList<Category>();
        }
    }

    @PostMapping()
    public Category addCategory(@RequestBody Category newCategory) {
        return cateService.addCategory(newCategory); }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCategoryById(@PathVariable  int id) {
        cateService.deleteCategory(id);}

    @GetMapping(path = "/{id}")
    public void searchCategoryById(@PathVariable int id) {
        cateService.findById(id);}
}


