package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "training")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

/*	@ManyToOne(targetEntity = Team.class)
	@JoinColumn(name = "team_id")
	private Team team;*/

	@Column(name = "tr_date")
	@NotNull
	private Date tr_date;

	@Column(name = "team_name")
	@NotNull
	private String team_name;


}
