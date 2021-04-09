package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Competition;

@Repository
public interface ICompetitionRepository extends JpaRepository<Competition, Integer> {

}
