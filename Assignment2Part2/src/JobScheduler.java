/*@author Kritika Sharma
 *@date : 14-01-2020
 *Class JobScheduler simulates FCFS (First Come First Serve) scheduling algorithm. Number of processes are received with their arrival time and burst time seconds in a two dimensional array as input. 
 *It contains methods to :
 *Calculate completion time for each process. 
 *Calculate waiting time for each process.
 *Calculate turn around time for each process.
 *Average waiting time of processes.
 *Maximum waiting time period for a process in queue.
 */

import java.util.*;

public class JobScheduler {
	public int[] completionTime(int inputArray[][], int rowSize)
	{
		/*Method to calculate completion time for each process.
		 * @param A 2-d integer array containing the arrival time and burst time in each row.
		 * @param RowSize defining the number of processes.
		 * @return an integer array consisting of completion time for each process.
		 */
		
		int completeTime = 0;
		int[] completionTimeArray = new int[rowSize];
		completionTimeArray[0] = inputArray[0][1] - inputArray[0][0];
		completeTime = completionTimeArray[0];
		for (int i = 1 ; i < rowSize ; i++){
			if (inputArray[i-1][1] > inputArray[i][0]){
				completeTime =  completeTime + inputArray[i][1]; 
			}
			else{
				completeTime = inputArray[i][0] + inputArray[i][1];
			}
			completionTimeArray[i] = completeTime;
		}
		return completionTimeArray;
	}
	
	public int[] waitingTime(int inputArray[][], int rowSize){
		/*Method to calculate waiting time for each process.
		 * @param A 2-d integer array containing the arrival time and burst time in each row.
		 * @param RowSize defining the number of processes.
		 * @return an integer array consisting of waiting time for each process.
		 */

		int[] waitingArray = new int[rowSize];
		waitingArray = turnAroundTime(inputArray,rowSize);
		for (int i = 0 ; i < rowSize ; i++){
			waitingArray[i] = waitingArray[i] - inputArray[i][1];
		}
		return waitingArray;
	}
	
	public int[] turnAroundTime(int inputArray[][], int rowSize){
		/*Method to calculate turn around time for each process.
		 * @param A 2-d integer array containing the arrival time and burst time in each row.
		 * @param RowSize defining the number of processes.
		 * @return an integer array consisting of turn around time for each process.
		 */
		
		int[] turnAroundArray = new int[rowSize];
		turnAroundArray = completionTime(inputArray,rowSize);
		for (int i = 0 ; i < rowSize ; i++){
			turnAroundArray[i] = turnAroundArray[i] - inputArray[i][0];
		}
		return turnAroundArray;
	}
	
	
	public void userInput(){
		//Method to get user choice and input.
		
		int numberOfInputs;
		int flag = 0;
		int userChoice = 0;
		while(flag == 0){
			try{
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter number of processes or enter -1 to quit : ");
				numberOfInputs = sc.nextInt();
				if(numberOfInputs == -1){
					System.out.println("Thanks for using.");
					flag = 1;
				}
				else{
					int inputMatrix[][] = new int[numberOfInputs][2]; 
					System.out.println("Enter the arrival and burst time for each process:");
					for(int i = 0 ; i<numberOfInputs ; i++){
						for(int j = 0 ; j < 2 ; j++){
							inputMatrix[i][j] = sc.nextInt(); 
						}
					}
					System.out.println("Enter 1 to calculate completion time for each process.");
					System.out.println("Enter 2 to calculate waiting time for each process.");
					System.out.println("Enter 3 to calculate turnaround time for each process.");
					System.out.println("Enter 4 to calculate avaerage waiting time.");
					System.out.println("Enter 5 to calculate maximum waiting time.");
					System.out.println("Enter -1 to exit.");
					System.out.println("Enter your choice : ");
					userChoice = sc.nextInt();
					while(userChoice != -1){
						if (userChoice == 1){
							int[] result = new int[numberOfInputs]; 
							result = completionTime(inputMatrix, numberOfInputs);
							for (int i = 0 ; i < numberOfInputs ; i++){
								System.out.println("Completion time for process " + (i + 1) + "is " + result[i]);
							}
						}
					
						else if (userChoice == 2){
							int[] result = new int[numberOfInputs]; 
							result = waitingTime(inputMatrix, numberOfInputs);
							for (int i = 0 ; i < numberOfInputs ; i++){
								System.out.println("Waiting time for process " + (i + 1) + "is " + result[i]);
							}
						}

						else if (userChoice == 3){
							int[] result = new int[numberOfInputs]; 
							result = turnAroundTime(inputMatrix, numberOfInputs);
							for (int i = 0 ; i < numberOfInputs ; i++){
								System.out.println("TurnAroundTime time for process " + (i+1) + "is " + result[i]);
							}
						}
					
						else if (userChoice == 4){
							int[] result = new int[numberOfInputs]; 
							result = waitingTime(inputMatrix , numberOfInputs);
							float sum = 0;
							for (int i = 0 ; i < numberOfInputs ; i++){
								sum = sum + result[i];
								System.out.println("Sum=" + sum);
							}
							float averageWaitingTime = sum / numberOfInputs;
							System.out.println("The Average Waiting Time is " + averageWaitingTime);
						}
					
						else if (userChoice == 5){
							int[] result = new int[numberOfInputs]; 
							result = waitingTime(inputMatrix,numberOfInputs);
							int maximumWaitingTime = result[0];
							for (int i = 0 ; i < numberOfInputs ; i++){
								if(result[i] > maximumWaitingTime){
									maximumWaitingTime = result[i];
								}
							}
							System.out.println("The Maximum Waiting Time is " + maximumWaitingTime);
						}
						System.out.println("Enter your choice : ");
						userChoice = sc.nextInt();
					}
					flag = 1;
				}
			}
			
			catch(Exception e){
				System.out.println("Invalid input");
			}
		}
	}
	
	public static void main(String args[]){
		JobScheduler object = new JobScheduler();
		object.userInput();
	}
}
