package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;

  /* @ManyToOne(targetEntity = Club.class)
	@JoinColumn(nullable = false)
	private Club club;*/

	@Column(name = "title" , nullable = false, length = 100)
	@NotNull
	private String title;

	@Column(name = "description", nullable = false, length = 300)
	@NotNull
	private String description;

	@Column(name = "date", nullable = false)
	@NotNull
	private Date date;

}
