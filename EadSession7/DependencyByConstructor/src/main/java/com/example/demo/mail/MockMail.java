package com.example.demo.mail;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MockMail implements MailSender{

	@Override
	public void sendMail() {
		System.out.println("mock sent");
	}

}
