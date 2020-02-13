import java.util.Scanner;

public class ZooMain{
	public static void main(String[] args){
		System.out.println("Enetr 1 to add cage to zone.");
		System.out.println("Enetr 2 to add animal to cage.");
		System.out.println("Enter 3 to remove animal from cage.");
		System.out.println("Enter 4 to view list of cages in zone.");
		Zone zone = new Zone(2);
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter choice :");
			int Userchoice = sc.nextInt();

			if (Userchoice == 1){
				System.out.println("Enter Capacity of cage : ");
				int capacity = sc.nextInt();
				System.out.println("Enter type of cage : ");
				String type = sc.next();
				if (zone.addCage(capacity, type) == true){
					System.out.println("Cage added successfully.");
				}
			}
			
			else if (Userchoice == 2){
				System.out.println("Enter type of animal :");
				String typeOfAnimal = sc.next();
				System.out.println("Enter age");
				int age = sc.nextInt();
				System.out.println("Enter weight");
				int weight = sc.nextInt();
				if ("Lion".equals(typeOfAnimal)){
					System.out.println("Enter true if animal is carnivorous , false otherwise.");
					Boolean carnivorous = sc.nextBoolean();
					try{
					if (zone.addAnimalToZone(typeOfAnimal,"Lion", age, weight, carnivorous) == true){
						System.out.println("Animal added successfully.");
					}}
					catch(Exception e){
						System.out.println(e.getMessage());
					}
					}
				
			
				else if ("Peacock".equals(typeOfAnimal)){
					System.out.println("Enter flight of bird :");
					float flight = sc.nextFloat();
					try {
						if (zone.addAnimalToZone(typeOfAnimal,"Peacock", age, weight, flight) == true){
							System.out.println("Animal added successfully.");
						}
					} catch (Exception e) {
						 System.out.println(e.getMessage());
					}
				}
			
				else if ("Crocodile".equals(typeOfAnimal)){
					System.out.println("Enter length of animal :");
					float length = sc.nextFloat();
					try {
						if (zone.addAnimalToZone(typeOfAnimal,"Crocodile", age, weight, length) == true){
							System.out.println("Animal added successfully.");
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			
				else{
					System.out.println("Invalid input");
				}
			}
			else if (Userchoice == 3){
				System.out.println("Enter type of animal :");
				String typeOfAnimal = sc.next();
				System.out.println("Enter id :");
				int id = sc.nextInt();
				try {
					zone.removeAnimalFromZone(typeOfAnimal, id);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else if (Userchoice == 4){
				zone.displayList();
			}
			else if (Userchoice == 5){
				System.out.println("Thanks for using.");
				break;
			}
			else{
				System.out.println("Invalid input");
			}
		}
	}
}
