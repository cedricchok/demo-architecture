package com.example.demo.dao;

import com.example.demo.entity.CompetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ICompetitionRepository extends JpaRepository<CompetitionEntity, Integer> {

    CompetitionEntity findByTitle(String title);

    CompetitionEntity findCompetitionById(int competitionId);

}
