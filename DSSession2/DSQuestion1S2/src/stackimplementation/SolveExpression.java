package stackimplementation;

public class SolveExpression {
		
	//stack to store the operators
	private StackClass operatorStack;
	
	//stack to store the operands
	private StackClass operandStack;
	
	//constructor
	public SolveExpression(int length) {
		operatorStack = new StackClass(length);
		operandStack = new StackClass(length);
	}
	
	/*
	 * function to evaluate a string mathematical expression
	 * @param inputExpression is the string expression
	 * @return result of expression
	 */
	
	public int evaluateExpression(String inputExpression) throws Exception{
		
		//if expression in empty
		if (inputExpression == null){
			throw new Exception ("Invalid input");
		}
		
		//array of tokens seperated by space in original string
		String[] inputArray = inputExpression.split(" ");
		
		//traversing through the array containing the tokens
		for (int iterator =0;iterator<inputArray.length;iterator++){
			if ("(".equals(inputArray[iterator])){
				operatorStack.push(inputArray[iterator]);
			}
			else if (")".equals(inputArray[iterator])){
				while (!"(".equals(operatorStack.peek())){
					
					//evaluate expression enclosed within parentheses.
					operandStack.push(Integer.toString(createExpression(operatorStack, operandStack)));
				}
				
				// to remove the opening parentheses.
				operatorStack.pop();
			}	
			
			//if operator is encountered
			else if (isOperator(inputArray[iterator])){
				while ((!operatorStack.isEmpty()) && getOperatorPrecedence(inputArray[iterator]) >= getOperatorPrecedence(operatorStack.peek()) && (!"(".equals(operatorStack.peek())) ){
					operandStack.push(Integer.toString(createExpression(operatorStack, operandStack)));
				}	
				operatorStack.push(inputArray[iterator]);
			}
			else{
				//pushing operands to stack
				operandStack.push(inputArray[iterator]);
			}	
		}
		
		while (!operatorStack.isEmpty()){
			operandStack.push(Integer.toString(createExpression(operatorStack, operandStack)));
		}
		return Integer.parseInt(operandStack.pop());
	}
	
	/*
	 * function to check whether input is operator or not
	 * @param operator is the input string to be checked
	 * @return true if input is valid operator, false otherwise
	 */
	
	private boolean isOperator(String operator) {
		switch (operator){
		case "!":
		case "+":
		case "-":
		case "*":
		case "/":
		case "%":
		case ">":
		case ">=":
		case "<":
		case "<=":
		case "&&":
		case "||":
		case "==":
		case "!=":
			return true;
		default :
			return false;
		}
	}

	/*
	 * function to get the precedence of different operators
	 * @param is the string to be checked
	 * @return precedence value
	 */
	
	private int getOperatorPrecedence(String operator){
		int operatorPrecedence = 0;
		switch (operator){
		case "!":
			operatorPrecedence = 1;
			break;
		case "*":
		case "/":
		case "%":
			operatorPrecedence = 2;
			break;
		case "+":
		case "-":
			operatorPrecedence = 3;
			break;
		case "==":
		case "!=":
			operatorPrecedence = 4;
			break;
		case ">":
		case "<":
		case ">=":
		case "<=":
			operatorPrecedence = 5;
			break;
		case "&&":
			operatorPrecedence = 6;
			break;
		case "||":
			operatorPrecedence = 7;
			break;
		}
		return operatorPrecedence;	
	}
	
	/*
	 * function to create an expression to be evaluated
	 * @param operatorStack is the stack containing operators.
	 * @param operandStack is the stack containing operands.
	 * @throw Exception if stacks are null.
	 * @return solution of expression.
	 */
	
	private int createExpression(StackClass operatorStack, StackClass operandStack) throws Exception{
		if ((operatorStack==null)||(operandStack==null)){
			throw new Exception ("Null stacks");
		}
		
		if("!".equals(operatorStack.peek())){
			return solveUnaryExpression(operandStack.pop(), operatorStack.pop());
		}
			
		//calling function to solve the expression 
		return (solveBinaryExpression(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
	}

	/*
	 * function to solve unary expression
	 * @param operandString is the operand
	 * @operator is the operator
	 * @throws Exception if operator is invalid
	 * @return result of the expression
	 */
	
	private int solveUnaryExpression(String operandString, String operator) throws Exception {
		int operand = Integer.parseInt(operandString);
		int result = 0;
		switch(operator){
		case "!":
			if(!(operand != 0)){
				result = 1;
			} else {
				result = 0;
			}
			break;
		default :
			throw new Exception ("Invalid operator");
		}
		return result;
	}
	
	/*
	 * function to solve binary expression
	 * @param operand1 is the operand
	 * @param operand2 is the operand
	 * @operator is the operator
	 * @throws Exception if operator is invalid
	 * @return result of the expression
	 */	
	
	private int solveBinaryExpression(String operand1, String operand2, String operator) throws Exception {
		int result=0;
		int firstOperand = Integer.parseInt(operand1);
		int secondOperand = Integer.parseInt(operand2);
		switch (operator){
		case "+":
			result = secondOperand+firstOperand;
			break;
		case "-":
			result = secondOperand-firstOperand;
			break;
		case "*":
			result = secondOperand*firstOperand;
			break;
		case "/":
			result = secondOperand/firstOperand;
			break;
		case "%":
			result = secondOperand%firstOperand;
			break;
		case ">":
			if (secondOperand>firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;
		case ">=":
			if (secondOperand>=firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "<":
			if (secondOperand<firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "<=":
			if (secondOperand<=firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "==":
			if (secondOperand==firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "!=":
			if (secondOperand!=firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "&&":
			if ((secondOperand==0)||(firstOperand==0)){
				result = 0;
			}
			else{
				result =1;
			}
			break;	
		case "||":
			if ((secondOperand!=0)||(firstOperand!=0)){
				result = 1;
			}
			else{
				result =0;
			}
			break;		
		default :
			throw new Exception ("Invalid operator");
		}
		return result;
	}
}
