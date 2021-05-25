package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String categoryId;

	@Column(name = "title", nullable = false, unique = true)
	@NotNull
	private String title;

}
