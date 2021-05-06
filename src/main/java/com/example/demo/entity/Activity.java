package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="activity")
@Data
@NoArgsConstructor
@AllArgsConstructor // éviter pour créér constructor avec parameters
public class Activity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

  /* @OneToOne(mappedBy = "activity", cascade = CascadeType.REMOVE, targetEntity = Image.class)
	@JoinColumn(nullable = false, name = "image_id")
	private Image image;*/

	@Column(name = "label", nullable = false, length = 100)
	@NotNull
	private String label;

	@Column(name = "description", nullable = false, length = 300)
	@NotNull
	private String description;


}
