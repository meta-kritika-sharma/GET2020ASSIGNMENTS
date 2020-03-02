package com.example.demo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;

@Repository
public class DaoImplementation implements DaoInterface {
	
	@Autowired
	private EntityManager entityManager;
	
	private final String validateUserQuery = "select count(*) from Employee where mail=:mail and password=:password";
	private final String selectUserByMail = "from Employee where mail=:mail";
	private final String selectVehicle = "from Vehicle where employee=:employee";	
	private final String updateVehicle = "update Vehicle set plan=:plan, price=:price where employee =:employee";
	private final String selectFriends = "from Employee WHERE mail !=: mail and organisation = (select organisation from Employee where mail =: mailId)";
	private final String selectIdByMail = "select id from Employee where mail=:mail";
	private final String selectImageName = "select imageName from Employee where mail=:mail";
	private final String updateEmployee= "update Employee set imageName=:name where id=:employeeId";
	
	@Override
	/**
	 * @param login
	 * @return true if user credentials are valid, false otherwise.
	 * @throw Exception
	 */
	public Boolean validateUser(Login login) throws HibernateException{
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Long>query = currentSession.createQuery(validateUserQuery);
		query.setParameter("mail", login.getMail());
		query.setParameter("password", login.getPassword());
		Long count = (Long) query.uniqueResult();
		if (count == 0) {
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
	public HashMap<Employee, Vehicle> showDetails(Login login) throws HibernateException{
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery(selectUserByMail);
		query.setParameter("mail", login.getMail());
		List<Employee> employee = query.getResultList();
		Query<Vehicle> vehicleQuery = currentSession.createQuery(selectVehicle);
		vehicleQuery.setParameter("employee", employee.get(0));
		List<Vehicle> vehicle = vehicleQuery.getResultList();
		HashMap<Employee, Vehicle> details = new HashMap<>();
		Employee employeeObject = employee.get(0);
		Vehicle vehicleObject = vehicle.get(0);
		Employee key = new Employee(employeeObject.getId(), employeeObject.getFullName(), employeeObject.getGender(), employeeObject.getMail(), employeeObject.getOrganisation(), employeeObject.getContactDetails());
		Vehicle value = new Vehicle(vehicleObject.getVehicleName(), vehicleObject.getVehicleType(), vehicleObject.getVehicleNumber(), vehicleObject.getPlan(), vehicleObject.getPrice(),vehicleObject.getDescription());
		details.put(key, value);
		return details;
	}

	/**
	 * @param employee
	 * @return true if user exists false otherwise
	 * @throws SQLException
	 */

	@Override
	public Boolean checkUserExists(Employee employee) throws HibernateException{
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Long> query = currentSession.createQuery(validateUserQuery);
		query.setParameter("mail", employee.getMail());
		query.setParameter("password", employee.getPassword());
		Long count = (Long) query.uniqueResult();
 		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param employee object
	 * @return true
	 */

	@Override
	public Boolean addUserDetails(Employee employee) throws HibernateException{
		Session currentSession = entityManager.unwrap(Session.class);
		if (currentSession.save(employee)!=null){
			return true;
		}
		return false;
	}

	/**
	 * @param vehicle  object
	 * @param session
	 * @return list of prices
	 */

	@Override
	public List<Object[]> addVehicleDetails(Vehicle vehicle, HttpSession session) throws HibernateException{
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeDetails = (Employee) session.getAttribute("employeeDetails");
		session.setAttribute("id", employeeDetails.getId());
		vehicle.setEmployee(employeeDetails);
		currentSession.save(vehicle);
		SQLQuery query = currentSession.createSQLQuery("select DailyPrice,MonthlyPrice,YearlyPrice from passdetails where VehicleType = '" + vehicle.getVehicleType() + "'");
		List<Object[]> listOfPrices = query.list();
		return listOfPrices;
	}

	/**
	 * @param pass    object
	 * @param session
	 * @return true
	 */

	@Override
	public Boolean getPass(Pass pass, HttpSession session) throws HibernateException{
		Session currentSession = entityManager.unwrap(Session.class);
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
		Query<Vehicle> query = currentSession.createQuery(updateVehicle);
		query.setParameter("plan", pass.getPassChoice());
		query.setParameter("price", passValue);
		query.setParameter("employee", employee);
		if (query.executeUpdate()==0) {
			return false;
		}
		return true;
	}

	/**
	 * @param session
	 * @return list of friends
	 * @throw Exception
	 */

	@Override
	public ArrayList<Employee> showFriends(HttpSession session) throws HibernateException{
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery(selectFriends);
		Login login = (Login) session.getAttribute("employee");
		query.setParameter("mail", login.getMail());
		query.setParameter("mailId", login.getMail());
		ArrayList<Employee> listOfFriends= (ArrayList<Employee>) query.getResultList(); 
		return listOfFriends;
	}

	/**
	 * @param session
	 * @param name
	 * @return true
	 * @throw Exception
	 */

	@Override
	public Boolean addImageName(HttpSession session, String name) throws HibernateException{
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery(selectIdByMail);
		Login login = (Login) session.getAttribute("employee");
		query.setParameter("mail", login.getMail());
		int employeeId = (int) query.uniqueResult();
		query = currentSession.createQuery(updateEmployee);
		query.setParameter("employeeId", employeeId);
		query.setParameter("name", name);
		query.executeUpdate();
		return true;
	}

	/**
	 * @param session
	 * @throws Exception
	 * @return name of image
	 */

	@Override
	public String checkImageExists(HttpSession session) throws HibernateException{
		Session currentSession = entityManager.unwrap(Session.class);
		Login login = (Login) session.getAttribute("employee");
		Query query = currentSession.createQuery(selectImageName);
		query.setParameter("mail", login.getMail());
		String name = (String) query.uniqueResult();
		return name;
	}
}
