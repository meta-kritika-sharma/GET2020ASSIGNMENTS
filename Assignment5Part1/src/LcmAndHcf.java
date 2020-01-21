import java.util.*;

public class LcmAndHcf {

	public static int hcfOfTwoNumbers(int firstNumber, int secondNumber)
			throws Exception {
		/* Method to find the HCF of two non zero numbers by using recursion.
		 * @param firstNumber is the first input given by the user.
		 * @param secondNumber is the second input given by the user.
		 * @return the HCF of the numbers.
		 * @throw exception if both of the two inputs are "0" because their HCF is not defined.
		 * @throw exception if any of the input is negative.
		 */
		if (firstNumber == 0){
			return secondNumber;
		}
		if (secondNumber == 0) {
			return firstNumber;
		}
		if ((firstNumber == 0) && (secondNumber == 0)) {
			throw new Exception("Input should be a non zero number.");
		}
		if ((firstNumber<0) || (secondNumber<0)){
			throw new Exception ("Input should be a positive number.");
		}
		int remainder;
		if (firstNumber < secondNumber) {
			remainder = secondNumber % firstNumber;
			if (remainder == 0) {
				return firstNumber;
			} 
			else {
				secondNumber = firstNumber;
				firstNumber = remainder;
 				return hcfOfTwoNumbers(firstNumber, secondNumber);
			}
		} 
		else {
			remainder = firstNumber % secondNumber;
			if (remainder == 0) {
 				return secondNumber;
			} 
			else {
				firstNumber = secondNumber;
				secondNumber = remainder;
 				return hcfOfTwoNumbers(firstNumber, secondNumber);
			}
		}
	}
	
	public static int lcmOfTwoNumbers(int firstNumber, int secondNumber)
			throws Exception {
		/* Method to find the LCM of two non zero numbers by using recursion.
		 * @param firstNumber is the first input given by the user.
		 * @param secondNumber is the second input given by the user.
		 * @return the LCM of the numbers.
		 * @throw exception if any of the two inputs are "0".
		 */

		if ((firstNumber == 0)||(secondNumber==0)){
			throw new Exception ("Input should be a non zero number.");
		}
		int hcfResult = hcfOfTwoNumbers(firstNumber, secondNumber);
		int lcmOfTwoNumbers = (firstNumber * secondNumber) / hcfResult;
		return lcmOfTwoNumbers;
	}

	public static void main(String args[]) throws Exception {

		LcmAndHcf object = new LcmAndHcf();
		System.out.println(object.hcfOfTwoNumbers(0, 5));
		System.out.println(object.lcmOfTwoNumbers(10, 1));
	}
}
