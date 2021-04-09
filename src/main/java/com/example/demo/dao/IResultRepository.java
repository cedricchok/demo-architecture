package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Result;

@Repository
public interface IResultRepository extends JpaRepository<Result, Integer> {

}
