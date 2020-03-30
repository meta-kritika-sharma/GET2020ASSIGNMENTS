package fileSystem;

import java.util.Scanner;

public class Main {

	/**
	 * Main function to implement command line
	 * @param args
	 */
	public static void main(String args[]){
		try{
			Main mainObject = new Main();
			mainObject.userInput();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//getting user input 
	
	private void userInput() throws Exception{
		Scanner scanner = new Scanner(System.in);
		FileSystem fileSystem = new FileSystem();
		boolean flag = true;
		
		while(flag) {
			fileSystem.displayPresentWorkingDirectory();
			String command = scanner.nextLine();
			String[] tokens = command.split(" ");
			
			switch(tokens[0]) {
			case "mkdir":
				if(tokens.length != 2 || tokens[1].length() == 0){
					printInvalidSyntax();
				} else {
					fileSystem.addFolder(tokens[1]);
				}
				break;
			case "cd":
				if(tokens.length != 2 || tokens[1].length() == 0){
					printInvalidSyntax();
				} else {
					fileSystem.changeDirectory(tokens[1]);
				}
				break;
			case "bk":
				if(tokens.length != 1){
					printInvalidSyntax();
				} else {
					fileSystem.moveToParent();
				}
				break;
			case "ls":
				if(tokens.length > 2 || (tokens.length ==2 && tokens[1].length() == 0)){
					printInvalidSyntax();
				} else if(tokens.length == 1) {
					fileSystem.listSubDirectories(null);
				} else {
					fileSystem.listSubDirectories(tokens[1]);
				}
				break;
			case "exit":
				flag = false;
				break;
			case "find":
				if(tokens.length != 2 || tokens[1].length() == 0){
					printInvalidSyntax();
				} else {
					fileSystem.findFolder(tokens[1]);
					System.out.println();
				}
				break;
			case "tree":
				if(tokens.length != 1){
					printInvalidSyntax();
				} else {
					fileSystem.printTree();
				}
				break;
			default:
				System.out.println(tokens[0] + " is not recognised as a command!\n");
			}
		}
		
		scanner.close();

	}
	
	/**
	 * Function to print invalid syntax message
	 */
	private void printInvalidSyntax(){
		System.out.println("The syntex of the command is incorrent!\n");
	}
	


}
