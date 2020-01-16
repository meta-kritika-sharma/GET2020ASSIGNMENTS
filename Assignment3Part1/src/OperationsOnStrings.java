/*@author Kritika Sharma
 *@date 15-01-2020
 *OperationsOnStrings is a class that contains:
 *Method to compare two strings and return 1 if equals else 0.
 *Method to return the reverse of any string. 
 *Method to receive a string as a parameter and replace lowercase characters with uppercase and vice-versa. 
 *Method to return the largest word of a string. If two words are of same length then it will return the last word.
*/

import java.util.*;

public class OperationsOnStrings{

	public int isEqual(String firstString, String secondString){
		/*Method to check equality of two strings.
		 *@param firstString is the first input string.
		 *@param secondString is the second input string.
		 *@return 0 if strings are unequal and 1 if they are equal.
		 */
		
		if (firstString.length() == secondString.length()){
			for (int i = 0; i < firstString.length(); i++){
				if (firstString.charAt(i) != secondString.charAt(i)){
					return 0;
				}
			}
		}
		else{
			return 0;
		}
		return 1;
	}
	
	public String reverseString(String inputString){
		/*Method to reverse the input string.
		 *@param inputString is the string entered by user.
		 *@return the reverse of the input string.
		 */
		
		String reversedString = "";
		for (int i = inputString.length() - 1; i >= 0; i --){
			reversedString = reversedString + inputString.charAt(i);
		}
		return reversedString; 
	}
	
	public String replaceString(String inputString){
		/*Method to replace the upper case characters with lower case and vice versa.
		 *@param inputString is the string entered by user.
		 *@return the new string with characters replaced.
		 */
		
		String finalString = "";
		for (int i = 0; i < inputString.length(); i++){
			if (inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z'){
				finalString = finalString + (char) ((int) inputString.charAt(i) + 32);
			}
			else if (inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z'){
				finalString = finalString + (char) ((int) inputString.charAt(i) - 32);
			}
			else {
				finalString = finalString + inputString.charAt(i);
			}
		}
		return finalString;
	}
	
	public String largestWord(String sentence){
		/*Method to find the largest word in a space seperated string.
		 *@param sentence is the space seperated input entered by the user.
		 *@return the largest length word in string. If two words are of same length , then returns the last word.
		 */
		
		String[] splitArray = sentence.split(" ");
		String maximumLengthWord = splitArray[0];
		for (int i = 0; i < splitArray.length; i++){
			if (splitArray[i].length() >= maximumLengthWord.length()){
				maximumLengthWord = splitArray[i];
			}
		}
		return maximumLengthWord;
	}
	public void userInput() {
		/*Method to get user choice and strings as input
		 *@throw exception when user enters a string or character value where integer value is expected.
		 */
		
		System.out.println("Enter 1 for checking equality of strings.");
		System.out.println("Enter 2 for reversing the string.");
		System.out.println("Enter 3 for replace lowercase characters with uppercase or vice-versa.");
		System.out.println("Enter 4 for returning the largest word of string.");
		System.out.println("Enter 5 to exit");
		int flag = 0;
		while (flag == 0){
			Scanner sc = new Scanner(System.in);
			int userChoice;
			try{
				System.out.println ("Enter your choice:");
				userChoice = sc.nextInt();
				if (userChoice == 1){
					System.out.println ("Enter first string:");
					String string1 = sc.next();
					System.out.println ("Enter second string:");
					String string2 = sc.next();
					System.out.println(isEqual(string1, string2));
				}
				else if (userChoice == 2){
					System.out.println ("Enter your string:");
					sc.nextLine();
					String StringToBeReversed = sc.nextLine();
					System.out.println("Reverse string is : " + reverseString(StringToBeReversed));
				}
				else if (userChoice == 3){
					System.out.println ("Enter your string:");
					sc.nextLine();
					String StringToBeReplaced = sc.nextLine();
					System.out.println("Replaced string is : " + replaceString(StringToBeReplaced));
				}
				else if (userChoice == 4){
					System.out.println ("Enter a sentence:");
					sc.nextLine();
					String Sentence = sc.nextLine();
					System.out.println("Largest word is : " + largestWord(Sentence));
				}
				else if (userChoice == 5){
					System.out.println("Thanks for using.");
					flag = 1;
				}
				else{
					System.out.println("Invalid input. Please enter your choice again.");
				}
			}
			catch (Exception e){
				System.out.println("Invalid input. Please enter your choice again.");
			}
		}
	}
	public static void main(String args[]){
		OperationsOnStrings object = new OperationsOnStrings();
		object.userInput();
	}
}
