package bowlingorderimplementaion;

//Bowler class
public class Bowler {

	private String nameOfBowler;
	private int numberOfDeliveries;

	// constructor
	public Bowler(String nameOfBowler, int numberOfDeliveries) throws Exception {

		if (numberOfDeliveries <= 0) {
			throw new Exception("Deliveries should be greater than 0");
		}
		
		this.nameOfBowler = nameOfBowler;
		this.numberOfDeliveries = numberOfDeliveries;
	}

	// getters and setters

	public String getNameOfBowler() {
		return nameOfBowler;
	}

	public void setNameOfBowler(String nameOfBowler) {
		this.nameOfBowler = nameOfBowler;
	}

	public int getNumberOfDeliveries() {
		return numberOfDeliveries;
	}

	public void setNumberOfDeliveries(int numberOfDeliveries) {
		this.numberOfDeliveries = numberOfDeliveries;
	}
}
