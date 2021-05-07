package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.shared.dto.EventDto;

@Service
public interface IEventService {
	EventDto createEvent(EventDto event);

}
