package counsellingImplementation;

//program class
public class Program {
	private String name;
	private final int seatsAvailable;
	private int occupiedSeats;

	/**
	 * Constructor
	 * @param name of Program
	 * @param availableSeats
	 */
	public Program(String name, int seatsAvailable){
		this.name = name;
		this.seatsAvailable = seatsAvailable;
		this.occupiedSeats = 0;
	}
	
	//getters and setters
	
	public String getName() {
		return this.name;
	}
	
	public int getAvailableSeats(){
		return seatsAvailable;
	}
	
	/**
	 * Function to check availability of seats
	 * @return true if seat is available, false otherwise
	 */
	public boolean isSeatAvailable(){
		return (this.occupiedSeats < this.seatsAvailable);
	}
	
	/**
	 * Function to alter occupied seats
	 * @return true if seat is occupied, false otherwise
	 */
	public boolean occupySeat() {
		if(this.isSeatAvailable()){
			this.occupiedSeats++;
			return true;
		}
		return false;
	}
}
