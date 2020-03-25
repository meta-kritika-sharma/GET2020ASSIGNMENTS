public class Polynomial {

	//pointer to the first term
	private TermOfPolynomial head;
	
	/*
	 * function to add term to polynomial
	 * @param term is the term to be added
	 */
	public void addTermToPolynomial(TermOfPolynomial term){
		//if polynomial is empty
		if (head==null){
			head = term;
		}
		
		else{
			TermOfPolynomial tempTerm = head;
			while (tempTerm.getNextTerm()!=null){
				tempTerm = tempTerm.getNextTerm();
			}
			tempTerm.setNextTerm(term);
		}
	}
	
	/*
	 * function to show polynomial
	 */
	public void showPolynomial() throws Exception{
		
		TermOfPolynomial tempTerm = head;
		
		//fetching each term of polynomial
		while (tempTerm!=null){
			System.out.print(tempTerm.getCoefficient());
			
			//fetching variables for each term
			if(tempTerm.getVariables() != null){
				System.out.print("*");
				tempTerm.showVariables();
			}
			tempTerm = tempTerm.getNextTerm();
			if(tempTerm != null){
				System.out.print(" + ");
			}
		}
	}
	
	/*
	 * function to return degree of polynomial
	 * @return degree of polynomial
	 */
	public int degreeOfPolynomial() throws Exception{		
		if (head==null){
			return 0;
		}

		TermOfPolynomial tempTerm = head;
		int degreeOfPolynomial = 0;
		
		//traversing through the polynomial
		while (tempTerm!=null){
			if (tempTerm.getDegree()>degreeOfPolynomial){
				degreeOfPolynomial = tempTerm.getDegree();
			}
			tempTerm = tempTerm.getNextTerm();
		}
		return degreeOfPolynomial;
	}
}
