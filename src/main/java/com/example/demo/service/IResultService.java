package com.example.demo.service;

import org.springframework.security.core.resultdetails.ResultDetailsService;

import com.example.demo.shared.dto.ResultDto;

public interface IResultService extends ResultDetailsService{
	ResultDto createResult(ResultDto result);

}
