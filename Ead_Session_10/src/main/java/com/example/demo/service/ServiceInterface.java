package com.example.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;

public interface ServiceInterface {
	/**
	 * @param login
	 * @return true if user credentials are valid, false otherwise.
	 * @throw Exception
	 */

	public Boolean validateUser(Login login) throws Exception;

	/**
	 * @param employee
	 * @return true if user exists false otherwise
	 * @throws SQLException
	 */

	public Boolean checkUserExists(Employee employee) throws Exception;

	/**
	 * @param employee object
	 * @return true
	 */

	public Boolean addUserDetails(Employee employee) throws SQLException;

	/**
	 * @param vehicle  object
	 * @param employee object
	 * @param session
	 * @return list of prices
	 */

	public List<Integer> addVehicleDetails(Vehicle vehicle, Employee employee, HttpSession session) throws SQLException;

	/**
	 * @param pass    object
	 * @param session
	 * @return true
	 */

	public Boolean getPass(Pass pass, HttpSession session) throws SQLException;

	/**
	 * @param session
	 * @return list of friends
	 * @throw Exception
	 */

	public ArrayList<Employee> showFriends(HttpSession session) throws SQLException;

	/**
	 * @param login
	 * @return details of employee and vehicle.
	 * @throw Exception
	 */

	public HashMap<Employee, Vehicle> showDetails(Login login) throws SQLException;

	/**
	 * @param session
	 * @param name
	 * @return true
	 * @throw Exception
	 */

	Boolean addImageName(HttpSession session, String name) throws SQLException;

	/**
	 * @param session
	 * @throws Exception
	 * @return name of image
	 */

	String checkImageExists(HttpSession session) throws SQLException;
}
