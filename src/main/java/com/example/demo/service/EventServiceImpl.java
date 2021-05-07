package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEventRepository;
import com.example.demo.entity.EventEntity;

@Service
public class EventServiceImpl {

	@Autowired
	public IEventRepository eventRepo;

	public List<EventEntity> findAll() {
		List<EventEntity> liste = new ArrayList<EventEntity>();
		eventRepo.findAll().forEach(liste::add);
		return liste;
	}

//	@Override
//	public Event addEvent(Event newEvent) {
//		return eventRepo.save(newEvent);
//	}
//	
//	@Override
//	public void deleteEvent(int id) {
//		eventRepo.deleteById(id);
//	}
	
//	public Event findById(int id) {
//		return eventRepo.getOne(id);
//	}
}
