package com.example.demo.applicationconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.mail.MailSender;
import com.example.demo.mail.MockMail;
import com.example.demo.mail.SmtpMail;

@Configuration
public class AppConfig {

	@Bean("sendsmtp")
	public MailSender smtp() {
		return new SmtpMail();
	}

	@Bean("sendmock")
	public MailSender mock() {
		return new MockMail();
	}

}
