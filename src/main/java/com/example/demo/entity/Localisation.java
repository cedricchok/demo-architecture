package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "localisation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Localisation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

 /* @OneToOne(targetEntity = Club.class)
	@JoinColumn(nullable = false, name = "club_id")
	private Club club;*/

	@Column(name = "coord", nullable = false)
	@NotNull
	private String coord;
}
