package com.example.demo.service.impl;

import com.example.demo.dao.ICompetitionRepository;

import com.example.demo.entity.CompetitionEntity;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.response.ErrorMessages;
import com.example.demo.service.ICompetitionService;
import com.example.demo.shared.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements ICompetitionService {

    @Autowired
    public ICompetitionRepository compRepository;

    @Autowired
    public Utils utils;

    @Override
    public List<CompetitionEntity> getCompetitions() {
        List<CompetitionEntity> returnValue = compRepository.findAll();

        return returnValue;
    }

/*
        Iterable<CompetitionEntity> competitions = compRepository.findAll();
        for(CompetitionEntity competitionEntity: competitions ){
            CompetitionDto competitionDto = new CompetitionDto();
            BeanUtils.copyProperties(competitionEntity, competitionDto);
            returnValue.add(competitionDto);
        }
*/

    @Override
    public CompetitionEntity createCompetition(CompetitionEntity competition) {
        if(compRepository.findByTitle(competition.getTitle()) != null)
             throw new RuntimeException("Title alreay exists!");

        competition.setCompetitionId(utils.generateRandomEntityPublicId(30));

        CompetitionEntity storedCompetition = compRepository.save(competition);


        return storedCompetition;

    }

    @Override
    public void deleteCompetition(int id){
        CompetitionEntity competitionEntity = compRepository.findCompetitionById(id);

        if(competitionEntity == null)
            throw new NotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        compRepository.delete(competitionEntity);

    }

    @Override
    public CompetitionEntity getCompetitionById(int id) {
        CompetitionEntity competitionEntity = compRepository.findCompetitionById(id);

        if (competitionEntity == null)
            throw new NotFoundException("Competition introuvable");

        return competitionEntity;
    }
/*    public CompetitionDto getCompetitionById(int id){
        CompetitionDto returnValue = new CompetitionDto();
        CompetitionEntity competitionEntity = compRepository.findCompetitionById(id);

        if(competitionEntity == null)
            throw new NotFoundException("Competition introuvable");

        BeanUtils.copyProperties(competitionEntity, returnValue);

        return returnValue;
    }*/

/*    @Override
    public CompetitionDto updateCompetition(int id, CompetitionDto competition){

        CompetitionDto returnValue = new CompetitionDto();
        CompetitionEntity competitionEntity = compRepository.findCompetitionById(id);

        if(competitionEntity == null)
            throw new NotFoundException("competition introuvale");

        competitionEntity.setTitle(competition.getTitle());

        CompetitionEntity updateCompetition = compRepository.save(competitionEntity);
        BeanUtils.copyProperties(updateCompetition, returnValue);

        return returnValue;

    }*/
    @Override
    public CompetitionEntity updateCompetition(CompetitionEntity competition) {

        //CompetitionEntity competitionEntity = compRepository.findCompetitionById(id);

        CompetitionEntity updatedCompetition = compRepository.save(competition);

        return updatedCompetition;
    }
}
