package com.example.demo.service;

import org.springframework.security.core.messagedetails.MessageDetailsService;

import com.example.demo.shared.dto.MessageDto;

public interface IMessageService {
	MessageDto createMessage(MessageDto message);

}
