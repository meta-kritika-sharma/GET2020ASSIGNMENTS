package undirectedgraphimplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//class for implementation of graph
public class GraphImplementation implements GraphInterface {

	private int numberOfVertices;
	private List<Edge> edgeList;
	private List<List<Integer>> adjacencyList;

	// constructor
	public GraphImplementation(int numberOfVertices, List<Edge> edgeList) throws Exception {
		
		if (numberOfVertices<=0){
			throw new Exception ("Invalid number of vertices");
		}
		
		if (edgeList.size()==0){
			throw new Exception ("Enter valid edge list");
		}
		
		this.numberOfVertices = numberOfVertices;

		// edge list for undirected graph
		this.edgeList = new ArrayList<Edge>(edgeList.size() * 2);
		this.adjacencyList = new ArrayList<List<Integer>>(this.numberOfVertices);

		// traversing through the input edge list to create
		for (Edge edge : edgeList) {
			this.edgeList.add(edge);
			if (edge.getStart() != edge.getEnd()) {
				this.edgeList.add(new Edge(edge.getEnd(), edge.getStart(), edge
						.getWeight()));
			}
		}

		// creation of adjacency list
		for (int iterator = 0; iterator < numberOfVertices; iterator++) {
			List<Integer> tempList = new ArrayList<Integer>();
			for (int innerIterator = 0; innerIterator < this.edgeList.size(); innerIterator++) {
				if (this.edgeList.get(innerIterator).getStart() == iterator) {
					tempList.add(innerIterator);
				}
			}
			
			//adding list of vertices to the adjacency list
			if (tempList.size() != 0) {
				adjacencyList.add(iterator, tempList);
			}
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
			List<Integer> listOfPositions = adjacencyList.get(vertex);
			
			//traversing through the list of positions
			for (int iterator = 0; iterator < listOfPositions.size(); iterator++) {
				int neighbouringNode = edgeList.get(listOfPositions.get(iterator)).getEnd();
				
				//if node is not visited
				if (visitedVertices[neighbouringNode] == 0) {
					stack.push(neighbouringNode);
					visitedVertices[neighbouringNode] = 1;
					countOfVertices++;
				}
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
		int count = 1;
		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			List<Integer> list = adjacencyList.get(vertex);
			for (int iterator = 0; iterator < list.size(); iterator++) {
				int neighbouringNode = edgeList.get(list.get(iterator)).getEnd();
				if (visitedVertices[neighbouringNode] == 0) {
					stack.push(neighbouringNode);
					visitedVertices[neighbouringNode] = 1;
					reachableNodes.add(neighbouringNode);
				}
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
		List<Edge> sortedEdgeList = edgeList;
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
		return new GraphImplementation(numberOfVertices,mstEdges);
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
			List<Integer> neighbour = adjacencyList.get(vertex);
			for (int iterator = 0; iterator < neighbour.size(); iterator++) {
				int neighBourNode = edgeList.get(neighbour.get(iterator)).getEnd();
				if ((distance[neighBourNode] == null) || (distance[neighBourNode] > distance[vertex] + edgeList.get(neighbour.get(iterator)).getWeight())) {
					
					//updating the distance of neighbouring node of the current vertex
					distance[neighBourNode] = distance[vertex] + edgeList.get(neighbour.get(iterator)).getWeight();
					previous[neighBourNode] = vertex;
				}
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
