package com.example.demo.appcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mail.MailSender;

@RestController
public class MailController {
 
	private MailSender mailSender;
 
	@Autowired     
	public MailController(MailSender sendsmtp) {
		this.mailSender = sendsmtp;
	}
	
	@GetMapping ("/mail")
	public String test () {
		mailSender.sendMail();
		return "Success";
	}
}
