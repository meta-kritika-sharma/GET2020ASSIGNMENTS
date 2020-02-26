package com.example.demo.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;
import com.mysql.jdbc.PreparedStatement;
import org.springframework.jdbc.core.PreparedStatementCallback;

@Repository
public class DaoImplementation implements DaoInterface {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public DaoImplementation(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
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
		return jdbcTemplate.query(query, new ResultSetExtractor<Boolean>() {
			@Override
			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				int count = rs.getInt("count(*)");
				if (count == 0) {
					return false;
				}
				return true;
			}
		});
	}

	@Override
	/**
	 * @param login
	 * @return details of employee and vehicle.
	 * @throw Exception
	 */

	public HashMap<Employee, Vehicle> showDetails(Login login) throws SQLException {
		String query = "select * from employeedetails, vehicledetails where Mail='" + login.getMail()
				+ "' and employeedetails.EmployeeId=vehicledetails.EmployeeId";
		return jdbcTemplate.query(query, new ResultSetExtractor<HashMap<Employee, Vehicle>>() {
			@Override
			public HashMap<Employee, Vehicle> extractData(ResultSet result) throws SQLException, DataAccessException {
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
		});
	}

	@Override
	/**
	 * @param employee
	 * @return true if user exists false otherwise
	 * @throws SQLException
	 */

	public Boolean checkUserExists(Employee employee) throws Exception {
		String query = "select count(*) as count from employeedetails where Mail='" + employee.getMail() + "'";
		return jdbcTemplate.query(query, new ResultSetExtractor<Boolean>() {
			@Override
			public Boolean extractData(ResultSet result) throws SQLException, DataAccessException {
				result.next();
				if (result.getInt("count") == 0) {
					return true;
				} else {
					return false;
				}
			}
		});
	}

	@Override
	
	/**
	 * @param employee object
	 * @return true
	 */

	public Boolean addUserDetails(Employee employee) throws SQLException {
		String query = "insert into employeedetails (EmployeeName, Gender,Mail,Password,Organisation,Contact) values (?,?,?,?,?,?)";
 		if( jdbcTemplate.update(query, employee.getFullName(), employee.getGender(),
				employee.getMail(), employee.getPassword(),employee.getOrganisation(),employee.getContactDetails())>0){
					return true;
				}
		return false;
	}

	@Override
	
	/**
	 * @param vehicle object
	 * @param employee object
	 * @param session
	 * @return list of prices 
	 */

	public List<Integer> addVehicleDetails(Vehicle vehicle, Employee employee, HttpSession session)
			throws SQLException {
		Employee employeeDetails = (Employee) session.getAttribute("employeeDetails");
		String query = "select EmployeeId from employeedetails where Mail= '" + employeeDetails.getMail() + "'";
 		return jdbcTemplate.query(query, new ResultSetExtractor<List<Integer>>() {
			@Override
			public List<Integer> extractData(ResultSet resultTable) throws SQLException, DataAccessException {
				resultTable.next();
				session.setAttribute("id", resultTable.getInt(1));
				String insertQuery = "insert into vehicledetails (EmployeeId, VehicleName, VehicleType, VehicleNumber, Description) values(?,?,?,?,?)";
				jdbcTemplate.update(insertQuery,resultTable.getInt(1),vehicle.getVehicleName(),vehicle.getVehicleType(),vehicle.getVehicleNumber(),vehicle.getDescription());
 						String selectquery = "select * from passdetails where VehicleType = '"
								+ vehicle.getVehicleType() + "'";
						return jdbcTemplate.query(selectquery, new ResultSetExtractor<List<Integer>>() {
							@Override
							public List<Integer> extractData(ResultSet resultTable)
									throws SQLException, DataAccessException {
								resultTable.next();
								List<Integer> listOfPrices = new ArrayList<>();
								listOfPrices.add(resultTable.getInt(2));
								listOfPrices.add(resultTable.getInt(3));
								listOfPrices.add(resultTable.getInt(4));
								return listOfPrices;
							}
						});
					}
				});
			}
 
	@Override
	
	/**
	 * @param pass object
	 * @param session
	 * @return true
	 */

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
		jdbcTemplate.update(query);
		return true;
	}

	@Override
	
	/**
	 * @param session
	 * @return list of friends
	 * @throw Exception
	 */

	public ArrayList<Employee> showFriends(HttpSession session) throws SQLException {
		Login login = (Login) session.getAttribute("employee");
		String query = "SELECT * from employeedetails WHERE Mail !='" + login.getMail()
				+ "' and Organisation = (select Organisation from employeedetails where Mail = '" + login.getMail()
				+ "' )";
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<Employee>>() {
			@Override
			public ArrayList<Employee> extractData(ResultSet result) throws SQLException, DataAccessException {
				ArrayList<Employee> list = new ArrayList<>();
				while (result.next()) {
					list.add(new Employee(result.getInt("EmployeeId"), result.getString("EmployeeName"),
							result.getString("Gender"), result.getString("Mail"), result.getString("Organisation"),
							result.getString("Contact")));
				}
				return list;
			}
		});
	}

	@Override
	
	/**
	 * @param session
	 * @param name
	 * @return true
	 * @throw Exception
	 */

	public Boolean addImageName(HttpSession session, String name) throws SQLException {
		Login login = (Login) session.getAttribute("employee");
		String query = "select EmployeeId from employeedetails where Mail= '" + login.getMail() + "'";
		return jdbcTemplate.query(query, new ResultSetExtractor<Boolean>() {
			@Override
			public Boolean extractData(ResultSet result) throws SQLException, DataAccessException {
				result.next();
				String queryupdate = "update employeedetails set imageName='" + name + "' where EmployeeId='"
						+ result.getInt(1) + "'";
				jdbcTemplate.update(queryupdate);
				return true;
			}
		});
	}

	@Override
	
	/**
	 * @param session
	 * @throws Exception
	 * @return name of image
	 */

	public String checkImageExists(HttpSession session) throws SQLException {
		Login login = (Login) session.getAttribute("employee");
		String query = "select imageName from employeedetails where Mail = '" + login.getMail() + "'";
		return jdbcTemplate.query(query, new ResultSetExtractor<String>() {
			@Override
			public String extractData(ResultSet result) throws SQLException, DataAccessException {
				String name;
				result.next();
				name = result.getString("imageName");
				return name;
 			}
		});
	}

}
