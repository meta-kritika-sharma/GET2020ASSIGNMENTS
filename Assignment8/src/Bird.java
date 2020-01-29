/**
 * The Class Bird.
 */
public abstract class Bird extends Animal {

	/** The flight of bird. */
	private float flightOfBird;

	/**
	 * Instantiates a new bird.
	 *
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param weightOfAnimal the weight of animal
	 * @param flightOfBird the flight of bird
	 */
	public Bird(String nameOfAnimal, int ageOfAnimal, int weightOfAnimal,
			float flightOfBird) {
		super(nameOfAnimal, ageOfAnimal, weightOfAnimal);
		this.setFlightOfBird(flightOfBird);
	}

 	public String getClassOfAnimal() {
		return "Bird";
	};

	/**
	 * Gets the flight of bird.
	 *
	 * @return the flight of bird
	 */
	public float getFlightOfBird() {
		return flightOfBird;
	}

	/**
	 * Sets the flight of bird.
	 *
	 * @param flightOfBird the new flight of bird
	 */
	public void setFlightOfBird(float flightOfBird) {
		this.flightOfBird = flightOfBird;
	}

 	public abstract String typeOfAnimal();
	public abstract String getSound();

}
