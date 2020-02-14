package com.example.demo.mail;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class SmtpMail implements MailSender {

	@Override
	public void sendMail() {
		System.out.println("Smtp sent");
	}

	
}
