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
import com.example.demo.dao.EmployeeDao;
import com.example.demo.dao.VehicleDao;
import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;

@Service
public class ServiceImplementation implements ServiceInterface {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	VehicleDao vehicleDao;

	/**
	 * @param login
	 * @return details of employee and vehicle.
	 * @throw Exception
	 */

	@Override
	@Transactional
	public Boolean validateUser(Login login) throws HibernateException {
		if (employeeDao.validateUser(login.getMail(), login.getPassword()) == 0) {
			return false;
		}
		return true;
	}

	/**
	 * @param login
	 * @return details of employee and vehicle.
	 * @throw Exception
	 */

	@Override
	@Transactional
	public HashMap<Employee, Vehicle> showDetails(Login login) throws HibernateException {
		HashMap<Employee, Vehicle> details = new HashMap<>();
		List<Object[]> employee = employeeDao.showEmployee(login.getMail());
		Employee key = null;
		for (Object[] object : employee) {
			key = (Employee) object[0];
		}
		List<Object[]> vehicle = vehicleDao.showVehicle(key);
		Vehicle value = null;
		for (Object[] object : vehicle) {
			value = (Vehicle) object[0];
		}
		details.put(key, value);
		return details;
	}

	@Override
	/**
	 * @param employee
	 * @return true if user exists false otherwise
	 * @throws SQLException
	 */
	@Transactional
	public Boolean checkUserExists(Employee employee) throws HibernateException {
		if (employeeDao.checkUserExists(employee.getMail()) == 0) {
			return true;
		}
		return false;
	}

	@Override
	/**
	 * @param employee object
	 * @return true
	 */
	@Transactional
	public Boolean addUserDetails(Employee employee) throws HibernateException {
		if (employeeDao.save(employee) != null) {
			return true;
		}
		return false;
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
		Employee employeeDetails = (Employee) session.getAttribute("employeeDetails");
		session.setAttribute("id", employeeDetails.getId());
		vehicle.setEmployee(employeeDetails);
		vehicleDao.save(vehicle);
		return vehicleDao.addVehicleDetails(vehicle.getVehicleType());
	}

	@Override
	/**
	 * @param pass object
	 * @param session
	 * @return true
	 */
	@Transactional
	public Boolean getPass(Pass pass, HttpSession session) throws HibernateException {
		int passValue = 0;
		if (pass.getPassChoice().equals("Daily")) {
			passValue = pass.getDailypassValue();
		} else if (pass.getPassChoice().equals("Monthly")) {
			passValue = pass.getMonthlypassValue();
		} else if (pass.getPassChoice().equals("Yearly")) {
			passValue = pass.getYearlypassValue();
		}
		Employee employee = (Employee) session.getAttribute("employeeDetails");
		Vehicle vehicle = new Vehicle();
		vehicle.setEmployee(employee);
		if (vehicleDao.getPass(pass.getPassChoice(), passValue, employee) == 0) {
			return false;
		}
		return true;
	}

	@Override
	/**
	 * @param session
	 * @return list of friends
	 * @throw Exception
	 */
	@Transactional
	public ArrayList<Employee> showFriends(HttpSession session) throws HibernateException {
		Login login = (Login) session.getAttribute("employee");
		List<Object[]> listOfFriends = employeeDao.showFriends(login.getMail(), login.getMail());
		ArrayList<Employee> friendsList = new ArrayList<>();
		for (Object[] object : listOfFriends) {
			friendsList.add(new Employee((int) object[0], object[1].toString(), object[2].toString(), object[3].toString(), object[5].toString(), object[6].toString()));
		}
		return friendsList;
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
		Login login = (Login) session.getAttribute("employee");
		if (employeeDao.addImageName(login.getMail(), name) == 0) {
			return false;
		}
		return true;

	}

	@Override
	/**
	 * @param session
	 * @throws Exception
	 * @return name of image
	 */
	@Transactional
	public String checkImageExists(HttpSession session) throws HibernateException {
		Login login = (Login) session.getAttribute("employee");
		return employeeDao.checkImageExists(login.getMail());
	}

}
