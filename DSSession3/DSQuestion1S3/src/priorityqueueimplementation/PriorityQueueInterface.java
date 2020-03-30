package priorityqueueimplementation;

public interface PriorityQueueInterface {
	// function to add element to queue
	void enQueue(int element) throws Exception;
	
	//function to remove element from queue
	int deQueue() throws Exception;
	
	//function to check if queue is empty
	Boolean isEmpty();
	
	//function to check if queue is full
	Boolean isFull();

}
