package com.example.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DaoImplementation;
import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;

@Service
public class ServiceImplementation implements ServiceInterface{

	@Autowired
	DaoImplementation dao;

	/**
	 * @param login
	 * @return details of employee and vehicle.
	 * @throw Exception
	 */

	@Override
	public Boolean validateUser(Login login) throws Exception {
		return dao.validateUser(login);

	}

	/**
	 * @param login
	 * @return details of employee and vehicle.
	 * @throw Exception
	 */

	@Override
	public HashMap<Employee, Vehicle> showDetails(Login login) throws SQLException {
		return dao.showDetails(login);
	}

	@Override
	/**
	 * @param employee
	 * @return true if user exists false otherwise
	 * @throws SQLException
	 */

	public Boolean checkUserExists(Employee employee) throws Exception {

		return dao.checkUserExists(employee);
	}

	@Override
	/**
	 * @param employee object
	 * @return true
	 */

	public Boolean addUserDetails(Employee employee) throws SQLException {
		return dao.addUserDetails(employee);
	}

	@Override

	/**
	 * @param vehicle  object
	 * @param employee object
	 * @param session
	 * @return list of prices
	 */

	public List<Integer> addVehicleDetails(Vehicle vehicle, Employee employee, HttpSession session)
			throws SQLException {

		return dao.addVehicleDetails(vehicle, employee, session);
	}

	@Override
	/**
	 * @param pass    object
	 * @param session
	 * @return true
	 */

	public Boolean getPass(Pass pass, HttpSession session) throws SQLException {
		return dao.getPass(pass, session);
	}

	@Override
	/**
	 * @param session
	 * @return list of friends
	 * @throw Exception
	 */

	public ArrayList<Employee> showFriends(HttpSession session) throws SQLException {
		return dao.showFriends(session);
	}

	@Override
	/**
	 * @param session
	 * @param name
	 * @return true
	 * @throw Exception
	 */

	public Boolean addImageName(HttpSession session, String name) throws SQLException {
		return dao.addImageName(session, name);

	}

	@Override
	/**
	 * @param session
	 * @throws Exception
	 * @return name of image
	 */

	public String checkImageExists(HttpSession session) throws SQLException {

		return dao.checkImageExists(session);
	}

}
