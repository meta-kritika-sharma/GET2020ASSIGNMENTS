package com.metacube.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.commands.Student;
import com.metacube.training.service.StudentService;
import com.metacube.training.service.impl.StudentServiceImpl;

@Controller
public class StudentController {

	@Autowired	
	private StudentServiceImpl studentService;
	
	/*
	 * @param student
	 * @param errors
	 * @return addstudent if errors exist, else redirect to home.
	 */
	
	@PostMapping("/addStudent")
	public String addStudent(@Valid @ModelAttribute("student") Student student, Errors errors) {
		if (errors.hasErrors()) {
			return "addstudent";
		}
		studentService.addStudent(student);
		return "redirect:home";
	}
	
	/*
	 * @return ModelAndView object
	 */
	
	@GetMapping("/showStudents")
	public ModelAndView showStudents() {
		ModelAndView modelAndView = new ModelAndView();
		List<Student> studentsList = studentService.showStudents();
		modelAndView.setViewName("showstudents");
		modelAndView.addObject("students", studentsList);
		return modelAndView;
	}
	
 
}
