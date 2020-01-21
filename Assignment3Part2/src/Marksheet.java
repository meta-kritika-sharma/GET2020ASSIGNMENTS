/*@author Kritika Sharma
 *@date 15-01-2020
 *The class Marksheet reads in grades of n no of students. It contains :
 *Method to Return average of all grades. 
 *Method to Return maximum of all grades.
 *Method to Return minimum of all grades.
 *Method to Return percentage of students passed.
*/

import java.util.*;

public class Marksheet {
	
	public static final int passingMark = 40;
	public float averageOfGrades(int[] gradesArray, int numberOfStudents) throws Exception{
		/*Method to calculate the average of all the grades given as input in an array.
		 * @param gradesArray is an array of all the grades entered by the user.
		 * @numberOfStudents is the number of students whose grades have been entered by the user.
		 * @return a float value of the average of grades.
		 */
		if (numberOfStudents == 0){
			throw new ArithmeticException("Divide by Zero");
		}
		float sum = 0;
		for (int i = 0; i < numberOfStudents; i++){
			sum = sum + gradesArray[i];
		}
		float averageOfGrades = sum / numberOfStudents;
		return averageOfGrades;
	}
	
	public int minimumOfGrades(int[] gradesArray, int numberOfStudents){
		/*Method to find the minimum of all the grades given as input in an array.
		 * @param gradesArray is an array of all the grades entered by the user.
		 * @numberOfStudents is the number of students whose grades have been entered by the user.
		 * @return the minimum value as an integer.
		 */
		
		int minimumGrade = gradesArray[0];
		for (int i = 1; i < numberOfStudents; i++){
			if (gradesArray[i] < minimumGrade){
				minimumGrade = gradesArray[i];
			}
		}
		return minimumGrade;
	}
	
	public int maximumOfGrades(int[] gradesArray, int numberOfStudents){
		/*Method to find the maximum of all the grades given as input in an array.
		 * @param gradesArray is an array of all the grades entered by the user.
		 * @numberOfStudents is the number of students whose grades have been entered by the user.
		 * @return the maximum value as an integer.
		 */
		
		int maximumGrade = gradesArray[0];
		for (int i = 1; i < numberOfStudents; i++){
			if (gradesArray[i] < maximumGrade){
				maximumGrade = gradesArray[i];
			}
		}
		return maximumGrade;
	}
	
	public float percentageOfStudentsPassed(int[] gradesArray, int numberOfStudents){
		/*Method to find the percentage of students who have passed, given that passing grade is >=40.
		 * @param gradesArray is an array of all the grades entered by the user.
		 * @numberOfStudents is the number of students whose grades have been entered by the user.
		 * @return the float value of percentage of students who have passed.
		 */
		
		int numberOfPassedStudents = 0;
		for (int i = 0; i < numberOfStudents; i++){
			if (gradesArray[i] >= passingMark){
				numberOfPassedStudents += 1;
			}
		}
		float percentageOfPassingStudents = (float) (numberOfPassedStudents * 100.0) / numberOfStudents;
		return percentageOfPassingStudents;
	}

	public void userInput(){
		/*Method to get user choice, number of students and grades as input
		 * @throw java.util.InputMismatchException if any input which is not acceptable is entered by the user.For eg : if the user enters char/string value instead of integer in the userchoice.
		 * @throw ArithmeticException 
		 */
		
		System.out.println("Enter 1 for average of all grades.");
		System.out.println("Enter 2 for finding the minimum of all grades.");
		System.out.println("Enter 3 for finding the maximum of all grades.");
		System.out.println("Enter 4 for getting percentage of students passed.");
		System.out.println("Enter 5 to exit.");
		int userChoice;
		int flag = 0;
		while(flag == 0){
			
			Scanner sc = new Scanner(System.in);
			try{
				System.out.println("Enter number of students :");
				int numberOfStudents = sc.nextInt();
				if (numberOfStudents != 0){
					int[] arrayOfGrades = new int[numberOfStudents];
					for (int i = 0; i < numberOfStudents; i++){
						System.out.println("Enter marks for student " + (i + 1) + " : ");
						arrayOfGrades[i] = sc.nextInt();
					}
					System.out.println("Enter choice:");
					userChoice = sc.nextInt();
					if (userChoice == 1){
						System.out.printf("The average of grades is : %.2f\n" , (averageOfGrades(arrayOfGrades, numberOfStudents)));
					}
					else if (userChoice == 2){
						System.out.println("The minimum of all the grades is : " + (minimumOfGrades(arrayOfGrades, numberOfStudents)));
					}
					else if (userChoice == 3){
						System.out.println("The maximum of all the grades is : " + (maximumOfGrades(arrayOfGrades, numberOfStudents)));
					}
					else if (userChoice == 4){
						System.out.println("The percentage of students passed is : " + (percentageOfStudentsPassed(arrayOfGrades, numberOfStudents)));
					}
				}
				else{
					System.out.println("Please enter a non zero number of students.");
				}
			}
			
			catch(java.util.InputMismatchException e){
				System.out.println("Invalid input. Please enter your input again.");
			}
			catch(ArithmeticException e){
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println("Exception occured.");;
			}
		}
	}
	
	public static void main(String args[]){
		Marksheet object = new Marksheet();
		object.userInput();
	}
}
