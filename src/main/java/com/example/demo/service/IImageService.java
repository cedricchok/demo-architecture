package com.example.demo.service;

import com.example.demo.entity.Image;

public interface IImageService {

//	public List<Image> getImages();
	
	public Image addImage(Image newImage);
	
	public void deleteImage(int id);
	
	public Image getImageByUserId(int userId);
}
