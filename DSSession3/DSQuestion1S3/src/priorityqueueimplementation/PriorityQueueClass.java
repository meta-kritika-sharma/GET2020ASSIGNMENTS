package priorityqueueimplementation;

public class PriorityQueueClass implements PriorityQueueInterface{

	private int sizeOfQueue;
	private int[] priorityQueue;
	private int front;
	private int rear;
	
	//constructor
	public PriorityQueueClass(int sizeOfQueue) throws Exception{
		if (sizeOfQueue<=0){
			throw new Exception ("Ënter valid size");
		}
		this.sizeOfQueue = sizeOfQueue;
		this.priorityQueue = new int[this.sizeOfQueue];
		this.front =-1;
		this.rear =-1;
	}
	
	/*
	 * function to add element to queue
	 * @param elemnt to be added
	 * @throws Exception if queue is full
	 */
	@Override
	public void enQueue(int element) throws Exception {
			
		if (isFull()){
			throw new Exception ("Queue is full");
		}
		
		//first element being added to queue
		if ((front==-1) && (rear==-1)){
			front = 0;
			rear =0;
			priorityQueue[rear] = element;
		}
		else {
			rear = rear+1;
			priorityQueue[rear] = element;
			checkHeapforEnqueue(rear);
		}
	}

	/*
	 * function to rearrange elements after enqueue
	 * @param currentElementPosition is the position of latest element entered
	 */
	private void checkHeapforEnqueue(int currentElementPosition) {
		int parentPosition = (currentElementPosition-1)/2;
		while ((parentPosition>=0) && ((priorityQueue[currentElementPosition])>priorityQueue[parentPosition])){
			int temp = priorityQueue[currentElementPosition];
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
	public int deQueue() throws Exception {

		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}

		int element = priorityQueue[0];
		priorityQueue[0] = priorityQueue[rear];
		rear--;
		checkHeapForDequeue();
		return element;
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
		while ((parentIndex < rear) && (leftChild < rear) && (rightChild <= rear)) {
			if (priorityQueue[leftChild] > priorityQueue[rightChild]) {
				child = leftChild;
			} else {
				child = rightChild;
			}
			
			//comparing child with parent element
			if (priorityQueue[child] > priorityQueue[parentIndex]) {
				
				//swapping parent and child
				int temp = priorityQueue[child];
				priorityQueue[child] = priorityQueue[parentIndex];
				priorityQueue[parentIndex] = temp;
				parentIndex = child;
				leftChild = 2 * (parentIndex) + 1;
				rightChild = 2 * (parentIndex) + 2;
			} else {
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
		if ((front==0) && (rear==sizeOfQueue-1)){
			return true;
		}
		return false;
	}
	
}
