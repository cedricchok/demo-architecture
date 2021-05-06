package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "competition")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(name = "title", nullable = false)
	@NotNull
	private String title;

	@Column(name = "date" , nullable = false)
	@NotNull
	private Date date;


  /* @OneToMany(cascade = {CascadeType.REMOVE },targetEntity = Team.class, mappedBy = "competition")
	private List<Team> team = new ArrayList<>();*/

}
