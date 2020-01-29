
import java.util.ArrayList;
import java.util.List;

public class Zone {

	/** The total capacity of zone. */
	final int totalCapacityOfZone;
	
	/** The current capacity of zone. */
	int currentCapacityOfZone;
	
	/** The list of cages in zone. */
	List<Cage> listOfCagesInZone;

	/**
	 * Instantiates a new zone.
	 *
	 * @param capacityOfZone the capacity of zone
	 */
	public Zone(int capacityOfZone) {
		this.totalCapacityOfZone = capacityOfZone;
		this.currentCapacityOfZone = capacityOfZone;
		listOfCagesInZone = new ArrayList<Cage>();
	}

	/**
	 * Adds the cage.
	 *
	 * @param capacityOfCage the capacity of cage
	 * @param typeOfCageInAnimal the type of cage in animal
	 * @return calls add animal to cage if successful, false otherwise
	 */
	public Boolean addCage(int capacityOfCage, String typeOfCageInAnimal) {
		if (currentCapacityOfZone > 0) {
			listOfCagesInZone.add(new Cage(capacityOfCage, typeOfCageInAnimal));
			currentCapacityOfZone--;
			return true;
		}
		return false;
	}

	/**
	 * Adds the animal to zone.
	 *
	 * @param typeOfAnimalInCage the type of animal in cage
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param weightOfAnimal the weight of animal
	 * @param carnivorous the carnivorous
	 * @return calls add animal to cage if successful, false otherwise
	 * @throws Exception 
	 */
	public Boolean addAnimalToZone(String typeOfAnimalInCage,
			String nameOfAnimal, int ageOfAnimal, int weightOfAnimal,
			Boolean carnivorous) throws Exception {
		for (Cage c : listOfCagesInZone) {
			if (c.typeOfAnimalInCage.equals(typeOfAnimalInCage)) {
				return c.addAnimalToCage(nameOfAnimal, ageOfAnimal,
						weightOfAnimal, carnivorous, typeOfAnimalInCage);
			}
		}
		throw new Exception ("Cage for the given type does not exist");
		
	}

	/**
	 * Adds the animal to zone.
	 *
	 * @param typeOfAnimalInCage the type of animal in cage
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param weightOfAnimal the weight of animal
	 * @param flight the flight
	 * @return calls add animal to cage if successful, false otherwise
	 * @throws Exception 
	 */
	public Boolean addAnimalToZone(String typeOfAnimalInCage,
			String nameOfAnimal, int ageOfAnimal, int weightOfAnimal,
			float flight) throws Exception {
		for (Cage c : listOfCagesInZone) {
			if (c.typeOfAnimalInCage.equals(typeOfAnimalInCage)) {
				return c.addAnimalToCage(nameOfAnimal, ageOfAnimal,
						weightOfAnimal, flight, typeOfAnimalInCage);
			}
		}
		throw new Exception ("Cage for the given type does not exist");

	}

	/**
	 * Adds the animal to zone.
	 *
	 * @param typeOfAnimalInCage the type of animal in cage
	 * @param nameOfAnimal the name of animal
	 * @param ageOfAnimal the age of animal
	 * @param length the length
	 * @param weightOfAnimal the weight of animal
	 * @return calls add animal to cage if successful, false otherwise
	 * @throws Exception 
	 */
	public Boolean addAnimalToZone(String typeOfAnimalInCage,
			String nameOfAnimal, int ageOfAnimal, float length,
			int weightOfAnimal) throws Exception {
		for (Cage c : listOfCagesInZone) {
			if (c.typeOfAnimalInCage.equals(typeOfAnimalInCage)) {
				return c.addAnimalToCage(nameOfAnimal, ageOfAnimal, length,
						weightOfAnimal, typeOfAnimalInCage);
			}
		}
		throw new Exception ("Cage for the given type does not exist");

	}

	/**
	 * Removes the animal from zone.
	 *
	 * @param typeOfAnimalInCage the type of animal in cage
	 * @param id the id
	 * @return calls remove animal from cage if successful, false otherwise
	 * @throws Exception 
	 */
	public Boolean removeAnimalFromZone(String typeOfAnimalInCage, int id) throws Exception {
		for (Cage c : listOfCagesInZone) {
			if (c.typeOfAnimalInCage.equals(typeOfAnimalInCage)) {
				return c.removeAnimalFromCage(id);
			}
		}
		throw new Exception ("Cage for the given type does not exist");
	}
	
	public void displayList(){
		for (Cage c : listOfCagesInZone){
			System.out.println("Capacity of cage is : "+c.totalCapacityOfCage);
			System.out.println("Type of Animal in cage : "+c.typeOfAnimalInCage);
		}
	}
}
