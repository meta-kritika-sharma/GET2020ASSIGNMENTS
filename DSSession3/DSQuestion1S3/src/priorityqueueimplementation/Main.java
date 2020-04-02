package priorityqueueimplementation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Main main = new Main ();
		try{
		main.getUserInput();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void getUserInput() throws Exception{
		int sizeOfQueue;
		System.out.println("Enter size of queue");
		Scanner scanner = new Scanner (System.in);
		sizeOfQueue = scanner.nextInt();
		PriorityQueueInterface priorityqueue = new PriorityQueueClass(sizeOfQueue);
		try {
			while (true){
				System.out.println("Enter 1 to enqueue and 2 to dequeue");
				int choice = scanner.nextInt();
				if (choice==1){
					System.out.println("Enter Element to be pushed");
					int element = scanner.nextInt();
					priorityqueue.enQueue(element);
				}
				else if (choice==2){
					priorityqueue.deQueue();
				}
				else if (choice==3){
					break;
				}
				else{
					throw new Exception ("Invalid choice");
				}
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
