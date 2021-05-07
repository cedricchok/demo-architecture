package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IResultRepository;
import com.example.demo.entity.ResultEntity;

@Service
public class ResultServiceImpl {

	@Autowired
	public IResultRepository resultRepo;

	public List<ResultEntity> findAll() {
		List<ResultEntity> liste = new ArrayList<ResultEntity>();
		resultRepo.findAll().forEach(liste::add);
		return liste;
	}

	public ResultEntity addResult(ResultEntity newResult) {
		return resultRepo.save(newResult);
	}
//	
//	@Override
//	public void deleteResult(int id) {
//		resultRepo.deleteById(id);
//	}
	
	public ResultEntity findById(int id) {
		return resultRepo.getOne(id);
	}
}
