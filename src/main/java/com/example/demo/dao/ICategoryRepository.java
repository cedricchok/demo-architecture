package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CategoryEntity;

@Repository
public interface ICategoryRepository extends CrudRepository<CategoryEntity, Long> {
	CategoryEntity findByTitle(String title);
}
