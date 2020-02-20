package com.example.demo.appcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mail.MailSender;

@RestController
public class MailController {

	//injection by name.
	@Autowired
	
	//uncomment below line if @primary annotation is not used.
	//@Qualifier("mock")
	private MailSender mailSender;

	/* Method to call the sendMail() function
	 * @return string "success".
	 */
 	@GetMapping ("/mailbyname")
	public String test () {
		mailSender.sendMail();
		return "Success";
	}
}
