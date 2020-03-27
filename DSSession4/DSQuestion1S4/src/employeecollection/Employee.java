package employeecollection;

import java.util.Comparator;

//employee class
public class Employee implements Comparable<Employee> {

	private int id;
	private String employeeName;
	private String employeeAddress;

	// constructor
	public Employee(int id, String employeeName, String employeeAddress)
			throws Exception {

		if (id < 0) {
			throw new Exception("Invalid employee id");
		}

		if (employeeName.trim().length() == 0) {
			throw new Exception("Invalid employee name");
		}

		if (employeeAddress.trim().length() == 0) {
			throw new Exception("Invalid employee address");
		}

		this.id = id;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	/**
	 * Comparing the objects based on employee id
	 * @return 0 if both ids are equal, 1 if passed id is less and -1 if passed id is greater.
	 */

	@Override
	public int compareTo(Employee employee) {

		if (this.id < employee.id) {
			return -1;
		} else if (this.id > employee.id) {
			return 1;
		} else {
			return 0;
		}
	}

}
