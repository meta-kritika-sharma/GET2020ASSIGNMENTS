import java.util.ArrayList;
import java.util.List;

public class Cage {

	/** The total capacity of cage. */
	int totalCapacityOfCage;
	
	/** The current capacity of cage. */
	int currentCapacityOfCage = 0;
	
	/** The type of animal in cage. */
	String typeOfAnimalInCage;

	/**
	 * Instantiates a new cage.
	 *
	 * @param capacityOfCage the capacity of cage
	 * @param typeOfAnimalInCage the type of animal in cage
	 */
	public Cage(int capacityOfCage, String typeOfAnimalInCage) {
		this.totalCapacityOfCage = capacityOfCage;
		this.typeOfAnimalInCage = typeOfAnimalInCage;
	}

	List<Animal> listOfAnimals = new ArrayList<Animal>();

	/**
	 * Adds the animal to cage.
	 *
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param weightOfAnimal the weight of animal
	 * @param carnivorous the carnivorous
	 * @param typeOfAnimal the type of animal
	 * @return true if animal is added successfully, false otherwise.
	 * @throws Exception 
	 */
	public Boolean addAnimalToCage(String nameOfAnimal, int ageOfAnimal,
			int weightOfAnimal, Boolean carnivorous, String typeOfAnimal) throws Exception {
		if ((currentCapacityOfCage < totalCapacityOfCage)
				&& (typeOfAnimalInCage.equalsIgnoreCase(typeOfAnimal))) {
			listOfAnimals.add(new Lion(nameOfAnimal, ageOfAnimal,
					weightOfAnimal, carnivorous));
			currentCapacityOfCage++;

			return true;
		}
		else{
			throw new Exception("Animal can not be added.");
		}
	}

	/**
	 * Adds the animal to cage.
	 *
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param weightOfAnimal the weight of animal
	 * @param flight the flight of bird
	 * @param typeOfAnimal the type of animal
	 * @return true if animal is successfully added , false otherwise.
	 * @throws Exception 
	 */
	public Boolean addAnimalToCage(String nameOfAnimal, int ageOfAnimal,
			int weightOfAnimal, float flight, String typeOfAnimal) throws Exception {
		if ((currentCapacityOfCage < totalCapacityOfCage)
				&& (typeOfAnimalInCage.equalsIgnoreCase(typeOfAnimal))) {
			listOfAnimals.add(new Peacock(nameOfAnimal, ageOfAnimal,
					weightOfAnimal, flight));
			currentCapacityOfCage++;
			return true;
		}
		else{
			throw new Exception("Animal can not be added.");
		}
	}

	/**
	 * Adds the animal to cage.
	 *
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param length the length of animal
	 * @param weightOfAnimal the weight of animal
	 * @param typeOfAnimal the type of animal
	 * @return true if animal is successfully added , false otherwise.
	 * @throws Exception 
	 */
	public Boolean addAnimalToCage(String nameOfAnimal, int ageOfAnimal,
			float length, int weightOfAnimal, String typeOfAnimal) throws Exception {
		if ((currentCapacityOfCage < totalCapacityOfCage)
				&& (typeOfAnimalInCage.equalsIgnoreCase(typeOfAnimal))) {
			listOfAnimals.add(new Crocodile(nameOfAnimal, ageOfAnimal,
					weightOfAnimal, length));
			currentCapacityOfCage++;
			return true;
		}
		else{
			throw new Exception("Animal can not be added.");
		}
	}

	/**
	 * Removes the animal from cage.
	 *
	 * @param id the id
	 * @return true if animal is successfully removed , false otherwise.
	 * @throws Exception 
	 */
	public Boolean removeAnimalFromCage(int id) throws Exception {
		for (Animal iterator : listOfAnimals) {
			if (iterator.getId() == id) {
				listOfAnimals.remove(id);
				return true;
			}
		}
		throw new Exception ("Animal can not be removed.");
	}

}
