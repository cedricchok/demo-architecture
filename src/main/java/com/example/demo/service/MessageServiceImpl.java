package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMessageRepository;
import com.example.demo.entity.Message;

@Service
public class MessageServiceImpl {

	@Autowired
	public IMessageRepository messageRepo;

	public List<Message> findAll() {
		List<Message> liste = new ArrayList<Message>();
		messageRepo.findAll().forEach(liste::add);
		return liste;
	}

	public Message addMessage(Message newMessage) {
		return messageRepo.save(newMessage);
	}
	
	public void deleteMessage(int id) {
		messageRepo.deleteById(id);
	}
	
	public Message findById(int id) {
		return messageRepo.getOne(id);
	}
}
