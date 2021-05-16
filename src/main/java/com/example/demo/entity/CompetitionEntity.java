package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name = "competition")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int id;

	@Column(nullable = false)
	private String competitionId;

	@Column(name = "title", nullable = false)
	@NotNull
	private String title;

	@Column(name = "cp_date", nullable = false)
	@NotNull
	private Calendar cp_date;


  /* @OneToMany(cascade = {CascadeType.REMOVE },targetEntity = Team.class, mappedBy = "competition")
	private List<Team> team = new ArrayList<>();*/

}
