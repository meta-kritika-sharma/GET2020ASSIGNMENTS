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

	//constructor injection
	@Autowired     
	public MailController(MailSender mail) {
		this.mailSender = mail;
	}

	/* Method to call the sendMail() function
	 * @return string "success".
	 */
 	@GetMapping ("/mailbyconstructor")
	public String test () {
		mailSender.sendMail();
		return "Success";
	}
}
