package linkedlistimplemntation;

public class LinkedList {
	
	//head pointing to first node of list
	private Node head;

	/*
	 * Function to insert node in list
	 * @param data is the value of the node to be added.
	 */
	public void insertNode(Node newNode){	
		if (head == null){
			head = newNode;
		}
		else{
			Node tempNode = head;
			while (tempNode.getNext()!=null){
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(newNode);
		}
	}
	
	/*
	 * Function to display the list
	 * @throw Exception if list is empty
	 */
	public void showNodes() throws Exception{
		Node tempNode = head;
		if (head==null){
			throw new Exception("List is empty");
		}
		
		//traversing through list
		while (tempNode!=null){
			System.out.println(tempNode.getData());
			tempNode = tempNode.getNext();
		}
	}

	public Boolean loopDetection(LinkedList linkedList){
		
		//pointer pointing to next node of current node
		Node firstPointer = head;
		
		//pointer pointing to the next to next node of current node
		Node secondPointer = head;
		
		while ((firstPointer!=null) && (secondPointer!=null) && (secondPointer.getNext()!=null)){
			firstPointer = firstPointer.getNext();
			secondPointer = secondPointer.getNext().getNext();
			
			//loop exists
			if (firstPointer == secondPointer){
				return true;
			}
		}
		return false;
	}
}
