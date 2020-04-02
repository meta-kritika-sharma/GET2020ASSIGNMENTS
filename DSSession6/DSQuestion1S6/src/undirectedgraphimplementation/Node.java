package undirectedgraphimplementation;

/**
 * Class to represent node of a linked list 
 *
 */
public class Node {
	private int vertex;
	private int weight;
	private Node next;
	
	//constructor
	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	
	//getters and setters
	public int getVertex() {
		return vertex;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node node) {
		this.next = node;
	}
}
