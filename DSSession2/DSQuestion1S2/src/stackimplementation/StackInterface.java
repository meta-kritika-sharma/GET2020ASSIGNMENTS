package stackimplementation;

public interface StackInterface {
	
	//function to push element into stack
	void push(String element) throws Exception;
	
	//function to remove element from top of stack
	String pop() throws Exception;

	//function to check whether stack is empty
	Boolean isEmpty();
	
	//function to return the top most element of stack
	String peek() throws Exception;
}
