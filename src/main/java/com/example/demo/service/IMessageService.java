package com.example.demo.service;


import com.example.demo.shared.dto.MessageDto;

public interface IMessageService {
	MessageDto createMessage(MessageDto message);

}
