package triangle;

public class Triangle {
	
	/**
	 * Function to calculate area of triangle using Heron's Formulae
	 * @param firstSide
	 * @param secondSide
	 * @param thirdSide
	 * @return area of triangle
	 * @throws Exception 
	 */
	public String area(String side1, String side2, String side3) throws Exception {
 
		if ((side1==null)||(side2==null)||(side3==null)){
			throw new Exception ("Side is empty");
		}
		
		if (!(side1.matches("^[0-9]+$")) ||!(side2.matches("^[0-9]+$"))||!(side3.matches("^[0-9]+$"))){
			throw new Exception ("Enter a valid side.");
		}
			Double parseSide1 = Double.parseDouble(side1);
			Double parseSide2 = Double.parseDouble(side2);
			Double parseSide3 = Double.parseDouble(side3);
			double perimeter = (parseSide1 + parseSide2 + parseSide3) / 2;
			double result = Math.sqrt((perimeter) * (perimeter - parseSide1)
					* (perimeter - parseSide2) * (perimeter - parseSide3));
			return String.valueOf(result);
		}
	
}