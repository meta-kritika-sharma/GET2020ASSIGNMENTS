/*
 * @author - Kritika Sharma
 * @date - 23-03-2020
 */
package linkedlistimplemntation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		LinkedList linkedList = new LinkedList();
		Main object = new Main();
		try{
			object.userInput(linkedList);
		}
		catch (InputMismatchException exception){
			System.out.println("Invalid Input");
		}
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}
	}
	
	/*
	 * Function to get user input
	 * @throws InputMismatchException if data type of input is different than expected.
	 * @throws Exception
	 */
	private void userInput(LinkedList linkedList) throws InputMismatchException, Exception{
		
		System.out.println("Enter number of nodes to be entered :");
		Scanner scanner = new Scanner(System.in);
		int sizeOfList = scanner.nextInt();
		
		if (sizeOfList<=0){
			throw new Exception ("Enter valid size");
		}
		
		//to get the values of nodes
		for (int iterator=0; iterator<sizeOfList;iterator++){
			System.out.println("Enter value of node");
			int valueOfNode = scanner.nextInt();
			linkedList.insertNode(valueOfNode);
		}
	
		
		//getting starting index of sublist
		System.out.println("Enter start position (left) :");
		int leftPointer = scanner.nextInt();

		//getting ending index of sublist
		System.out.println("Enter end position (right) :");
		int rightPointer = scanner.nextInt();
		
		System.out.println("Enter number of times to be rotated");
		int numberOftimes = scanner.nextInt();
		
		linkedList.rotateSubList(leftPointer, rightPointer, numberOftimes);
	}
}
