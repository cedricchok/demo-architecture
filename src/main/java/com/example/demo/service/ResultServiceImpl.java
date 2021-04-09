package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IResultRepository;
import com.example.demo.entity.Result;

@Service
public class ResultServiceImpl {

	@Autowired
	public IResultRepository resultRepo;

	public List<Result> findAll() {
		List<Result> liste = new ArrayList<Result>();
		resultRepo.findAll().forEach(liste::add);
		return liste;
	}

	public Result addResult(Result newResult) {
		return resultRepo.save(newResult);
	}
//	
//	@Override
//	public void deleteResult(int id) {
//		resultRepo.deleteById(id);
//	}
	
	public Result findById(int id) {
		return resultRepo.getOne(id);
	}
}
