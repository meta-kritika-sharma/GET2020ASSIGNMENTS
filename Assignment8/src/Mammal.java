public abstract class Mammal extends Animal {

 	private Boolean carnivorous;

	/**
	 * Instantiates a new mammal.
	 *
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param weightOfAnimal the weight of animal
	 * @param carnivorous the carnivorous
	 */
	public Mammal(String nameOfAnimal, int ageOfAnimal, int weightOfAnimal,
			Boolean carnivorous) {
		super(nameOfAnimal, ageOfAnimal, weightOfAnimal);
		this.carnivorous = carnivorous;
	}

 	@Override
	public String getClassOfAnimal() {
		return "Mammal";
	};

	/**
	 * Checks if is carnivorous.
	 *
	 * @return the boolean
	 */
	public Boolean isCarnivorous() {
		return carnivorous;
	}

 	public abstract String typeOfAnimal();
	public abstract String getSound();

}
