package undirectedgraphimplementation;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args){

		Main mainObject = new Main ();
		try {
			mainObject.userInput();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//user input function
	private void userInput() throws Exception {
		List<Edge> edges = new ArrayList<Edge>();
		
		//adding new edges to graph
		edges.add(new Edge(0,1,1));
		edges.add(new Edge(0,2,4));
		edges.add(new Edge(1,3,1));
		edges.add(new Edge(1,4,5));
		edges.add(new Edge(2,4,2));
		GraphInterface graph = new GraphImplementation(6, edges);
		
		//checking if graph is connected
		System.out.println(graph.isConnected());
		
		//getting reachable nodes from given node
		List<Integer> list = graph.reachable(2);
		for (int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		//getting minimum spanning tree
		System.out.println(graph.minimumSpanningTree());
		
		//getting shortest path between two vertices
		List<Integer> lists = graph.shortestPath(0, 5);		
		System.out.println("path");
		for (int i=0;i<lists.size();i++){
			System.out.println(lists.get(i));
		}	
	}

}
