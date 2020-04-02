package undirectedgraphimplementation;

//class for edge
public class Edge implements Comparable<Edge>{
	
	private int start;
	private int end;
	private int weight;

	//constructor
	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	//getters and setters
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/*
	 * function to compare edges based on their weight
	 */
	@Override
	public int compareTo(Edge edge) {
		return this.weight - edge.getWeight();
	}
}
