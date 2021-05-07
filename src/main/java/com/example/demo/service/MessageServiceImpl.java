package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMessageRepository;
import com.example.demo.entity.MessageEntity;

@Service
public class MessageServiceImpl {

	@Autowired
	public IMessageRepository messageRepo;

	public List<MessageEntity> findAll() {
		List<MessageEntity> liste = new ArrayList<MessageEntity>();
		messageRepo.findAll().forEach(liste::add);
		return liste;
	}

	public MessageEntity addMessage(MessageEntity newMessage) {
		return messageRepo.save(newMessage);
	}
	
	public void deleteMessage(int id) {
		messageRepo.deleteById(id);
	}
	
	public MessageEntity findById(int id) {
		return messageRepo.getOne(id);
	}
}
