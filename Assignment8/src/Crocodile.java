public class Crocodile extends Reptile {

	/**
	 * Instantiates a new crocodile.
	 *
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param weightOfAnimal the weight of animal
	 * @param length the length
	 */
	public Crocodile(String nameOfAnimal, int ageOfAnimal, int weightOfAnimal,
			float length) {
		super(nameOfAnimal, ageOfAnimal, weightOfAnimal, length);
	}

	@Override
	public String typeOfAnimal() {
		return "Crocodile";
	}

 	@Override
	public String getSound() {
		return "Growls";
	}

}
