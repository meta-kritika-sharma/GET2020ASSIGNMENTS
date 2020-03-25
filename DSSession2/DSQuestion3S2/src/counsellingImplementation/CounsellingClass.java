package counsellingImplementation;

import java.util.HashMap;
import java.util.Map;
import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

//counsellor class
public class CounsellingClass {
	private Map<String, Program> programs;
	
	//queue for students
	private QueueInterface students;
	
	/**
	 * Constructor
	 * @throws Exception
	 */
	public CounsellingClass() throws Exception {
		
		//map of program name and program object
		programs = new HashMap<String, Program>();
		fetchStudentData("files/Student.xls");
		fetchProgramData("files/Program.xls");
	}
	
	/**
	 * Function to fetch data of programs from excel sheet
	 * @param fileSource is the program excel sheet
	 * @throws Exception if fileSource is null String
	 * @throws Exception if sheet is not found
	 */
	private void fetchProgramData(String fileSource) throws Exception {
		if(fileSource == null){
			throw new Exception("Null fileSource");
		}
		
		//accessing excel document
		Workbook programWorkbook = Workbook.getWorkbook(new File("files/Program.xls"));
		if(programWorkbook == null){
			throw new Exception("No Sheet found!");
		}
		
		//accessing the first excel sheet
		Sheet programSheet = programWorkbook.getSheet(0);
		
		//getting the total number of rows of data in sheet
		int programSheetRows = programSheet.getRows();
		
		//traversing through the sheet
		for(int i=0;i<programSheetRows;i++){
			String programName = programSheet.getCell(0,i).getContents();
			int availableSeats = Integer.parseInt(programSheet.getCell(1,i).getContents());
			programs.put(programName, new Program(programName, availableSeats));
		}
		programWorkbook.close();
	}
	
	/**
	 * Function to fetch data of Students from excel sheet
	 * @param fileSource is the student excel sheet
	 * @throws Exception if fileSource is null String
	 * @throws Exception if sheet is not found
	 */
	
	private void fetchStudentData(String fileSource) throws Exception {
		if(fileSource == null){
			throw new Exception("Null fileSource");
		}
		
		//accessing excel document
		Workbook studentWorkbook = Workbook.getWorkbook(new File("files/Student.xls"));
		if(studentWorkbook == null){
			throw new Exception("No Sheet found!");
		}
		
		//accessing the first excel sheet
		Sheet studentSheet = studentWorkbook.getSheet(0);
		int studentSheetRows = studentSheet.getRows();
		students = new QueueClass(studentSheetRows);
		for(int i=0;i<studentSheetRows;i++){
			String studentName = studentSheet.getCell(0, i).getContents();
			String[] preference = new String[5];
			for(int j=1;j<=5;j++){
				preference[j-1] = studentSheet.getCell(j ,i).getContents();
			}
			students.enQueue(new Student(studentName, preference));
		}
		studentWorkbook.close();
	}
	
	/**
	 * Function to allocate Programs to students rank-wise
	 * @throws Exception if workbook is not created
	 * @throws Exception if preference is invalid
	 */
	
	public void allocatePrograms() throws Exception {
		WritableWorkbook allocationWorkbook = Workbook.createWorkbook(new File("files/Allocation.xls"));
		WritableSheet allocationSheet = allocationWorkbook.createSheet("Allocation", 0);
		int index = 0;
		
		while(!students.isEmpty()) {
			Student student = students.deQueue();

			for(String preference: student.getProgramPreference()){
				if(programs.get(preference) == null){
					throw new Exception("Invalid Preference Found!");
				}
				
				if(programs.get(preference).isSeatAvailable()){
					student.setAllocatedProgram(preference);
					programs.get(preference).occupySeat();
					break;
				}
			}	
			allocationSheet.addCell(new Label(0, index, student.getName()));
			allocationSheet.addCell(new Label(1, index, student.getAllocatedProgram()));
			index++;
		}
		allocationWorkbook.write();
		allocationWorkbook.close();
	}
	
}
