package com.example.demo.shared.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {

	private static final long serialVersionUID = 2787610689383348079L;
	private int id;
	private String categoryId;
	private String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
