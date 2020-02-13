/*@author: Kritika Sharma
 *@date : 14-01-2020
 *This program consists of HexCalc class that supports following methods for hexadecimal arithmetic assuming that this class will be working with only positive integers.
 *Methods to add, subtract, multiply and divide two hexadecimal numbers. 
 *Each of the methods will receive hexadecimal numbers as strings, and will return the computed value as hexadecimal string. The strategy that can be followed by each of the methods is to convert the strings into numbers, perform the computation, and reconvert the result back into hexadecimal representation.
 *Methods to compare two hexadecimal numbers for ==, > and <. Each of these methods will return a boolean value.
 *Method to return the decimal representation of hexadecimal number.
 *Method to return the hexadecimal representation of decimal number.
 */

import java.util.*;
import java.lang.Math;

public class HexCalc {
	HashMap<Character , Integer> hexaDecimalLetters;
	Integer HEXADECIMALBASE = 16;
	Integer ASCIIVALUEOFZERO = 48;

	public HexCalc(){
		hexaDecimalLetters = new HashMap<>(); 
		hexaDecimalLetters.put('A' , 10);
		hexaDecimalLetters.put('B' , 11);
		hexaDecimalLetters.put('C' , 12);
		hexaDecimalLetters.put('D' , 13);
		hexaDecimalLetters.put('E' , 14);
		hexaDecimalLetters.put('F' , 15);
	}
	
	public String addHexaDecimalNumbers(String hexaDecimalNum1, String hexaDecimalNum2){
		/*Method to add two hexadecimal integers.
		 * @param HexaDecimalNum1 is the first input hexadecimal number as string.
		 * @param HexaDecimalNum1 is the first input hexadecimal number as string.
		 * @return sum of the numbers as a string.
		 */
		String finalResult = "";
		int hexaDecNum1 = convertToDecimal(hexaDecimalNum1);
		int hexaDecNum2 = convertToDecimal(hexaDecimalNum2);
		finalResult = convertToHexadecimal(hexaDecNum1 + hexaDecNum2);
		return finalResult;
	}
	
	public String subHexaDecimalNumbers(String hexaDecimalNum1, String hexaDecimalNum2){
		/*Method to subtract two hexadecimal integers.
		 * @param HexaDecimalNum1 is the first input hexadecimal number as string.
		 * @param HexaDecimalNum1 is the first input hexadecimal number as string.
		 * @return difference of the numbers as a string.
		 */
		String finalResult = "";
		int hexaDecNum1 = convertToDecimal(hexaDecimalNum1);
		int hexaDecNum2 = convertToDecimal(hexaDecimalNum2);
		finalResult = convertToHexadecimal(hexaDecNum1 - hexaDecNum2);
		return finalResult;
	}
	
	public String mulHexaDecimalNumbers(String hexaDecimalNum1, String hexaDecimalNum2){
		/*Method to multiply two hexadecimal numbers.
		 * @param HexaDecimalNum1 is the first input hexadecimal number as string.
		 * @param HexaDecimalNum1 is the first input hexadecimal number as string.
		 * @return product of the numbers as a string.
		 */
		String finalResult = "";
		int hexaDecNum1 = convertToDecimal(hexaDecimalNum1);
		int hexaDecNum2 = convertToDecimal(hexaDecimalNum2);
		finalResult = convertToHexadecimal(hexaDecNum1 * hexaDecNum2);
		return finalResult;
	}
	
	public String divHexaDecimalNumbers(String hexaDecimalNum1, String hexaDecimalNum2){
		/*Method to divide two hexadecimal numbers.
		 * @param HexaDecimalNum1 is the first input hexadecimal number as string.
		 * @param HexaDecimalNum1 is the first input hexadecimal number as string.
		 * @return remainder and quotient of the numbers as a string.
		 */
		 String finalResult = "";
		 int hexaDecNum1 = convertToDecimal(hexaDecimalNum1);
     	 int hexaDecNum2 = convertToDecimal(hexaDecimalNum2);
		 finalResult = convertToHexadecimal(hexaDecNum1 / hexaDecNum2);
		 int remainder = hexaDecNum1 % hexaDecNum2;
		 System.out.print("The remainder is " + remainder);
		 return finalResult;
	}
	
	public Boolean compareEqualHexaDecimalstrings(String hexaDecimalNum1, String hexaDecimalNum2){
		/*Method to compare two hexadecimal integers for equality.
		 * @param HexaDecimalNum1 is the first input hexadecimal number as string.
		 * @param HexaDecimalNum1 is the first input hexadecimal number as string.
		 * @return true if integers are equal and false if they are unequal.
		 */
 		if (hexaDecimalNum1.length() == hexaDecimalNum2.length()){
			for (int i = 0 ; i < hexaDecimalNum1.length() ; i++){
				if (hexaDecimalNum1.charAt(i) != hexaDecimalNum2.charAt(i)){
					return false;
				}
			}
 		}
		else{
			return false;
		}
 		return true;
	}
	
	public boolean compareHexStrings(String hexaDecimalNum1, String hexaDecimalNum2){
		/*Method to compare two hexadecimal integers.
		 * @param HexaDecimalNum1 is the first input hexadecimal number as string.
		 * @param HexaDecimalNum1 is the first input hexadecimal number as string.
		 * @return true if first integer are greater and false if it is smaller.
		 */

		if (hexaDecimalNum1.length() < hexaDecimalNum2.length()){
			return true;
		}
		else if (hexaDecimalNum1.length() > hexaDecimalNum2.length()){
			return false;
		}
		else{
			for (int i = 0 ; i < hexaDecimalNum1.length() ; i++){
				if (hexaDecimalNum1.charAt(i) > hexaDecimalNum2.charAt(i)){
					return false;
				}
			}
		}
		return true;
	}
	
	public int validInputCheck(String hexNum){
		/*Method to check if user has entered an invalid hexadecimal number as an input.
		 * @param HexNum
		 * @return 
		 */
		for (int i=0 ; i < hexNum.length() ; i++){
			if (Character.isLetter(hexNum.charAt(i))){
				if (!(hexNum.charAt(i) >= 'A' && hexNum.charAt(i) <= 'F')){
					System.out.println(hexNum.charAt(i) + "Invalid");
					return 1;
				}
			}
		} 
		return 0;
	}
	
	public int convertToDecimal(String hexNum){
		/*This method converts a hexadecimal input string to decimal integer.
		 * @param HexNum It is a hexadecimal number string
		 * @return Decimal equivalent of hexadecimal string input*/
		int result = 0;
		int value = 0;
		for (int i = hexNum.length() - 1 ; i >= 0 ; i--){
			if (Character.isLetter(hexNum.charAt(i))){
				value = hexaDecimalLetters.get(hexNum.charAt(i));
			}
			else{
				value = (int) hexNum.charAt(i) - ASCIIVALUEOFZERO;
			}
			result = (int) (result + (value * Math.pow(HEXADECIMALBASE , hexNum.length() - i - 1)));
		}
		return result;
	}
	
	public String convertToHexadecimal(Integer decimalNum){
		/*This method converts Decimal input to hexadecimal string.
		 * @param DecimalNum
		 * @return hexadecimal string equivalent of decimal input.
		 */
		String hexString = "";
		if (decimalNum == 0){
			return "0";
		}
		else{
			while (decimalNum != 0){
				int rem = decimalNum % HEXADECIMALBASE;
				if (rem > 9){
					Iterator hmIterator = hexaDecimalLetters.entrySet().iterator();
					while(hmIterator.hasNext()){
						Map.Entry mapElement = (Map.Entry) hmIterator.next();
						if ((int) mapElement.getValue() == rem){
							Character intermediateElement = (Character) mapElement.getKey();
							hexString = hexString + intermediateElement;
							break;
						}
					}
				}
				else{
					hexString = hexString + rem;
				}
				decimalNum = decimalNum / HEXADECIMALBASE;
			}
		}
		
		StringBuilder hexOutput = new StringBuilder();
		hexOutput.append(hexString);
		hexString = hexOutput.reverse().toString();
		return hexString;
	}
	
	public void userChoice(){
		System.out.println("Enter 1 for addition.");
		System.out.println("Enter 2 for subtraction.");
		System.out.println("Enter 3 for multiplication.");
		System.out.println("Enter 4 for division.");
		System.out.println("Enter 5 for checking equality of strings.");
		System.out.println("Enter 6 for checking if first string is smaller.");
		System.out.println("Enter 7 to exit");
		int choice = 0;
		int flag = 0;
		while(flag == 0){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice:");
			try{
				choice = sc.nextInt();
				if (choice == 1){
					System.out.println("Enter first string:");
					String hexString1 = sc.next();
					int resultOfCheck = validInputCheck(hexString1.toUpperCase());
					if (resultOfCheck == 0){
						System.out.println("Enter second string:");
						String hexString2 = sc.next();
						resultOfCheck = validInputCheck(hexString2.toUpperCase());
						if (resultOfCheck == 0){
							System.out.println("The sum is : "+addHexaDecimalNumbers(hexString1.toUpperCase() , hexString2.toUpperCase()));
						}
						else{
							System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
						}
					}
					else{
						System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
					}
				}
				else if (choice == 2){
					System.out.println("Enter first string:");
					String hexString1 = sc.next();
					int resultOfCheck = validInputCheck(hexString1.toUpperCase());
					if (resultOfCheck == 0){
						System.out.println("Enter second string:");
						String hexString2 = sc.next();
						resultOfCheck = validInputCheck(hexString2.toUpperCase());
						if (resultOfCheck == 0){
							System.out.println("The difference is : "+subHexaDecimalNumbers(hexString1.toUpperCase() , hexString2.toUpperCase()));}
						else{
							System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
						}
					}
					else{
						System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
					}
				}
				else if (choice == 3){
					System.out.println("Enter first string:");
					String hexString1 = sc.next();
					int resultOfCheck = validInputCheck(hexString1.toUpperCase());
					if (resultOfCheck == 0){
						System.out.println("Enter second string:");
						String hexString2 = sc.next();
						resultOfCheck = validInputCheck(hexString2.toUpperCase());
						if (resultOfCheck == 0){
							System.out.println("The product is : "+ mulHexaDecimalNumbers(hexString1.toUpperCase() , hexString2.toUpperCase()));	}
						else{
							System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
						}
					}
					else{
						System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
					}
				}
				else if (choice == 4){
					System.out.println("Enter first string:");
					String hexString1 = sc.next();
					int resultOfCheck = validInputCheck(hexString1.toUpperCase());
					if (resultOfCheck == 0){
						System.out.println("Enter second string:");
						String hexString2 = sc.next();
						resultOfCheck = validInputCheck(hexString2.toUpperCase());
						if (resultOfCheck == 0){
							System.out.println(" and the quotient is : " + divHexaDecimalNumbers(hexString1.toUpperCase() , hexString2.toUpperCase()));	}
						else{
							System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
						}
					}
					else{
						System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
					}
				}
				else if (choice == 5){
					System.out.println("Enter first string:");
					String hexString1 = sc.next();
					int resultOfCheck = validInputCheck(hexString1.toUpperCase());
					if (resultOfCheck == 0){
						System.out.println("Enter second string:");
						String hexString2 = sc.next();resultOfCheck = validInputCheck(hexString2.toUpperCase());
						if (resultOfCheck == 0){
							System.out.println(compareEqualHexaDecimalstrings(hexString1.toUpperCase() , hexString2.toUpperCase()));}
						else{
							System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
						}
					}
					else{
						System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
					}
				}
				else if (choice == 6){
					System.out.println("Enter first string:");
					String hexString1 = sc.next();
					int resultOfCheck = validInputCheck(hexString1.toUpperCase());
					if (resultOfCheck == 0){
						System.out.println("Enter second string:");
						String hexString2 = sc.next();resultOfCheck = validInputCheck(hexString2.toUpperCase());
						if (resultOfCheck == 0){
							System.out.println(compareHexStrings(hexString1.toUpperCase() , hexString2.toUpperCase()));}
						else{
							System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
						}
					}
					else{
						System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
					}

				}
 				else if (choice == 7){
					System.out.println("Thanks for using.");
					return;
				}
				else{
					System.out.println("Invalid Choice.");
				}
			}
			catch(java.util.InputMismatchException e){
				System.out.println("Invalid Input. Please enter your choice again.");
			}
		}
	}
	
	public static void main(String args[]){
		HexCalc object = new HexCalc();
		object.userChoice();
	}
}