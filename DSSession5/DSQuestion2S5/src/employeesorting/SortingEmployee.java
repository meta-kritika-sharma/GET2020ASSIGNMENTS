package employeesorting;

import java.util.ArrayList;
import java.util.List;

 

public class SortingEmployee {

	EmployeeNode head;

	/*
	 * function to add employee to linked list
	 * @param employee object
	 * @throws Exception if employee object is null
	 */
	
	public void addEmployee(Employee employee) throws Exception {

		if (employee == null) {
			throw new Exception("Null object passed");
		}

		EmployeeNode newNode = new EmployeeNode(employee);

		// if linked list is empty
		if (head == null) {
			head = newNode;
		} else {
			EmployeeNode tempNode = head;
			while (tempNode.getNext() != null) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(newNode);
		}
	}

	/**
	 * function to show list of employees
	 * @throws Exception 
	 */
	public void showEmployeeList() throws Exception {
		
		//if linked list is empty
		if (head == null){
			throw new Exception ("List is empty");
		}
		
		EmployeeNode tempNode = head;

		while (tempNode != null) {
			System.out.println(tempNode.getEmployee().getNameOfEmployee());
			tempNode = tempNode.getNext();
		}
	}
	
	/**
	 * function to sort the list based on salary
	 * @throws Exception 
	 */
	public void sort() throws Exception{

		//getting list of all employees
		List<Employee> employees = this.getList();
		this.head = null;
		
		//traversing through the list
		for(Employee employee: employees) {
			EmployeeNode node = new EmployeeNode(employee);
			
			//adding first node
			if(this.head == null) {
				this.head = node;
				continue;
			}
			
			EmployeeNode currentNode = this.head;
			EmployeeNode previousNode = null;
			
			//traversing through linked list
			while(currentNode != null) {
				Employee currentEmployee = currentNode.getEmployee();
				if(employee.getSalary() > currentEmployee.getSalary() || (employee.getSalary() == currentEmployee.getSalary() && employee.getAge() < currentEmployee.getAge())) {
					node.setNext(currentNode);
					if(previousNode == null) {
						this.head = node;
					} else {
						previousNode.setNext(node);
					}
					break;
				}
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
			if(currentNode == null) {
				previousNode.setNext(node);
			}
		}
 }
	

	/**
	 * function to return simple list of linked list
	 * @return list
	 * @throws Exception
	 */
	public List<Employee> getList() throws Exception {

		if (head == null) {
			throw new Exception("Linked list is empty");
		}
		List<Employee> employees = new ArrayList<Employee>();

		// traversing through the linked list
		for (EmployeeNode currentNode = this.head; currentNode != null; currentNode = currentNode
				.getNext()) {
			employees.add(currentNode.getEmployee());
		}
		return employees;
	}
}
