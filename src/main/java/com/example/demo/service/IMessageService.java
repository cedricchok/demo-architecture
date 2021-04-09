package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Message;

public interface IMessageService {

	public List<Message> getMessages();
	
	public Message addMessage(Message newMessage);
	
	public void deleteMessage(int id);
	
	public Message getMessageById(int id);
}
