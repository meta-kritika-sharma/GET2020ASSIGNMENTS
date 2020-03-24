public class Main {

	public static void main(String[] args) {
		Polynomial polynomial = new Polynomial();
		Main object = new Main();
		try{
			object.polynomialInput(polynomial);
			polynomial.showPolynomial();
			System.out.println("\nDegree of Polynomial : " +polynomial.degreeOfPolynomial());
		}
		
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}
	}
	
	private void polynomialInput(Polynomial polynomial) throws Exception{
		
		//taking input for first term
		TermOfPolynomial term1 = new TermOfPolynomial(1);
		term1.addVariableToTerm(new Variable('x',2));
		term1.addVariableToTerm(new Variable('y',3));
		
		//adding first term
		polynomial.addTermToPolynomial(term1);
		
		//taking input for second term
		TermOfPolynomial term2 = new TermOfPolynomial(2);
		term2.addVariableToTerm(new Variable('x',4));
		term2.addVariableToTerm(new Variable('y',8));

		//adding second term
		polynomial.addTermToPolynomial(term2);
		
		TermOfPolynomial term3 = new TermOfPolynomial(3);
		
		//adding third (constant) term
		polynomial.addTermToPolynomial(term3);
	}
}
