package undirectedgraphimplementation;

import java.util.List;

public interface GraphInterface {
	
	/**
	 * function to check if a graph is connected or not
	 * @return true if graph is connected, false otherwise
	 */
	Boolean isConnected();

	/**
	 * function to get reachable nodes from a given node
	 * @param inputVertex is the vertex from whic reachable nodes are to be calculated
	 * @throws Exception 
	 */
	List<Integer> reachable(int vertex) throws Exception;
	
	/**
	 * function to find the minimum spanning tree
	 * @return graph
	 */
	GraphInterface minimumSpanningTree() throws Exception;
	
	/**
	 * function to find the shortest path between two given vertices
	 * @return list of path 
	 * @throws Exception 
	 */
	List<Integer> shortestPath(int source, int destination) throws Exception;
	
}
