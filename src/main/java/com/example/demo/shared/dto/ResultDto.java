package com.example.demo.shared.dto;

import java.io.Serializable;

public class ResultDto implements Serializable {


	private static final long serialVersionUID = 5679506263042272484L;

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
