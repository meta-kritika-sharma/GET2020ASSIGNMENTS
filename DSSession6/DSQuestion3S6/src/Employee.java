public class Employee {
	private static int noOfEmployees = 0;
	private int empId;
	private String name;
	private int age;
	private int salary;

	/**
	 * Constructor to initialize all attributes
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Employee(String name, int age, int salary) {
		this.empId = noOfEmployees++;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/**
	 * Function to get empId
	 * @return empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * Function to get name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Function to get age
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Function to get salary
	 * @return salary
	 */
	public int getSalary() {
		return salary;
	}
}