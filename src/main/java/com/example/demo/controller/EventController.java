//package com.example.demo.controller;
//
//import com.example.demo.models.request.EventDetailsRequestModel;
//import com.example.demo.models.response.EventRest;
//import com.example.demo.service.IEventService;
//import com.example.demo.shared.dto.EventDto;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/event") // http://localhost:8080/events
//public class EventController {
//    @Autowired
//    IEventService eventService;
//
//    @GetMapping
//    public String getEvent() {
//        return "get event was called";
//    }
//
//    @PostMapping()
//    public EventRest createEvent(@RequestBody EventDetailsRequestModel eventDetails) {
//        EventRest returnValue = new EventRest();
//
//        EventDto eventDto = new EventDto();
//        BeanUtils.copyProperties(eventDetails, eventDto);
//
//        EventDto createdEvent = eventService.createEvent(eventDto);
//        BeanUtils.copyProperties(createdEvent, returnValue);
//
//        return returnValue;
//    }
//
//    @PutMapping
//    public String updateEvent() {
//        return "event is update";
//    }
//
//    @DeleteMapping
//    public String deleteEvent() {
//        return "event is delete";
//    }
//
//}
