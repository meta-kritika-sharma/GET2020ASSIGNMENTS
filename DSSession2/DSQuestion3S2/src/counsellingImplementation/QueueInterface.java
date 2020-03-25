package counsellingImplementation;

public interface QueueInterface {

	// function to add student to queue
	void enQueue(Student element) throws Exception;

	//function to remove element from queue
	Student deQueue() throws Exception;
	
	//function to check if queue is empty
	Boolean isEmpty();
	
	//function to check if queue is full
	Boolean isFull();

}

