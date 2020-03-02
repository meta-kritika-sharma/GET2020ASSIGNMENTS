package com.example.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;
import com.example.demo.service.ServiceImplementation;

//Controller class
@Controller
public class EmployeeController {

	@Autowired
	private ServiceImplementation service;
	/*
	 * @param login
	 * 
	 * @param model
	 * 
	 * @param session
	 * 
	 * @param response
	 * 
	 * @return home if session is valid, else return home.
	 * 
	 * @throw Exception
	 */

	@GetMapping("/home")
	public String home(Login login, Model model, HttpSession session, HttpServletResponse response){
		if (isSessionValid(session, response)) {
			login = (Login) session.getAttribute("employee");
			try {
				HashMap<Employee, Vehicle> list = service.showDetails(login);
				for (Employee iterator : list.keySet()) {
					model.addAttribute("employee", iterator);
					model.addAttribute("vehicle", list.get(iterator));
				}
				return "home";
			} catch (HibernateException exception) {
				return "redirect:/login";
			}
		} else {
			return "redirect:/login";
		}
	}

	/*
	 * Method to return register
	 * 
	 * @param model
	 * 
	 * @return register page
	 */

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("employee", new Employee());
		return "register";
	}

	/*
	 * @param employee
	 * 
	 * @param bindingresult
	 * 
	 * @param session
	 * 
	 * @return register if errors exist in field
	 */

	@PostMapping("/register")
	public String onRegister(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult, HttpSession session, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				return "register";
			} else {
				if (service.checkUserExists(employee)) {
					service.addUserDetails(employee);
					session.setAttribute("employeeDetails", employee);
					return "redirect:/vehicleRegistration";
				} else {
					model.addAttribute("msg", "User already Exists");
					return "redirect:/login";
				}
			}
		} catch (HibernateException e) {
			return "redirect:/login";
		}
	}

	/**
	 * 
	 * @param pass
	 * @param bindingResult
	 * @param session
	 * @return show pass page
	 * @throws SQLException
	 */

	@PostMapping("/passDetails")
	public String onGetPass(@Validated @ModelAttribute("pass") Pass pass, BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "passDetaiils";
		}
		try {
			service.getPass(pass, session);
			return "showPass";
		} catch (HibernateException e) {
			return "passDetails";
		}
	}

	/**
	 * 
	 * @param session
	 * @param model
	 * @param response
	 * @return friend page if session is valid, login otherwise
	 * @throws SQLException
	 */

	@GetMapping("/friends")
	public String friends(HttpSession session, Model model, HttpServletResponse response){
		if (isSessionValid(session, response)) {
			try {
				ArrayList<Employee> list = service.showFriends(session);
				model.addAttribute("friendlist", list);
				return "friend";
			} catch (HibernateException exception) {
				return "redirect:/login";
			}
		}
		return "redirect:/login";
	}

	/**
	 * 
	 * @param model
	 * @param session
	 * @param response
	 * @return upload image if session is invalid login otherwise
	 */

	@GetMapping("/upload")

	public String upload(Model model, HttpSession session, HttpServletResponse response) {
		if (isSessionValid(session, response)) {
			return "uploadImage";
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * 
	 * @param file
	 * @param redirectAttributes
	 * @param image
	 * @param session
	 * @param model
	 * @return upload image if there is an error and home page if successful
	 */

	@PostMapping(value = "/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, HttpSession session, Model model) {
		Path path = null;
		if (file.isEmpty()) {
			return "uploadImage";
		}
		try {
			String UPLOADED_FOLDER = Paths.get("").toAbsolutePath().toString()
					+ "\\src\\main\\resources\\static\\images";
			byte[] bytes = file.getBytes();
			path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			String name = "images" + file.getOriginalFilename();
			service.addImageName(session, name);
			session.setAttribute("name", name);
			return "redirect:/home";
		} catch (IOException e) {
			return "uploadImage";
		}
	}

	/**
	 * 
	 * @param session
	 * @return login page
	 */

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	/**
	 * 
	 * @param session
	 * @param response
	 * @return true if session is valid
	 */

	public static boolean isSessionValid(HttpSession session, HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("employee") == null) {
			return false;
		}
		return true;
	}
}
