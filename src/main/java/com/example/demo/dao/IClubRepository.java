package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Club;

@Repository
public interface IClubRepository extends JpaRepository<Club, Integer> {

}
