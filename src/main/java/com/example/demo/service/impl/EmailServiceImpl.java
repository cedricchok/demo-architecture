package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {

	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMessage(String to, String subject, String content) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("asrouenaston@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		emailSender.send(message);

	}
}