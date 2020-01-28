/**
 * The Class Animal.
 */
public abstract class Animal {
	
	/** The name of animal. */
	public String nameOfAnimal;
	
	/** The age of animal. */
	public int ageOfAnimal;
	
	/** The weight of animal. */
	public int weightOfAnimal;
	
	/** The id. */
	public int id;
	
	/** The total animals in zoo. */
	public static int totalAnimalsInZoo;
 
	/**
	 * Instantiates a new animal.
	 *
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param weightOfAnimal the weight of animal
	 */
	public Animal(String nameOfAnimal, int ageOfAnimal, int weightOfAnimal) {
		this.nameOfAnimal = nameOfAnimal;
		this.ageOfAnimal = ageOfAnimal;
		this.weightOfAnimal = weightOfAnimal;
		this.id = totalAnimalsInZoo++;
	}

	/**
	 * Gets the name of animal.
	 *
	 * @return the name of animal
	 */
	public String getNameOfAnimal() {
		return nameOfAnimal;
	}

	/**
	 * Gets the age of animal.
	 *
	 * @return the age of animal
	 */
	public int getAgeOfAnimal() {
		return ageOfAnimal;
	}

	/**
	 * Gets the weight of animal.
	 *
	 * @return the weight of animal
	 */
	public int getWeightOfAnimal() {
		return weightOfAnimal;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the class of animal.
	 *
	 * @return the class of animal
	 */
	public abstract String getClassOfAnimal();

	/**
	 * Gets the sound.
	 *
	 * @return the sound
	 */
	public abstract String getSound();

	/**
	 * Type of animal.
	 *
	 * @return the string
	 */
	public abstract String typeOfAnimal();

}
