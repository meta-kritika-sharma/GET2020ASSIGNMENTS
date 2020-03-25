/*
 * @author - Kritika Sharma
 * @date - 23-03-2020
 */

package linkedlistimplemntation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		LinkedList linkedList = new LinkedList();
		Main object = new Main();
		object.inputData(linkedList);
		if (linkedList.loopDetection(linkedList)){
			System.out.println("Loop exists");
		}
		else{
			System.out.println("Loop not found");
		}		
	}
	
	/*
	 * function to add input for creation of linked list
	 * @param linkedList is the object of class LinkedList
	 */
	private void inputData(LinkedList linkedList){
		Node node = new Node(1);	
		linkedList.insertNode(new Node(2));
		linkedList.insertNode(node);
		linkedList.insertNode(new Node(3));
		linkedList.insertNode(new Node(4));
		linkedList.insertNode(new Node(5));
		linkedList.insertNode(node);
	}
}
