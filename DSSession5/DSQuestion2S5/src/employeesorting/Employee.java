package employeesorting;

public class Employee {

	private String nameOfEmployee;
	private float salary;
	private int age;	

	//constructor
	public Employee(String nameOfEmployee, float salary, int age){
		this.nameOfEmployee = nameOfEmployee;
		this.salary = salary;
		this.age = age;
	}
	
	//getters and setters
	public String getNameOfEmployee() {
		return nameOfEmployee;
	}

	public void setNameOfEmployee(String nameOfEmployee) {
		this.nameOfEmployee = nameOfEmployee;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
