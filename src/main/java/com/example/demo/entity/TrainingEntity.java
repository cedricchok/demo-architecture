package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name = "training")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String trainingId;
/*	@ManyToOne(targetEntity = Team.class)
	@JoinColumn(name = "team_id")
	private Team team;*/

	@Column(name = "title")
	@NotNull
	private String title;

	@Column(name = "tr_date",nullable = false)
	@NotNull
	private Calendar tr_date;

	@Column(name = "team_name")
	@NotNull
	private String team_name;

}
