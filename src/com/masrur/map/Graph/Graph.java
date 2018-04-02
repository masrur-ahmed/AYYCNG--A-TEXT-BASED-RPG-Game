/**
 * 
 */
package com.masrur.map.Graph;
import com.masrur.map.Node.NodeMap;
import java.util.*;

/**
 * @author JAVA
 *
 */

public class Graph {
  private ArrayList<NodeMap> vertices;
	public Graph(int numberVertices, String area[]){
		vertices = new ArrayList<NodeMap>(numberVertices);
		for(int i=0;i<numberVertices;i++){
			vertices.add(new NodeMap(i,area[i]));
		}
	}
	
	public void addEdge(int src, int dest, int weight){
		NodeMap s = vertices.get(src);
		Edge new_edge = new Edge(vertices.get(dest),weight);
		s.neighbours.add(new_edge);
	}
	
	public ArrayList<NodeMap> getVertices() {
		return vertices;
	}
	
	public NodeMap getNodeMap(int vert){
		return vertices.get(vert);
	}
	public NodeMap getVertex(int vert){
		return vertices.get(vert);
	}
}