package employeesorting;

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
	 * function to get input
	 */
	private void userInput() throws Exception{
		SortingEmployee employeeSort = new SortingEmployee();
		employeeSort.addEmployee(new Employee("A",10,21));
		employeeSort.addEmployee(new Employee("B",5,22));
		employeeSort.addEmployee(new Employee("C",9,23));
		employeeSort.addEmployee(new Employee("D",12,19));
		employeeSort.addEmployee(new Employee("E",11,21));
		employeeSort.showEmployeeList();
		employeeSort.sort();
		System.out.println("After sort");
		employeeSort.showEmployeeList();
	}

}
