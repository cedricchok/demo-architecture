package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "result")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

 /* @ManyToOne(targetEntity = Competition.class)
	@JoinColumn( name = "competition_id", nullable = false)
	private Competition competition;*/

	@Column (name ="result_date",nullable = false)
	@NotNull
	private Date date;

	@Column (name = "score_eq1", nullable = false)
	@NotNull
	private int score_eq1;

	@Column (name = "score_eq2", nullable = false)
	@NotNull
	private int score_eq2;
}
