package molecularweight;

import java.util.HashMap;

public class MolecularWeight {

	private String molecule;
	private final int ASCII_OF_ZERO = 48;

	// to store the masses of elements
	private static HashMap<Character, Integer> massOfElements;

	// hash map initialization
	static {
		massOfElements = new HashMap<Character, Integer>();
		massOfElements.put('C', 12);
		massOfElements.put('O', 16);
		massOfElements.put('H', 1);
	}

	// constructor
	public MolecularWeight(String molecule) {
		this.molecule = molecule.toUpperCase();
	}

	/*
	 * function to return molecular weight of given formula
	 */
	public int getMolecularWeight() {

		// weight of entire molecule
		int weight = 0;

		// weight of compound enclosed within parantheses in the molecule
		int intermediateWeight = 0;

		// traversing through the string
		for (int iterator = 0; iterator < molecule.length(); iterator++) {
			weight = checkNextElement(weight, iterator);
			if (molecule.charAt(iterator) == '(') {
				iterator++;
				while ((molecule.charAt(iterator) != ')') && (iterator < molecule.length())) {
					intermediateWeight = checkNextElement(intermediateWeight, iterator);
					iterator++;
				}

				// expression after parentheses
				if (iterator + 1 < molecule.length() && Character.isDigit(molecule.charAt(iterator + 1))) {
					weight = weight + ((molecule.charAt(iterator + 1) - ASCII_OF_ZERO) * intermediateWeight);
				} else {
					weight = weight + intermediateWeight;
				}
				intermediateWeight = 0;
			}
		}
		return weight;
	}

	// helper function
	private int checkNextElement(int weight, int iterator) {

		// checking if next element is a digit
		if ((iterator + 1) < molecule.length() && Character.isDigit(molecule.charAt(iterator + 1))) {
			weight = weight + ((molecule.charAt(iterator + 1) - ASCII_OF_ZERO) * massOfElements.get(molecule.charAt(iterator)));
		}
		// if digit or parentheses is not encountered
		else if (!Character.isDigit(molecule.charAt(iterator)) && molecule.charAt(iterator) != '(' && molecule.charAt(iterator) != ')') {
			weight = weight + massOfElements.get(molecule.charAt(iterator));
		}
		return weight;
	}
}
