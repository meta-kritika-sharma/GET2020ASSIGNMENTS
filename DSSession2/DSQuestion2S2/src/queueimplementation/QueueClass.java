package queueimplementation;

public class QueueClass implements QueueInterface{

	private int[] queue;
	private int front;
	private int rear;
	private int sizeOfQueue;

	//constructor
	public QueueClass(int sizeOfQueue){
		this.sizeOfQueue = sizeOfQueue;
		this.queue = new int[sizeOfQueue];
		this.front = -1;
		this.rear = -1;
	}
	
	/*
	 * function to add element to queue
	 * @param element to be added
	 * @throw Exception when queue is full
	 */
	
	@Override
	public void enQueue(int element) throws Exception {
		
		if (isFull()){
			throw new Exception ("Queue is full");
		}
		
		if (isEmpty()){
			rear = 0;
			front = 0;
		}
		else{
			rear =  (rear+1)%sizeOfQueue;
		}
		queue[rear] = element;
	}

	/*
	 * function to remove element from queue
	 * @throw Exception when queue is empty
	 */
	
	@Override
	public int deQueue() throws Exception {
		
		if (isEmpty()){
			throw new Exception ("Queue is empty");	
		}
		
		int element = queue[front];
		if (front == rear){
			front =-1;
			rear=-1;
		}
		front = (front+1)%sizeOfQueue;
		return element;
	}

	/*
	 * function to check if queue is empty 
	 * @return true if queue is empty , false otherwise
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
		if (((front==0) && (rear == sizeOfQueue-1)) || (front == ((rear+1)%sizeOfQueue))) {
			return true;
		}
		return false;
	}	
}
