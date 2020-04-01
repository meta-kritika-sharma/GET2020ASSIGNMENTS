package employeesorting;

public class EmployeeNode {

	private Employee employee;
	private EmployeeNode next;
	
	//constructor
	public EmployeeNode(Employee employee){
		this.employee = employee;
		this.next = null;
	}

	//getters and setters
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeNode getNext() {
		return next;
	}

	public void setNext(EmployeeNode next) {
		this.next = next;
	}
	
	
}
