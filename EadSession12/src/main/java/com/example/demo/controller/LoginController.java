package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Login;
import com.example.demo.service.ServiceImplementation;

@Controller
public class LoginController {

	@Autowired
	private ServiceImplementation service;

	/*
	 * Method to return login page
	 * 
	 * @param model
	 * 
	 * @return login page
	 */

	@GetMapping({ "/", "/login" })
	public String login(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}

	/*
	 * @param login
	 * 
	 * @param bindingresult
	 * 
	 * @return login page
	 * 
	 */

	@PostMapping("/login")
	public String onLogin(@Validated @ModelAttribute("login") Login login, BindingResult bindingResult, HttpSession session, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("msg", "Login Unsuccessful");
			return "login";
		} else {
			try {
				if (service.validateUser(login)) {
					session.setAttribute("employee", login);

					if (service.checkImageExists(session) == null) {
						session.setAttribute("name", "snap.PNG");
					} else {
						String name = service.checkImageExists(session);
						session.setAttribute("name", name);
					}

					return "redirect:/home";
				} else {
					model.addAttribute("msg", "Login Unsuccessful");
					return "login";
				}
			} catch (HibernateException e) {
				model.addAttribute("msg", "Login Unsuccessful");
				return "login";
			}
		}
	}

}
