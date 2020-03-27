package uniquecharacterimplementation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Main mainObject = new Main();
		try{
			mainObject.userInput();
		}
		catch (Exception exception){
			System.out.println(exception.getMessage());
		}
	}

	//function to get user input
	private void userInput() throws Exception {
		UniqueCharacter character1 = new UniqueCharacter("malyalam");
		System.out.println(character1.countUniqueCharacters());
		UniqueCharacter character2 = new UniqueCharacter("malyalam");
		System.out.println(character2.countUniqueCharacters());
	}
}
