package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "licence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Licence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

 /* @ManyToOne(targetEntity = Activity.class)
	@JoinColumn(name = "activity_id", nullable = false)
	@NotNull
	private Activity activity;*/

	@Column(name = "title" , nullable = false)
	@NotNull
	private String title;

	@Column(name = "description", nullable = false)
	@NotNull
	private String description;

	@Column(name = "price", nullable = false)
	@NotNull
	private float price ;

}
