package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "team")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

 /*   @OneToOne(targetEntity = Activity.class)
	@JoinColumn(nullable = false, name ="activity_id")
	private Activity activity;

	@OneToOne(targetEntity =  Category.class)
	@JoinColumn(nullable = false, name = "category_id")
	private Category category;*/

	@Column(name="label")
	@NotNull
	private String label;

	@Column(name = "nb_players")
	@NotNull
	private int nb_players;
}
