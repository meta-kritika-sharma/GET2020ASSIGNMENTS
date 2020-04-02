package employeecollection;

import java.awt.List;

public class Main {

	public static void main(String[] args) {
		Main mainObject = new Main();
		try {
			mainObject.userInput();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * function to get user input
	 * 
	 * @throws exception
	 */
	private void userInput() throws Exception {
		EmployeeCollection employeeCollection = new EmployeeCollection();
		employeeCollection.addEmployee(new Employee(1, "krits", "xyz street"));
		employeeCollection.addEmployee(new Employee(3, "divya", "xyz street"));
		employeeCollection.addEmployee(new Employee(2, "heena", "xyz street"));

		java.util.List<Employee> sortedOnId = employeeCollection.sortById();
		for (Employee employee : sortedOnId) {
			System.out.println(employee.getEmployeeName());
		}
		java.util.List<Employee> sortedOnName = employeeCollection.sortByName();
		for (Employee employee : sortedOnName) {
			System.out.println(employee.getEmployeeName());
		}
	}
}
