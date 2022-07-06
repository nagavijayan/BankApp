package com.demo.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bankapp.dto.EmailMessage;
import com.demo.bankapp.service.EmailSenderService;

@RestController
@Controller
@Configuration
public class EmailController {
	@Autowired
	
	private EmailSenderService emailSenderService;
	
	public EmailController(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	
	@PostMapping("/send-email")
	public  ResponseEntity<String> sendEmail(@RequestBody EmailMessage emailMessage){
		this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(),emailMessage.getMessage());
		return ResponseEntity.ok("Success");
		
	}

	

	
	}
	

