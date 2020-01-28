public class Peacock extends Bird {

	/**
	 * Instantiates a new peacock.
	 *
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param weightOfAnimal the weight of animal
	 * @param flight the flight
	 */
	public Peacock(String nameOfAnimal, int ageOfAnimal, int weightOfAnimal,
			float flight) {
		super(nameOfAnimal, ageOfAnimal, weightOfAnimal, flight);
	}

 	@Override
	public String typeOfAnimal() {
		return "Peacock";
	}

 	@Override
	public String getSound() {
		return "Screams";
	}
}
