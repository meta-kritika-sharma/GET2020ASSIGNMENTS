package undirectedgraphimplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//class for implementation of graph
public class GraphUsingLinkedList implements GraphInterface {

	private int numberOfVertices;
	private List<VertexList> adjacencyList;

	// constructor
	public GraphUsingLinkedList(int numberOfVertices, List<Edge> edgeList) throws Exception {
		
		if (numberOfVertices<=0){
			throw new Exception ("Invalid number of vertices");
		}
		
		if (edgeList.size()==0){
			throw new Exception ("Enter valid edge list");
		}
		
		this.numberOfVertices = numberOfVertices;
		this.adjacencyList = new ArrayList<VertexList>(this.numberOfVertices);

		for (Edge edge : edgeList) {
			this.adjacencyList.get(edge.getStart()).addVertex(edge.getEnd(), edge.getWeight());
			this.adjacencyList.get(edge.getEnd()).addVertex(edge.getStart(), edge.getWeight());
		}
	}

	/**
	 * function to check if a graph is connected or not
	 * @return true if graph is connected, false otherwise
	 */
	@Override
	public Boolean isConnected() {
		
		//array to maintain the visited vertices
		int[] visitedVertices = new int[this.numberOfVertices];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		visitedVertices[0] = 1;
		int countOfVertices = 1;
		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			
			//getting the list from adjacency list
			VertexList listOfPositions = adjacencyList.get(vertex);
			
			//traversing through the list of positions
			Node currentNode = listOfPositions.getHead();
			while(currentNode != null) {
				int neighbouringNode = currentNode.getVertex();
				
				//if node is not visited
				if (visitedVertices[neighbouringNode] == 0) {
					stack.push(neighbouringNode);
					visitedVertices[neighbouringNode] = 1;
					countOfVertices++;
				}
				currentNode = currentNode.getNext();
			}
		}

		if (countOfVertices < numberOfVertices) {
			return false;
		}
		return true;
	}

	/**
	 * function to get reachable nodes from a given node
	 * @param inputVertex is the vertex from whic reachable nodes are to be calculated
	 * @throws Exception 
	 */
	@Override
	public List<Integer> reachable(int inputVertex) throws Exception {
		
		if (inputVertex<0){
			throw new Exception ("Enter valid vertex");
		}
		
		int[] visitedVertices = new int[this.numberOfVertices];
		List<Integer> reachableNodes = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(inputVertex);
		visitedVertices[inputVertex] = 1;

		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			VertexList list = adjacencyList.get(vertex);
			Node currentNode = list.getHead();
			while(currentNode != null) {
				int neighbouringNode = currentNode.getVertex();
				if (visitedVertices[neighbouringNode] == 0) {
					stack.push(neighbouringNode);
					visitedVertices[neighbouringNode] = 1;
					reachableNodes.add(neighbouringNode);
				}
				currentNode = currentNode.getNext();
			}
		}
		return reachableNodes;
	}

	/**
	 * function to find the minimum spanning tree
	 * @return graph
	 */
	@Override
	public GraphInterface minimumSpanningTree() throws Exception {
		List<Edge> sortedEdgeList = new ArrayList<Edge>();
		
		for(int i=0;i<this.numberOfVertices;i++) {
			VertexList vertexList = this.adjacencyList.get(i);
			Node currentNode = vertexList.getHead();
			while(currentNode != null) {
				sortedEdgeList.add(new Edge(i, currentNode.getVertex(), currentNode.getWeight()));
				currentNode = currentNode.getNext();
			}
		}
		
		Collections.sort(sortedEdgeList);
		DisjointSet disjoint = new DisjointSet(this.numberOfVertices);
		List<Edge> mstEdges = new ArrayList<Edge>();
		int iterator = 0;
		while ((iterator < sortedEdgeList.size()) && ((mstEdges.size() < (numberOfVertices - 1)))) {
			int startIndex = sortedEdgeList.get(iterator).getStart();
			int endIndex = sortedEdgeList.get(iterator).getEnd();
			
			//checking for the presence of vertices in the same set
			if (!(disjoint.sameSet(startIndex, endIndex))) {
				mstEdges.add(sortedEdgeList.get(iterator));
				disjoint.union(startIndex, endIndex);
			}
			iterator++;
		}
		return new GraphUsingLinkedList(numberOfVertices,mstEdges);
	}

	/**
	 * function to find the shortest path between two given vertices
	 * @return list of path 
	 * @throws Exception if vertices are invalid
	 */
	@Override
	public List<Integer> shortestPath(int source, int destination) throws Exception {

		if ((source<0) || (destination>=numberOfVertices)){
			throw new Exception ("Invalid inputs for vertices");
		}
		
		int[] visitedVertices = new int[this.numberOfVertices];
		Integer[] distance = new Integer[this.numberOfVertices];
		Integer[] previous = new Integer[this.numberOfVertices];
		distance[source] = 0;
		while (true) {
			
			//getting the minimum vertex where distance value is not null and visited value is false
			Integer vertex = minimum(distance, visitedVertices);
			if (vertex == null) {
				break;
			}
			visitedVertices[vertex] = 1;
			VertexList neighbours = adjacencyList.get(vertex);
			Node currentNode = neighbours.getHead();
			
			while(currentNode != null) {
				int neighBourNode = currentNode.getVertex();
				if ((distance[neighBourNode] == null) || (distance[neighBourNode] > distance[vertex] + currentNode.getWeight())) {
					
					//updating the distance of neighbouring node of the current vertex
					distance[neighBourNode] = distance[vertex] + currentNode.getWeight();
					previous[neighBourNode] = vertex;
				}
				currentNode = currentNode.getNext();
			}
		}
		
		//if path does not exist to the vertex
		if (distance[destination]==null){
			return null;
		}
		
		//creating the path list starting from the destination vertex
		List<Integer> pathList = new ArrayList<Integer>();
		Integer destinationVertex = destination;
		while (destinationVertex != null) {
			pathList.add(destinationVertex);
			destinationVertex = previous[destinationVertex];
		}
		Collections.reverse(pathList);
		return pathList;
	}

	/**
	 * function to return the vertex with minimum distance
	 * @param distance array
	 * @param visitedVertices array
	 * @return minimum vertex
	 * @throws Exception if arrays are empty
	 */
	private Integer minimum(Integer[] distance, int[] visitedVertices) throws Exception {
		
		if ((distance.length==0) || (visitedVertices.length==0)){
			throw new Exception ("Invalid arrays");
		}
		
		Integer minimumIndex = null;
		for (int i = 0; i < distance.length; i++) {
			if ((distance[i] != null) && (visitedVertices[i] != 1)) {
				if ((minimumIndex == null) || (minimumIndex > distance[i])) {
					minimumIndex = i;
				}
			}
		}
		return minimumIndex;
	}
}
