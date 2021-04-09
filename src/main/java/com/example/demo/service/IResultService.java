package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Result;

public interface IResultService {

	public List<Result> getResults();
	
	public Result addResult(Result newResult);
	
//	public void deleteResult(int id);
	
	public Result getResultById(int id);
}
