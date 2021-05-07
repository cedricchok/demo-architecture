////package com.example.demo.controller;
//
//import com.example.demo.models.request.ResultDetailsRequestModel;
//import com.example.demo.models.response.ResultRest;
//import com.example.demo.service.IResultService;
//import com.example.demo.shared.dto.ResultDto;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/result") // http://localhost:8080/results
//public class ResultController {
//    @Autowired
//    IResultService resultService;
//
//    @GetMapping
//    public String getResult() {
//        return "get result was called";
//    }
//
//    @PostMapping()
//    public ResultRest createResult(@RequestBody ResultDetailsRequestModel resultDetails) {
//        ResultRest returnValue = new ResultRest();
//
//        ResultDto resultDto = new ResultDto();
//        BeanUtils.copyProperties(resultDetails, resultDto);
//
//        ResultDto createdResult = resultService.createResult(resultDto);
//        BeanUtils.copyProperties(createdResult, returnValue);
//
//        return returnValue;
//    }
//
//    @PutMapping
//    public String updateResult() {
//        return "result is update";
//    }
//
//    @DeleteMapping
//    public String deleteResult() {
//        return "result is delete";
//    }
//
//}
