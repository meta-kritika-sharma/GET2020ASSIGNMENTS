package com.example.demo.controller;

import java.sql.SQLException;
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

import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;
import com.example.demo.service.ServiceImplementation;

@Controller
public class VehcileController {

	@Autowired
	private ServiceImplementation service;

	/**
	 * 
	 * @param model
	 * @param session
	 * @param response
	 * @return vehicle registration page
	 */

	@GetMapping("/vehicleRegistration")
	public String VehicleRegistration(Model model, HttpSession session, HttpServletResponse response) {
		model.addAttribute("vehicleRegistration", new Vehicle());
		return "vehicleRegistration";
	}

	/**
	 * 
	 * @param vehicle
	 * @param bindingResult
	 * @param employee
	 * @param session
	 * @param model
	 * @return vehicle registration page if there are errors or pass page if
	 *         successful
	 * @throws SQLException
	 */

	@PostMapping("/vehicleRegistration")
	public String onVehicleRegister(@Validated @ModelAttribute("vehicleRegistration") Vehicle vehicle, BindingResult bindingResult, HttpSession session, Model model) throws SQLException {
		if (bindingResult.hasErrors()) {
			return "vehicleRegistration";
		} else {
			try {
				List<Object[]> listOfPrices = service.addVehicleDetails(vehicle, session);
				for (Object[] object : listOfPrices) {
					model.addAttribute("dailyPrice", object[0].toString());
					model.addAttribute("MonthlyPrice", object[1].toString());
					model.addAttribute("YearlyPrice", object[2].toString());
				}
				model.addAttribute("pass", new Pass());
				return "passDetails";
			} catch (HibernateException exception) {
				return "vehicleRegistration";
			}
		}
	}

}
