package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "category")

@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String categoryId;

	@Column(name = "title", nullable = false, unique = true)
	@NotNull
	private String title;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
