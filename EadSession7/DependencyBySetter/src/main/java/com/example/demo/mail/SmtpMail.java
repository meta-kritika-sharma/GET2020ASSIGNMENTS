package com.example.demo.mail;

import org.springframework.stereotype.Component;

@Component
public class SmtpMail implements MailSender {

	@Override
	public void sendMail() {
		System.out.println("Smtp sent");
	}

	
}
