public class Lion extends Mammal {

	/**
	 * Instantiates a new lion.
	 *
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param weightOfAnimal the weight of animal
	 * @param carnivorous the carnivorous
	 */
	public Lion(String nameOfAnimal, int ageOfAnimal, int weightOfAnimal,
			Boolean carnivorous) {
		super(nameOfAnimal, ageOfAnimal, weightOfAnimal, carnivorous);
	}

 	@Override
	public String typeOfAnimal() {
		return "Lion";
	}

 	@Override
	public String getSound() {
		return "roar";
	}
}
