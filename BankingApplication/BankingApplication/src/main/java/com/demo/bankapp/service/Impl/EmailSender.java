package com.demo.bankapp.service.Impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.demo.bankapp.service.EmailSenderService;
@Component
public class EmailSender implements EmailSenderService{
	
	private final  JavaMailSender mailSender;
	public EmailSender(JavaMailSender mailSender) {
		this.mailSender=mailSender;
	}


	@Override
	public void sendEmail(String to, String subject, String message) {
		
		
	
	SimpleMailMessage mailMessage=new SimpleMailMessage();
	mailMessage.setFrom("anbankingservice@gmail.com");
	mailMessage.setTo(to);
	mailMessage.setSubject(subject);
	mailMessage.setText("Greetings from AN Bank");
	
	this.mailSender.send(mailMessage);

}
}

