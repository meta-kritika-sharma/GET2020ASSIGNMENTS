package com.example.demo.mail;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

//uncomment below line if @primary is not used.
//@Qualifier("mock")

public class MockMail implements MailSender{

	@Override
	public void sendMail() {
		System.out.println("mock sent");
	}

}
