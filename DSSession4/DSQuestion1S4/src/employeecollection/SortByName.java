package employeecollection;

import java.util.Comparator;

//function to sort objects by name
public class SortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		return employee1.getEmployeeName().compareTo(employee2.getEmployeeName());
	}

}
