package uniquecharacterimplementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueCharacter {

	private static HashMap<String, Integer> enteredStrings;
	private String inputString;

	// initializing hash map
	static {
		enteredStrings = new HashMap<String, Integer>();
	}

	// constructor
	public UniqueCharacter(String inputString) throws Exception {

		if (inputString.trim().length() == 0) {
			throw new Exception("Invalid string");
		}

		this.inputString = inputString;
	}

	/*
	 * function to count unique characters in string
	 * 
	 * @return number of unique characters
	 */
	public int countUniqueCharacters() {

		// checking cache for availability of string
		if (enteredStrings.containsKey(inputString)) {
			return enteredStrings.get(inputString);
		}

		// if cache doesn't contain input string
		int uniqueCharacters = 0;
		Set<Character> hashSet = new HashSet<Character>();
		for (int iterator = 0; iterator < inputString.length(); iterator++) {
			hashSet.add(inputString.charAt(iterator));
		}
		uniqueCharacters = hashSet.size();
		enteredStrings.put(inputString, uniqueCharacters);
		return uniqueCharacters;
	}

}
