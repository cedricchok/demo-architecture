package com.example.demo.dao;

import com.example.demo.entity.CompetitionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ICompetitionRepository extends CrudRepository<CompetitionEntity, Long> {

    CompetitionEntity findByTitle(String title);

    CompetitionEntity findCompetitionById(int competitionId);

}
