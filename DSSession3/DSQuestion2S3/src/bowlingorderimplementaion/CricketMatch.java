package bowlingorderimplementaion;

import java.util.ArrayList;
import java.util.List;

public class CricketMatch {
	
	private BowlerQueueInterface bowler;
	private int ballsToBeFaced;
	private int totalDeliveries =0;
	
	public CricketMatch(int numberOfBowlers, int ballsToBeFaced) throws Exception{
		
		if ((numberOfBowlers<=0) || (ballsToBeFaced<=0)){
			throw new Exception ("Invalid input");
		}
		this.bowler = new BowlerQueueClass(numberOfBowlers);
		this.ballsToBeFaced = ballsToBeFaced;
	}
	
	public void addBowler(Bowler newBowler) throws Exception{
		
		if (newBowler == null){
			throw new Exception ("Null bowler object");
		}
		bowler.enQueue(newBowler);
		totalDeliveries = totalDeliveries + newBowler.getNumberOfDeliveries();
	}
	
	public void orderBowlers() throws Exception{
		if (totalDeliveries < ballsToBeFaced){
			throw new Exception ("Inadequate bowlers");
		}
		List <String> listOfSelectedBowlers = new ArrayList<>();	
			while (!bowler.isEmpty() && ballsToBeFaced != 0) {
				Bowler currentBowler = bowler.deQueue();
				int ballsToBeBowled = ballsToBeFaced;
				if (!bowler.isEmpty()) {
					if (ballsToBeBowled>= currentBowler.getNumberOfDeliveries()-bowler.getFront().getNumberOfDeliveries()+1){
						ballsToBeBowled = currentBowler.getNumberOfDeliveries()-bowler.getFront().getNumberOfDeliveries()+1;
					}
				} else {					
					if (ballsToBeBowled>= currentBowler.getNumberOfDeliveries()){
						ballsToBeBowled = currentBowler.getNumberOfDeliveries();
					}
				}
				listOfSelectedBowlers.add(currentBowler.getNameOfBowler());
				currentBowler.setNumberOfDeliveries(currentBowler.getNumberOfDeliveries()-ballsToBeBowled);
				ballsToBeFaced = ballsToBeFaced- ballsToBeBowled;
				if (currentBowler.getNumberOfDeliveries() != 0) {
					bowler.enQueue(currentBowler);
				}
			}
			
		
		System.out.println("list ");
		for (int i=0;i<listOfSelectedBowlers.size();i++){
			System.out.println(listOfSelectedBowlers.get(i));
		}
	}
}
