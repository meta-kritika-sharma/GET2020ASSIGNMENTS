package counsellingImplementation;

//student class
public class Student {
	private String studentName;
	
	//array of preferences of program
	private String[] preferenceOfProgram;
	private String programAllocated;
	
	/**
	 * Constructor
	 * @param name of student
	 * @param programPreference is the array of preferences
	 */
	public Student(String name, String[] programPreference){
		this.studentName = name;
		this.preferenceOfProgram = new String[programPreference.length];
		for(int i=0;i<programPreference.length;i++){
			this.preferenceOfProgram[i] = programPreference[i];
		}
		this.programAllocated = "Not Allocated";
	}

	//getters and setters
	
	public String getName() {
		return this.studentName;
	}
	
	public String[] getProgramPreference(){
		return this.preferenceOfProgram;
	}
	
	public String getAllocatedProgram(){
		return this.programAllocated;
	}
	
	public void setAllocatedProgram(String allocatedProgram){
		this.programAllocated = allocatedProgram;
	}
}
