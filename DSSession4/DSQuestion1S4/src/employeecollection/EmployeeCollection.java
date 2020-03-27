package employeecollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//employee collection class
public class EmployeeCollection {

	// list of employee objects
	private List<Employee> employeeList;

	// constructor
	public EmployeeCollection() {
		employeeList = new ArrayList<>();
	}

	/*
	 * function to add employee to list
	 * @param employee is the employee object
	 * @throws Exception if employee object is null
	 */

	public void addEmployee(Employee employee) throws Exception {
		if (employee == null) {
			throw new Exception("Null object can't be added.");
		}

		// function to check for uniqueness of employee id
		if (isUnique(employee.getId())) {
			employeeList.add(employee);
		} else {
			throw new Exception("ID is not unique");
		}
	}

	/*
	 * function to check whether employee id is unique
	 * @id is the employee id
	 * @return true if id is unique, false otherwise
	 */
	
	private Boolean isUnique(int id) {
		for (Employee iterator : employeeList) {
			if (iterator.getId() == id) {
				return false;
			}
		}
		return true;
	}

	/*
	 * function to sort employees based on id
	 * @return sorted list of employees
	 */
	public List<Employee> sortById() {
		List<Employee> sortedList = employeeList;
		Collections.sort(sortedList);
		return employeeList;
	}

	/*
	 * function to sort employees based on name
	 * @return sorted list of employees
	 */
	public List<Employee> sortByName() {
		List<Employee> sortedList1 = this.employeeList;
		Collections.sort(sortedList1, new SortByName());
		return sortedList1;
	}

}
