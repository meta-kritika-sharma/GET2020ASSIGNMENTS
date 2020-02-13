public abstract class Reptile extends Animal {

	private float length;

	/**
	 * Instantiates a new reptile.
	 *
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param weightOfAnimal the weight of animal
	 * @param length the length
	 */
	public Reptile(String nameOfAnimal, int ageOfAnimal, int weightOfAnimal,
			float length) {
		super(nameOfAnimal, ageOfAnimal, weightOfAnimal);
		this.length = length;
	}

 	public String getClassOfAnimal() {
		return "Reptile";
	};

	/**
	 * Gets the length of animal.
	 *
	 * @return the length of animal
	 */
	public float getLengthOfAnimal() {
		return length;
	}
 
	public abstract String typeOfAnimal();
 	public abstract String getSound();

}
