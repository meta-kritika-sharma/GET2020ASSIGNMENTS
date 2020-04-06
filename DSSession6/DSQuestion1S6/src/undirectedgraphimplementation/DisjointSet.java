package undirectedgraphimplementation;

// class for implementing disjoint set
public class DisjointSet {

	//array to store parent element
	Integer parent[];
	
	//constructor
	public DisjointSet(int number) throws Exception{
		
		if (number<=0){
			throw new Exception ("Invalid size");
		}
		this.parent = new Integer[number];
	}
	
	/*
	 * function to find the parent element of a given element
	 * @param element for which parent is to be found
	 * @return parent
	 */
	private int getParent (int element){
		int parentElement = element;
		
		while (this.parent[parentElement]!=null){
			parentElement = this.parent[parentElement];
		}	
		return parentElement;
	}
	
	/*
	 * function to check if two elements belong to the same set
	 * @param first element
	 * @param second element
	 * @return true if element belong to same set, false otherwise
	 */
	public Boolean sameSet(int firstElement , int secondElement){

		if (getParent(firstElement)==getParent(secondElement)){
			return true;
		}
		return false;
	}
	
	/*
	 * function to set parent for second element 
	 */
	public void union (int firstElement, int secondElement){
		int firstElementParent = getParent(firstElement);
		int secondElementParent = getParent(secondElement);
		if (firstElementParent!= secondElementParent){
			this.parent[secondElementParent] = firstElementParent;
		}
	}
}
