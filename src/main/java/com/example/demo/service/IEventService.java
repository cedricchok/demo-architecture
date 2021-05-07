package com.example.demo.service;

		import org.springframework.security.core.eventdetails.EventDetailsService;

		import com.example.demo.shared.dto.EventDto;

public interface IEventService extends EventDetailsService{
	EventDto createEvent(EventDto event);

}
