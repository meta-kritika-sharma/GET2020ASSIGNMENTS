package stackimplementation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try{
			Main mainObject = new Main();
			mainObject.userInput();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * function to get user input
	 */
	private void userInput() throws Exception{
		System.out.println("Enter space seperated expression : ");
		Scanner scanner = new Scanner(System.in);
		String expressionInput = scanner.nextLine();
		SolveExpression expression = new SolveExpression(expressionInput.length());
		System.out.println(expression.evaluateExpression(expressionInput));	
	}
}
