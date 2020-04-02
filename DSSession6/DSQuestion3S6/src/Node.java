public class Node {
	private Employee employee;
	private Node prev;
	private Node next;

	/**
	 * Constructor to initialize employee
	 * @param employee is a non-null Employee
	 * @throws Exception if employee is null
	 */
	public Node(Employee employee) throws Exception {
		if(employee == null) {
			throw new Exception("Employee can't be null");
		}
		this.employee = employee;
	}
	
	/**
	 * Function to get employee
	 * @return employee
	 */
	public Employee getEmployee() {
		return this.employee;
	}
	
	/**
	 * Function to get previous node of the linked list
	 * @return prev
	 */
	public Node getPrev() {
		return this.prev;
	}
	
	/**
	 * Function to set prev node
	 * @param node
	 */
	public void setPrev(Node node) {
		this.prev = node;
	}
	
	/**
	 * Function to get next node of the linked list
	 * @return next
	 */
	public Node getNext() {
		return this.next;
	}
	
	/**
	 * Function to set next node
	 * @param node
	 */
	public void setNext(Node node) {
		this.next = node;
	}
}
