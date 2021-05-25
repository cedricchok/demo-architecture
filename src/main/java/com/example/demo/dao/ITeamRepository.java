package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TeamEntity;

@Repository
public interface ITeamRepository extends CrudRepository<TeamEntity, Long> {

    TeamEntity findByLabel(String label);

    TeamEntity findTeamById(int teamId);

}
