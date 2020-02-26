package com.example.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;
import com.mysql.jdbc.PreparedStatement;

@Repository
public class DaoImplementation implements DaoInterface {

	Connection connection = null;

	public DaoImplementation() {
		connection = DatabaseConnection.createConnection();
	}

	@Override
	/**
	 * @param login
	 * @return true if user credentials are valid, false otherwise.
	 * @throw Exception
	 */
	public Boolean validateUser(Login login) throws Exception {
		String query = "select count(*) from employeedetails where Mail='" + login.getMail() + "' and Password='"
				+ login.getPassword() + "'";
		ResultSet outputTable = executeSelectQuery(query);
		outputTable.next();
		int count = outputTable.getInt("count(*)");
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

	public HashMap<Employee, Vehicle> showDetails(Login login) throws SQLException {
		String query = "select * from employeedetails, vehicledetails where Mail='" + login.getMail()
				+ "' and employeedetails.EmployeeId=vehicledetails.EmployeeId";
		ResultSet result = executeSelectQuery(query);
		HashMap<Employee, Vehicle> details = new HashMap<>();
		while (result.next()) {
			Employee key = new Employee(result.getInt("EmployeeId"), result.getString("EmployeeName"),
					result.getString("Gender"), result.getString("Mail"), result.getString("Organisation"),
					result.getString("Contact"));
			Vehicle value = new Vehicle(result.getString("VehicleName"), result.getString("VehicleType"),
					result.getString("VehicleNumber"), result.getString("Plan"), result.getInt("Price"),
					result.getString("Description"));
			details.put(key, value);
		}
		return details;
	}

	/**
	 * @param employee
	 * @return true if user exists false otherwise
	 * @throws SQLException
	 */

	@Override
	public Boolean checkUserExists(Employee employee) throws Exception {
		String query = "select count(*) as count from employeedetails where Mail='" + employee.getMail() + "'";
		ResultSet resultTable = executeSelectQuery(query);
		resultTable.next();
		if (resultTable.getInt("count") == 0) {
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
	public Boolean addUserDetails(Employee employee) throws SQLException {
		String query = "insert into employeedetails (EmployeeName, Gender,Mail,Password,Organisation,Contact) values('"+employee.getFullName()+"','"+employee.getGender()+"','"+employee.getMail()+"','"+employee.getPassword()+"','"+employee.getOrganisation()+"','"+employee.getContactDetails()+"')";
		executeSelectUpdateQuery(query);
		return true;
	}

	/**
	 * @param vehicle  object
	 * @param employee object
	 * @param session
	 * @return list of prices
	 */

	@Override
	public List<Integer> addVehicleDetails(Vehicle vehicle, Employee employee, HttpSession session)
			throws SQLException {
		Employee employeeDetails = (Employee) session.getAttribute("employeeDetails");
		String query = "select EmployeeId from employeedetails where Mail= '" + employeeDetails.getMail() + "'";
		ResultSet resultTable = executeSelectQuery(query);
		resultTable.next();
		session.setAttribute("id", resultTable.getInt(1));
		query = "insert into vehicledetails (EmployeeId, VehicleName, VehicleType, VehicleNumber, Description) values('"
				+ resultTable.getInt(1) + "','" + vehicle.getVehicleName() + "','" + vehicle.getVehicleType() + "','"
				+ vehicle.getVehicleNumber() + "','" + vehicle.getDescription() + "')";
		executeSelectUpdateQuery(query);
		query = "select * from passdetails where VehicleType = '" + vehicle.getVehicleType() + "'";
		resultTable = executeSelectQuery(query);
		resultTable.next();
		List<Integer> listOfPrices = new ArrayList<>();
		listOfPrices.add(resultTable.getInt(2));
		listOfPrices.add(resultTable.getInt(3));
		listOfPrices.add(resultTable.getInt(4));
		return listOfPrices;
	}

	/**
	 * @param pass    object
	 * @param session
	 * @return true
	 */

	@Override
	public Boolean getPass(Pass pass, HttpSession session) throws SQLException {

		String query;
		int passValue = 0;
		if (pass.getPassChoice().equals("Daily")) {
			passValue = pass.getDailypassValue();
		} else if (pass.getPassChoice().equals("Daily")) {
			passValue = pass.getMonthlypassValue();
		} else if (pass.getPassChoice().equals("Daily")) {
			passValue = pass.getYearlypassValue();
		}
		query = "update vehicledetails set Plan='" + pass.getPassChoice() + "' ,Price = " + passValue
				+ " where EmployeeId = " + session.getAttribute("id");
		executeSelectUpdateQuery(query);
		return true;
	}

	/**
	 * @param session
	 * @return list of friends
	 * @throw Exception
	 */

	@Override
	public ArrayList<Employee> showFriends(HttpSession session) throws SQLException {

		connection = DatabaseConnection.createConnection();
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(
				"SELECT * from employeedetails WHERE Mail != ? and Organisation = (select Organisation from employeedetails where Mail = ?)");
		Login login = (Login) session.getAttribute("employee");
		statement.setString(1, login.getMail());
		statement.setString(2, login.getMail());
		ResultSet result = statement.executeQuery();
		ArrayList<Employee> list = new ArrayList<>();
		while (result.next()) {
			list.add(new Employee(result.getInt("EmployeeId"), result.getString("EmployeeName"),
					result.getString("Gender"), result.getString("Mail"), result.getString("Organisation"),
					result.getString("Contact")));
		}
		return list;
	}

	/**
	 * @param session
	 * @param name
	 * @return true
	 * @throw Exception
	 */

	@Override
	public Boolean addImageName(HttpSession session, String name) throws SQLException {
		Login login = (Login) session.getAttribute("employee");
		String query = "select EmployeeId from employeedetails where Mail= '" + login.getMail() + "'";
		ResultSet result = executeSelectQuery(query);
		result.next();
		query = "update employeedetails set imageName='" + name + "' where EmployeeId='" + result.getInt(1) + "'";
		executeSelectUpdateQuery(query);
		return true;
	}

	/**
	 * @param session
	 * @throws Exception
	 * @return name of image
	 */

	@Override
	public String checkImageExists(HttpSession session) throws SQLException {
		String name;
		Login login = (Login) session.getAttribute("employee");
		String query = "select imageName from employeedetails where Mail = '" + login.getMail() + "'";
		ResultSet result = executeSelectQuery(query);
		result.next();
		name = result.getString("imageName");
		return name;
	}

	// helper function
	private ResultSet executeSelectQuery(String query) throws SQLException {
		Statement statement = (Statement) connection.createStatement();
		ResultSet outputTable = statement.executeQuery(query);
		return outputTable;
	}

	// helper function
	private void executeSelectUpdateQuery(String query) throws SQLException {
		Statement statement = (Statement) connection.createStatement();
		statement.executeUpdate(query);
	}

}
