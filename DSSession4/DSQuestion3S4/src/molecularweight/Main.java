package molecularweight;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		try {
			main.userInput();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	// function to get user input
	private void userInput() {
		MolecularWeight weight = new MolecularWeight("C2H(OH2)2OH");
		System.out.println(weight.getMolecularWeight());
	}

}
