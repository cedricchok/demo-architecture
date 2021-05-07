package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "result")
public class ResultEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int score_t1;
	private int score_t2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore_t1() {
		return score_t1;
	}
	public void setScore_t1(int score_t1) {
		this.score_t1 = score_t1;
	}
	public int getScore_t2() {
		return score_t2;
	}
	public void setScore_t2(int score_t2) {
		this.score_t2 = score_t2;
	}
}
