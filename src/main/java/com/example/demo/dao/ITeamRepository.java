package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Team;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer> {

}
