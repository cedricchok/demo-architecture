//package com.example.demo.controller;
//
//import com.example.demo.models.request.MessageDetailsRequestModel;
//import com.example.demo.models.response.MessageRest;
//import com.example.demo.service.IMessageService;
//import com.example.demo.shared.dto.MessageDto;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/message") // http://localhost:8080/messages
//public class MessageController {
//    @Autowired
//    IMessageService messageService;
//
//    @GetMapping
//    public String getMessage() {
//        return "get message was called";
//    }
//
//    @PostMapping()
//    public MessageRest createMessage(@RequestBody MessageDetailsRequestModel messageDetails) {
//        MessageRest returnValue = new MessageRest();
//
//        MessageDto messageDto = new MessageDto();
//        BeanUtils.copyProperties(messageDetails, messageDto);
//
//        MessageDto createdMessage = messageService.createMessage(messageDto);
//        BeanUtils.copyProperties(createdMessage, returnValue);
//
//        return returnValue;
//    }
//
//    @PutMapping
//    public String updateMessage() {
//        return "message is update";
//    }
//
//    @DeleteMapping
//    public String deleteMessage() {
//        return "message is delete";
//    }
//
//}
