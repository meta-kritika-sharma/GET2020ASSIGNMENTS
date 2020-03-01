package com.example.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DaoImplementation;
import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;

@Service
public class ServiceImplementation implements ServiceInterface {

	@Autowired
	DaoImplementation dao;

	/**
	 * @param login
	 * @return details of employee and vehicle.
	 * @throw Exception
	 */

	@Override
	@Transactional
	public Boolean validateUser(Login login) throws HibernateException {
		return dao.validateUser(login);

	}

	/**
	 * @param login
	 * @return details of employee and vehicle.
	 * @throw Exception
	 */

	@Override
	@Transactional
	public HashMap<Employee, Vehicle> showDetails(Login login) throws HibernateException {
		return dao.showDetails(login);
	}

	@Override
	/**
	 * @param employee
	 * @return true if user exists false otherwise
	 * @throws SQLException
	 */
	@Transactional
	public Boolean checkUserExists(Employee employee) throws HibernateException {

		return dao.checkUserExists(employee);
	}

	@Override
	/**
	 * @param employee object
	 * @return true
	 */
	@Transactional
	public Boolean addUserDetails(Employee employee) throws HibernateException {
		return dao.addUserDetails(employee);
	}

	@Override

	/**
	 * @param vehicle  object
	 * @param employee object
	 * @param session
	 * @return list of prices
	 */
	@Transactional
	public List<Object[]> addVehicleDetails(Vehicle vehicle, HttpSession session) throws HibernateException {

		return dao.addVehicleDetails(vehicle, session);
	}

	@Override
	/**
	 * @param pass    object
	 * @param session
	 * @return true
	 */
	@Transactional
	public Boolean getPass(Pass pass, HttpSession session) throws HibernateException {
		return dao.getPass(pass, session);
	}

	@Override
	/**
	 * @param session
	 * @return list of friends
	 * @throw Exception
	 */
	@Transactional
	public ArrayList<Employee> showFriends(HttpSession session) throws HibernateException {
		return dao.showFriends(session);
	}

	@Override
	/**
	 * @param session
	 * @param name
	 * @return true
	 * @throw Exception
	 */
	@Transactional
	public Boolean addImageName(HttpSession session, String name) throws HibernateException {
		return dao.addImageName(session, name);

	}

	@Override
	/**
	 * @param session
	 * @throws Exception
	 * @return name of image
	 */
	@Transactional
	public String checkImageExists(HttpSession session) throws HibernateException {

		return dao.checkImageExists(session);
	}

}
