package com.example.demo.mail;

import org.springframework.stereotype.Component;

@Component

//uncomment below line if @primary is not used.
//@Qualifier("smtp")

public class SmtpMail implements MailSender {

	@Override
	public void sendMail() {
		System.out.println("Smtp sent");
	}

	
}
