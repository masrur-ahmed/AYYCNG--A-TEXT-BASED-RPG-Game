/**
 * 
 */
package com.masrur.map.MapImple.MapApplied;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import com.masrur.map.Graph.Edge;
import com.masrur.map.MapImple.MapInterface;
import com.masrur.map.Node.NodeMap;

/**
 * @author Masrur
 *
 */
public class MapRPG implements MapInterface {
	List<NodeMap>mp;

	/* (non-Javadoc)
	 * @see com.masrur.MapImple.MapInterface#calculate(com.masrur.Node.NodeMap)
	 */
	@Override
public void calculate(NodeMap source){
		
		source.findM = (double) 0;
		PriorityQueue<NodeMap> queue = new PriorityQueue<NodeMap>();
		queue.add(source);
		
		while(!queue.isEmpty()){
			
			NodeMap u = queue.poll();
		
			for(Edge neighbour:u.neighbours){
				Double newDist = u.findM+neighbour.weight;
				
				if(neighbour.target.findM>newDist){
					// Remove the node from the queue to update the distance value.
					queue.remove(neighbour.target);
					neighbour.target.findM = newDist;
					
					// Take the path visited till now and add the new node.s
					neighbour.target.path = new LinkedList<NodeMap>(u.path);
					neighbour.target.path.add(u);
					
					//Reenter the node with new distance.
					queue.add(neighbour.target);					
				}
			}
		}
	}
}
