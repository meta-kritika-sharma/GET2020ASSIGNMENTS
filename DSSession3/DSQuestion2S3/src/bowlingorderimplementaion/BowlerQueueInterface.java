package bowlingorderimplementaion;

public interface BowlerQueueInterface {
	// function to add element to queue
	void enQueue(Bowler bowler) throws Exception;
	
	//function to remove element from queue
	Bowler deQueue() throws Exception;
	
	//function to check if queue is empty
	Boolean isEmpty();
	
	//function to check if queue is full
	Boolean isFull();

	Bowler[] getPriorityQueue();

	Bowler getFront();
}
