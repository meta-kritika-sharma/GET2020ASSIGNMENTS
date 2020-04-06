package dictionaryimplementation;

public class Node {

	//key-value pair
	private Element element;
	//left child
	private Node leftNode;
	//right child
	private Node rightNode;

	//constructor
	public Node(Element element){
		this.element = element;
		this.leftNode = null;
		this.rightNode = null;
	}
	
	//getters and setters
	public Element getElement() {
		return element;
	}
	public void setElement(Element element) {
		this.element = element;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
}
