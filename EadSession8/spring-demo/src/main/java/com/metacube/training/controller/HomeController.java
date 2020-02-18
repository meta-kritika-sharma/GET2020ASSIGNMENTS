package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.training.model.commands.Student;
import com.metacube.training.service.StudentService;

@Controller
public class HomeController {

	// fetching message from application.yml
	@Value("${home.message}")
	private String message;

	/*
	 * Method to add message defined in application.yml to the home page.
	 * @param model object
	 * @return home
	 */

	@GetMapping({ "/home" })
	public String home(Model model) {
		model.addAttribute("message", message);
		return "home";
	}

	/*
	 * Method to return page that shows options to add students.
	 * @param model
	 * @return addStudent page
	 */
	
	@GetMapping("/student")
	public String addStudentController(Model model) {
		model.addAttribute("student", new Student());
		return "addstudent";
	}

}
