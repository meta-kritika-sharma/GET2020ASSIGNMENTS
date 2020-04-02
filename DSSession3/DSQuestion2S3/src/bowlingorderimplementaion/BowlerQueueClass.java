package bowlingorderimplementaion;

import java.util.Arrays;

public class BowlerQueueClass implements BowlerQueueInterface{

	private int sizeOfQueue;
	private Bowler[] priorityQueue;
	private int front;
	private int rear;
	
	//constructor
	public BowlerQueueClass(int sizeOfQueue) throws Exception{
		if (sizeOfQueue<=0){
			throw new Exception ("Enter valid size");
		}
		this.sizeOfQueue = sizeOfQueue;
		this.priorityQueue = new Bowler[this.sizeOfQueue];
		this.front =-1;
		this.rear =-1;
	}
	
	/*
	 * function to add element to queue
	 * @param elemnt to be added
	 * @throws Exception if queue is full
	 */
	@Override
	public void enQueue(Bowler bowler) throws Exception {
			
		if (isFull()){
			throw new Exception ("Queue is full");
		}
		
		//first element being added to queue
		if ((front==-1) && (rear==-1)){
			front = 0;
			rear =0;
			System.out.println(bowler.getNumberOfDeliveries());
			priorityQueue[rear] = bowler;
		}
		else {
			rear = rear+1;
			priorityQueue[rear] = bowler;
			checkHeapforEnqueue(rear);
		}
	}

	/*
	 * function to rearrange elements after enqueue
	 * @param currentElementPosition is the position of latest element entered
	 */
	private void checkHeapforEnqueue(int currentElementPosition) {
		int parentPosition = (currentElementPosition-1)/2;
		while ((parentPosition>=0) && ((priorityQueue[currentElementPosition].getNumberOfDeliveries())>priorityQueue[parentPosition].getNumberOfDeliveries())){
			Bowler temp = priorityQueue[currentElementPosition];
			priorityQueue[currentElementPosition] = priorityQueue[parentPosition];
			priorityQueue[parentPosition] = temp;
			currentElementPosition = parentPosition;
			parentPosition = (parentPosition-1)/2;	
		}
	}
	
	/*
	 * function to remove 
	 */
	@Override
	public Bowler deQueue() throws Exception {

		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}

		Bowler bowler = priorityQueue[0];
		priorityQueue[0] = priorityQueue[rear]; 
		rear--;
		checkHeapForDequeue();
		return bowler;
	}

	/*
	 * function to rearrange elements after dequeue
	 */
	private void checkHeapForDequeue() {
		int leftChild = 1;
		int rightChild = 2;
		int child = 0;
		int parentIndex = 0;
		
		//traversing through the queue
		while ((parentIndex < rear) && (leftChild <= rear)) {
			if (rightChild > rear || priorityQueue[leftChild].getNumberOfDeliveries() > priorityQueue[rightChild].getNumberOfDeliveries()) {
				child = leftChild;
			} else {
				child = rightChild;
			}
			
			//comparing child with parent element
			if (priorityQueue[child].getNumberOfDeliveries() > priorityQueue[parentIndex].getNumberOfDeliveries()) {
				
				//swapping parent and child
				Bowler temp = priorityQueue[child];
				priorityQueue[child] = priorityQueue[parentIndex];
				priorityQueue[parentIndex] = temp;
				parentIndex = child;
				leftChild = 2 * (parentIndex) + 1;
				rightChild = 2 * (parentIndex) + 2;
				
			}
			else{
				break;
			}
		}
	}
	
	/*
	 * function to check  if queue is empty
	 * @return true if queue is empty, false otherwise
	 */
	
	@Override
	public Boolean isEmpty() {
		if (rear==-1){
			return true;
		}
		return false;
	}

	/*
	 * function to check if queue is full
	 * @return true if queue is full, false otherwise
	 */
	
	@Override
	public Boolean isFull() {
		if ((front==0) && (rear==(sizeOfQueue-1))){
			return true;
		}
		return false;
	}
	
	@Override
	public Bowler[] getPriorityQueue(){
		return priorityQueue;
	}
	
	@Override
	public Bowler getFront(){
		return priorityQueue[front];
	}
	
	public void show (){
		for (int i=0;i<rear;i++){
			System.out.println("ele "+priorityQueue[i].getNameOfBowler() + " "+priorityQueue[i].getNumberOfDeliveries());
		}
	}
}
