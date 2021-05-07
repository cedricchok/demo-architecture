package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ResultEntity;

@Repository
public interface IResultRepository extends JpaRepository<ResultEntity, Integer> {

}
