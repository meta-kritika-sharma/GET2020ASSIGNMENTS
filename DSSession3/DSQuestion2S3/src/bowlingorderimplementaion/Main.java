package bowlingorderimplementaion;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main object = new Main();
		try{
			object.userInput();
		}
		catch (Exception exception){
			System.out.println(exception.getMessage());
		}
	}
	
	//function to get user input about bowler and deliveries
	private void userInput() throws Exception{
		System.out.println("Enter number of bowlers : ");
		Scanner scanner = new Scanner(System.in);
		int numberOfBowlers = scanner.nextInt();
		System.out.println("Enter balls to be faced : ");
		int ballsToBeFaced = scanner.nextInt();
		int quota;
		CricketMatch match = new CricketMatch(numberOfBowlers,ballsToBeFaced);
		
		System.out.println("Enter bowler details : ");
		//loop to get bowler details
		for (int iterator =0; iterator<numberOfBowlers;iterator++){
			System.out.println("Enter name of bowler : ");
			String name = scanner.next();
			System.out.println("Enter quota for bowler : "+iterator);
			quota = scanner.nextInt();
			
			//adding bowler to queue
			match.addBowler(new Bowler(name,quota));
		}
		
		match.orderBowlers();
	}

}
