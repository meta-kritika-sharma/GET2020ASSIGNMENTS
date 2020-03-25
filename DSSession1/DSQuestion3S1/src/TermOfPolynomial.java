
public class TermOfPolynomial {

	private int coefficient;
	
	//pointer to next term of polynomial
	private TermOfPolynomial nextTerm;
	
	//pointer to the first node of variable
	private Variable head;
	
	//constructor
	public TermOfPolynomial(int coefficient){
		this.coefficient = coefficient;
	}
	
	// getters and setters
	public int getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	public Variable getVariables(){
		return this.head;
	}
	public TermOfPolynomial getNextTerm() {
		return nextTerm;
	}
	public void setNextTerm(TermOfPolynomial nextTerm) {
		this.nextTerm = nextTerm;
	}

	/*
	 * function to add variable to term of polynomial
	 * @param variable is the variable object 
	 */
	public void addVariableToTerm(Variable variable) {
		
		// if the term does not exist
		if (head == null){
			head = variable;
		}
		else{
			Variable tempVariable = head;
			while (tempVariable.getNextVariable()!=null){
				tempVariable = tempVariable.getNextVariable();
			}		
			tempVariable.setNextVariable(variable);
		}
	}
	
	/*
	 * function to display variables of a term
	 */
	public void showVariables() throws Exception{
		
		// Term is a constant
		if (head==null){
			return;
		}
		
		Variable tempVariable = head;
		
		//traversing through the variables
		while (tempVariable!=null){
			System.out.print(tempVariable.getVariable()+" ^ "+tempVariable.getDegree()+" * ");
			tempVariable = tempVariable.getNextVariable();
		}
	}
	
	/*
	 * function to get degree of a term
	 * @return degree of a term
	 */
	public int getDegree() throws Exception{
		
		if (head == null){
			return 0;
		}
		
		Variable tempVariable = head;
		int degreeOfTerm = 0;
		
		//traversing through the variable
		while (tempVariable!=null){
			
			//adding degree of each variable of term
			degreeOfTerm = degreeOfTerm+tempVariable.getDegree();
			tempVariable = tempVariable.getNextVariable();
		}
		return degreeOfTerm;
	}
}
